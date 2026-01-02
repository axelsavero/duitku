package com.example.duitku.ui.navigation

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.duitku.data.model.Transaction
import com.example.duitku.data.model.TransactionType
import com.example.duitku.data.model.Account
import com.example.duitku.data.model.AccountType
import com.example.duitku.data.repository.DuitKuRepository
import com.example.duitku.data.util.CsvExporter
import com.example.duitku.ui.screens.AccountsScreen
import com.example.duitku.ui.screens.AddTransactionScreen
import com.example.duitku.ui.screens.HomeScreen
import com.example.duitku.ui.screens.NotificationSettingScreen
import kotlinx.coroutines.launch

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AddTransaction : Screen("add_transaction")
    object EditTransaction : Screen("edit_transaction/{transactionId}") {
        fun createRoute(transactionId: String) = "edit_transaction/$transactionId"
    }
    object Accounts : Screen("accounts")
    object NotificationSetting : Screen("notification_setting")
}

@Composable
fun NavGraph(
    navController: NavHostController,
    repository: DuitKuRepository
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val transactions by repository.allTransactions.collectAsState(initial = emptyList())
    val accounts by repository.allAccounts.collectAsState(initial = emptyList())
    val totalBalance = accounts.sumOf { it.balance }
    
    // State to hold CSV content for export
    var csvContentToSave by remember { mutableStateOf("") }
    
    // File picker launcher for saving CSV
    val createDocumentLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.CreateDocument("text/csv")
    ) { uri ->
        uri?.let {
            try {
                context.contentResolver.openOutputStream(it)?.use { outputStream ->
                    outputStream.write(csvContentToSave.toByteArray())
                }
                Toast.makeText(context, "File berhasil disimpan", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(context, "Gagal menyimpan file: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                transactions = transactions,
                accounts = accounts,
                totalBalance = totalBalance,
                onNavigateToAddTransaction = {
                    navController.navigate(Screen.AddTransaction.route)
                },
                onNavigateToAccounts = {
                    navController.navigate(Screen.Accounts.route)
                },
                onNavigateToNotificationSettings = { navController.navigate(Screen.NotificationSetting.route) },
                onEditTransaction = { transaction ->
                    navController.navigate(Screen.EditTransaction.createRoute(transaction.id))
                },
                onDeleteTransaction = { transaction ->
                    scope.launch {
                        repository.deleteTransaction(transaction)
                    }
                },
                onExportCsv = { csvContent ->
                    csvContentToSave = csvContent
                    val filename = CsvExporter.generateFilename()
                    createDocumentLauncher.launch(filename)
                }
            )
        }

        composable(Screen.AddTransaction.route) {
            AddTransactionScreen(
                accounts = accounts,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToAccounts = {
                    navController.navigate(Screen.Accounts.route) {
                        popUpTo(Screen.AddTransaction.route) { inclusive = true }
                    }
                },
                onSaveTransaction = { type, amount, category, description, date, accountId ->
                    scope.launch {
                        repository.insertTransaction(
                            Transaction(
                                type = type,
                                amount = amount,
                                category = category,
                                description = description,
                                date = date,
                                accountId = accountId
                            )
                        )
                        navController.popBackStack()
                    }
                }
            )
        }

        composable(
            route = Screen.EditTransaction.route,
            arguments = listOf(navArgument("transactionId") { type = NavType.StringType })
        ) { backStackEntry ->
            val transactionId = backStackEntry.arguments?.getString("transactionId") ?: ""
            val transactionToEdit = transactions.find { it.id == transactionId }
            
            // Store the original transaction for balance calculation
            var originalTransaction by remember { mutableStateOf(transactionToEdit) }
            
            if (transactionToEdit != null) {
                AddTransactionScreen(
                    accounts = accounts,
                    transactionToEdit = transactionToEdit,
                    onNavigateBack = { navController.popBackStack() },
                    onNavigateToAccounts = {
                        navController.navigate(Screen.Accounts.route) {
                            popUpTo(Screen.EditTransaction.route) { inclusive = true }
                        }
                    },
                    onSaveTransaction = { _, _, _, _, _, _ -> },
                    onUpdateTransaction = { updatedTransaction ->
                        scope.launch {
                            originalTransaction?.let { oldTx ->
                                repository.updateTransaction(oldTx, updatedTransaction)
                            }
                            navController.popBackStack()
                        }
                    }
                )
            }
        }

        composable(Screen.Accounts.route) {
            AccountsScreen(
                accounts = accounts,
                totalBalance = totalBalance,
                onNavigateBack = { navController.popBackStack() },
                onAddAccount = { name, type, balance ->
                    scope.launch {
                        val (icon, color) = when (type) {
                            AccountType.EWALLET -> "💳" to "purple"
                            AccountType.BANK -> "🏦" to "blue"
                            AccountType.CASH -> "💵" to "green"
                        }
                        repository.insertAccount(
                            Account(
                                name = name,
                                type = type,
                                balance = balance,
                                icon = icon,
                                color = color
                            )
                        )
                    }
                },
                onEditAccount = { account ->
                    scope.launch {
                        repository.updateAccount(account)
                    }
                },
                onDeleteAccount = { account ->
                    scope.launch {
                        repository.deleteAccount(account)
                    }
                }
            )
        }

        composable(Screen.NotificationSetting.route) {
            NotificationSettingScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
