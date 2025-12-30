package com.example.duitku.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.text.KeyboardOptions
import com.example.duitku.data.model.Account
import com.example.duitku.data.model.Transaction
import com.example.duitku.data.model.TransactionType
import com.example.duitku.ui.components.TrendingUp
import com.example.duitku.ui.components.Trending_down
import java.time.LocalDate


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTransactionScreen(
    accounts: List<Account>,
    transactionToEdit: Transaction? = null,
    onNavigateBack: () -> Unit,
    onNavigateToAccounts: () -> Unit,
    onSaveTransaction: (
        type: TransactionType,
        amount: Double,
        category: String,
        description: String,
        date: String,
        accountId: String
    ) -> Unit,
    onUpdateTransaction: ((Transaction) -> Unit)? = null
) {
    val isEditMode = transactionToEdit != null
    
    var transactionType by remember { mutableStateOf(transactionToEdit?.type ?: TransactionType.EXPENSE) }
    var selectedAccountId by remember { mutableStateOf(transactionToEdit?.accountId ?: accounts.firstOrNull()?.id ?: "") }
    var amount by remember { mutableStateOf(transactionToEdit?.amount?.toString() ?: "") }
    var category by remember { mutableStateOf(transactionToEdit?.category ?: "") }
    var description by remember { mutableStateOf(transactionToEdit?.description ?: "") }
    var date by remember { mutableStateOf(transactionToEdit?.date ?: LocalDate.now().toString()) }
    var showCategoryMenu by remember { mutableStateOf(false) }
    var showAccountMenu by remember { mutableStateOf(false) }

    val expenseCategories = listOf(
        "Makanan", "Transportasi", "Belanja", "Hiburan",
        "Tagihan", "Kesehatan", "Pendidikan", "Lainnya"
    )

    val incomeCategories = listOf("Gaji", "Investasi", "Bonus", "Lainnya")

    val categories = if (transactionType == TransactionType.EXPENSE) {
        expenseCategories
    } else {
        incomeCategories
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (isEditMode) "Edit Transaksi" else "Tambah Transaksi") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, "Kembali")
                    }
                }
            )
        }
    ) { paddingValues ->
        if (accounts.isEmpty()) {
            // No accounts state
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Wallet,
                    contentDescription = null,
                    modifier = Modifier.size(64.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Belum ada rekening",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Buat rekening terlebih dahulu",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Button(onClick = onNavigateToAccounts) {
                    Text("Buat Rekening")
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Transaction Type Selector
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    TransactionTypeButton(
                        type = TransactionType.EXPENSE,
                        selected = transactionType == TransactionType.EXPENSE,
                        onClick = {
                            transactionType = TransactionType.EXPENSE
                            category = ""
                        },
                        modifier = Modifier.weight(1f)
                    )
                    TransactionTypeButton(
                        type = TransactionType.INCOME,
                        selected = transactionType == TransactionType.INCOME,
                        onClick = {
                            transactionType = TransactionType.INCOME
                            category = ""
                        },
                        modifier = Modifier.weight(1f)
                    )
                }

                // Account Selection
                Text(
                    text = "Rekening",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                ExposedDropdownMenuBox(
                    expanded = showAccountMenu,
                    onExpandedChange = { showAccountMenu = it }
                ) {
                    OutlinedTextField(
                        value = accounts.find { it.id == selectedAccountId }?.name ?: "",
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = showAccountMenu) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor(),
                        colors = OutlinedTextFieldDefaults.colors()
                    )
                    ExposedDropdownMenu(
                        expanded = showAccountMenu,
                        onDismissRequest = { showAccountMenu = false }
                    ) {
                        accounts.forEach { account ->
                            DropdownMenuItem(
                                text = {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Text(account.icon)
                                        Text(account.name)
                                    }
                                },
                                onClick = {
                                    selectedAccountId = account.id
                                    showAccountMenu = false
                                }
                            )
                        }
                    }
                }

                // Amount
                Text(
                    text = "Jumlah (Rp)",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                OutlinedTextField(
                    value = amount,
                    onValueChange = { amount = it },
                    placeholder = { Text("0") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = LocalTextStyle.current.copy(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                // Category
                Text(
                    text = "Kategori",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                ExposedDropdownMenuBox(
                    expanded = showCategoryMenu,
                    onExpandedChange = { showCategoryMenu = it }
                ) {
                    OutlinedTextField(
                        value = category,
                        onValueChange = {},
                        readOnly = true,
                        placeholder = { Text("Pilih kategori") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = showCategoryMenu) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor()
                    )
                    ExposedDropdownMenu(
                        expanded = showCategoryMenu,
                        onDismissRequest = { showCategoryMenu = false }
                    ) {
                        categories.forEach { cat ->
                            DropdownMenuItem(
                                text = { Text(cat) },
                                onClick = {
                                    category = cat
                                    showCategoryMenu = false
                                }
                            )
                        }
                    }
                }

                // Description
                Text(
                    text = "Deskripsi",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    placeholder = { Text("Contoh: Makan siang di warteg") },
                    modifier = Modifier.fillMaxWidth()
                )

                // Date
                Text(
                    text = "Tanggal",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                OutlinedTextField(
                    value = date,
                    onValueChange = { date = it },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Save Button
                Button(
                    onClick = {
                        if (amount.isNotBlank() && category.isNotBlank() &&
                            description.isNotBlank() && selectedAccountId.isNotBlank()) {
                            if (isEditMode && transactionToEdit != null && onUpdateTransaction != null) {
                                onUpdateTransaction(
                                    transactionToEdit.copy(
                                        type = transactionType,
                                        amount = amount.toDoubleOrNull() ?: 0.0,
                                        category = category,
                                        description = description,
                                        date = date,
                                        accountId = selectedAccountId
                                    )
                                )
                            } else {
                                onSaveTransaction(
                                    transactionType,
                                    amount.toDoubleOrNull() ?: 0.0,
                                    category,
                                    description,
                                    date,
                                    selectedAccountId
                                )
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = if (isEditMode) "Simpan Perubahan" else "Simpan Transaksi",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Composable
private fun TransactionTypeButton(
    type: TransactionType,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val (icon, label, color) = when (type) {
        TransactionType.EXPENSE -> Triple(
            Trending_down,
            "Pengeluaran",
            Color(0xFFEF4444)
        )
        TransactionType.INCOME -> Triple(
            TrendingUp,
            "Pemasukan",
            Color(0xFF10B981)
        )
    }

    Box(
        modifier = modifier
            .height(64.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                if (selected) color.copy(alpha = 0.1f)
                else Color.Transparent
            )
            .border(
                width = 2.dp,
                color = if (selected) color else MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(onClick = onClick)
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (selected) color else MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = label,
                fontWeight = FontWeight.Medium,
                color = if (selected) color else MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
