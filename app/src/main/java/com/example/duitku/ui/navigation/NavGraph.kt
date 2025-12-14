package com.example.duitku.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.duitku.data.model.Transaction
import com.example.duitku.data.model.TransactionType
import com.example.duitku.data.model.Account
import com.example.duitku.data.model.AccountType
import com.example.duitku.data.repository.DuitKuRepository
import com.example.duitku.ui.screens.AccountsScreen
import com.example.duitku.ui.screens.AddTransactionScreen
import com.example.duitku.ui.screens.HomeScreen
import kotlinx.coroutines.launch

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AddTransaction : Screen("add_transaction")
    object Accounts : Screen("accounts")
}

@Composable
fun NavGraph(
    navController: NavHostController,
    repository: DuitKuRepository
) {
    val scope = rememberCoroutineScope()
    val transactions by repository.allTransactions.collectAsState(initial = emptyList())
    val accounts by repository.allAccounts.collectAsState(initial = emptyList())
    val totalBalance = accounts.sumOf { it.balance }

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                transactions = transactions,
                totalBalance = totalBalance,
                onNavigateToAddTransaction = {
                    navController.navigate(Screen.AddTransaction.route)
                },
                onNavigateToAccounts = {
                    navController.navigate(Screen.Accounts.route)
                },
                onDeleteTransaction = { transaction ->
                    scope.launch {
                        repository.deleteTransaction(transaction)
                    }
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
                onDeleteAccount = { account ->
                    scope.launch {
                        repository.deleteAccount(account)
                    }
                }
            )
        }
    }
}