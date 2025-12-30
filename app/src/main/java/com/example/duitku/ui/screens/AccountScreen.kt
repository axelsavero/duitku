package com.example.duitku.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.duitku.data.model.Account
import com.example.duitku.data.model.AccountType
import com.example.duitku.ui.components.formatCurrency

val Attach_money: ImageVector
    get() {
        if (_Attach_money != null) return _Attach_money!!

        _Attach_money = ImageVector.Builder(
            name = "Attach_money",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveTo(441f, 840f)
                verticalLineToRelative(-86f)
                quadToRelative(-53f, -12f, -91.5f, -46f)
                reflectiveQuadTo(293f, 612f)
                lineToRelative(74f, -30f)
                quadToRelative(15f, 48f, 44.5f, 73f)
                reflectiveQuadToRelative(77.5f, 25f)
                quadToRelative(41f, 0f, 69.5f, -18.5f)
                reflectiveQuadTo(587f, 604f)
                quadToRelative(0f, -35f, -22f, -55.5f)
                reflectiveQuadTo(463f, 502f)
                quadToRelative(-86f, -27f, -118f, -64.5f)
                reflectiveQuadTo(313f, 346f)
                quadToRelative(0f, -65f, 42f, -101f)
                reflectiveQuadToRelative(86f, -41f)
                verticalLineToRelative(-84f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(84f)
                quadToRelative(50f, 8f, 82.5f, 36.5f)
                reflectiveQuadTo(651f, 310f)
                lineToRelative(-74f, 32f)
                quadToRelative(-12f, -32f, -34f, -48f)
                reflectiveQuadToRelative(-60f, -16f)
                quadToRelative(-44f, 0f, -67f, 19.5f)
                reflectiveQuadTo(393f, 346f)
                quadToRelative(0f, 33f, 30f, 52f)
                reflectiveQuadToRelative(104f, 40f)
                quadToRelative(69f, 20f, 104.5f, 63.5f)
                reflectiveQuadTo(667f, 602f)
                quadToRelative(0f, 71f, -42f, 108f)
                reflectiveQuadToRelative(-104f, 46f)
                verticalLineToRelative(84f)
                close()
            }
        }.build()

        return _Attach_money!!
    }

private var _Attach_money: ImageVector? = null


val Wallet: ImageVector
    get() {
        if (_Wallet != null) return _Wallet!!

        _Wallet = ImageVector.Builder(
            name = "Wallet",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveTo(240f, 800f)
                quadToRelative(-66f, 0f, -113f, -47f)
                reflectiveQuadTo(80f, 640f)
                verticalLineToRelative(-320f)
                quadToRelative(0f, -66f, 47f, -113f)
                reflectiveQuadToRelative(113f, -47f)
                horizontalLineToRelative(480f)
                quadToRelative(66f, 0f, 113f, 47f)
                reflectiveQuadToRelative(47f, 113f)
                verticalLineToRelative(320f)
                quadToRelative(0f, 66f, -47f, 113f)
                reflectiveQuadToRelative(-113f, 47f)
                close()
                moveToRelative(0f, -480f)
                horizontalLineToRelative(480f)
                quadToRelative(22f, 0f, 42f, 5f)
                reflectiveQuadToRelative(38f, 16f)
                verticalLineToRelative(-21f)
                quadToRelative(0f, -33f, -23.5f, -56.5f)
                reflectiveQuadTo(720f, 240f)
                horizontalLineTo(240f)
                quadToRelative(-33f, 0f, -56.5f, 23.5f)
                reflectiveQuadTo(160f, 320f)
                verticalLineToRelative(21f)
                quadToRelative(18f, -11f, 38f, -16f)
                reflectiveQuadToRelative(42f, -5f)
                moveToRelative(-74f, 130f)
                lineToRelative(445f, 108f)
                quadToRelative(9f, 2f, 18f, 0f)
                reflectiveQuadToRelative(17f, -8f)
                lineToRelative(139f, -116f)
                quadToRelative(-11f, -15f, -28f, -24.5f)
                reflectiveQuadToRelative(-37f, -9.5f)
                horizontalLineTo(240f)
                quadToRelative(-26f, 0f, -45.5f, 13.5f)
                reflectiveQuadTo(166f, 450f)
            }
        }.build()

        return _Wallet!!
    }

private var _Wallet: ImageVector? = null


val Account_balance_wallet: ImageVector
    get() {
        if (_Account_balance_wallet != null) return _Account_balance_wallet!!

        _Account_balance_wallet = ImageVector.Builder(
            name = "Account_balance_wallet",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveTo(200f, 760f)
                verticalLineToRelative(-560f)
                close()
                moveToRelative(0f, 80f)
                quadToRelative(-33f, 0f, -56.5f, -23.5f)
                reflectiveQuadTo(120f, 760f)
                verticalLineToRelative(-560f)
                quadToRelative(0f, -33f, 23.5f, -56.5f)
                reflectiveQuadTo(200f, 120f)
                horizontalLineToRelative(560f)
                quadToRelative(33f, 0f, 56.5f, 23.5f)
                reflectiveQuadTo(840f, 200f)
                verticalLineToRelative(100f)
                horizontalLineToRelative(-80f)
                verticalLineToRelative(-100f)
                horizontalLineTo(200f)
                verticalLineToRelative(560f)
                horizontalLineToRelative(560f)
                verticalLineToRelative(-100f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(100f)
                quadToRelative(0f, 33f, -23.5f, 56.5f)
                reflectiveQuadTo(760f, 840f)
                close()
                moveToRelative(320f, -160f)
                quadToRelative(-33f, 0f, -56.5f, -23.5f)
                reflectiveQuadTo(440f, 600f)
                verticalLineToRelative(-240f)
                quadToRelative(0f, -33f, 23.5f, -56.5f)
                reflectiveQuadTo(520f, 280f)
                horizontalLineToRelative(280f)
                quadToRelative(33f, 0f, 56.5f, 23.5f)
                reflectiveQuadTo(880f, 360f)
                verticalLineToRelative(240f)
                quadToRelative(0f, 33f, -23.5f, 56.5f)
                reflectiveQuadTo(800f, 680f)
                close()
                moveToRelative(280f, -80f)
                verticalLineToRelative(-240f)
                horizontalLineTo(520f)
                verticalLineToRelative(240f)
                close()
                moveToRelative(-160f, -60f)
                quadToRelative(25f, 0f, 42.5f, -17.5f)
                reflectiveQuadTo(700f, 480f)
                reflectiveQuadToRelative(-17.5f, -42.5f)
                reflectiveQuadTo(640f, 420f)
                reflectiveQuadToRelative(-42.5f, 17.5f)
                reflectiveQuadTo(580f, 480f)
                reflectiveQuadToRelative(17.5f, 42.5f)
                reflectiveQuadTo(640f, 540f)
            }
        }.build()

        return _Account_balance_wallet!!
    }

private var _Account_balance_wallet: ImageVector? = null

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountsScreen(
    accounts: List<Account>,
    totalBalance: Double,
    onNavigateBack: () -> Unit,
    onAddAccount: (name: String, type: AccountType, balance: Double) -> Unit,
    onEditAccount: (Account) -> Unit,
    onDeleteAccount: (Account) -> Unit
) {
    var showAddDialog by remember { mutableStateOf(false) }
    var accountToEdit by remember { mutableStateOf<Account?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Rekening") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, "Kembali")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddDialog = true },
                containerColor = MaterialTheme.colorScheme.primary
            ) { Icon(Icons.Default.Add, "Tambah Rekening") }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(8.dp))
                // Total Balance Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                ) {
                    Box(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .background(
                                    brush =
                                        Brush.linearGradient(
                                            colors =
                                                listOf(
                                                    Color(
                                                        0xFF10B981
                                                    )
                                                        .copy(
                                                            alpha =
                                                                0.2f
                                                        ),
                                                    Color(
                                                        0xFF059669
                                                    )
                                                        .copy(
                                                            alpha =
                                                                0.1f
                                                        )
                                                )
                                        )
                                )
                                .padding(24.dp)
                    ) {
                        Column {
                            Text(
                                text = "Total Saldo",
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = formatCurrency(totalBalance),
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                            Text(
                                text = "${accounts.size} rekening terdaftar",
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            item {
                Text(
                    text = "Daftar Rekening",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            if (accounts.isEmpty()) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 48.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Account_balance_wallet,
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
                            text = "Tambahkan rekening pertama Anda",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            } else {
                items(accounts) { account ->
                    AccountItem(
                        account = account,
                        onEdit = { accountToEdit = account },
                        onDelete = { onDeleteAccount(account) }
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(80.dp)) }
        }
    }

    if (showAddDialog) {
        AddAccountDialog(
            onDismiss = { showAddDialog = false },
            onConfirm = { name, type, balance ->
                onAddAccount(name, type, balance)
                showAddDialog = false
            }
        )
    }

    accountToEdit?.let { account ->
        EditAccountDialog(
            account = account,
            onDismiss = { accountToEdit = null },
            onConfirm = { updatedAccount ->
                onEditAccount(updatedAccount)
                accountToEdit = null
            }
        )
    }
}

@Composable
private fun AccountItem(account: Account, onEdit: () -> Unit, onDelete: () -> Unit) {
    val (icon, backgroundColor) =
        when (account.type) {
            AccountType.EWALLET -> Wallet to Color(0xFF8B5CF6)
            AccountType.BANK -> Account_balance_wallet to Color(0xFF3B82F6)
            AccountType.CASH -> Attach_money to Color(0xFF10B981)
        }

    Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = account.name, fontWeight = FontWeight.Medium, fontSize = 14.sp)
                Text(
                    text = account.type.name.lowercase().replaceFirstChar { it.uppercase() },
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Text(
                text = formatCurrency(account.balance),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color =
                    if (account.balance >= 0) MaterialTheme.colorScheme.onSurface
                    else Color(0xFFEF4444)
            )

            IconButton(onClick = onEdit) {
                Icon(
                    Icons.Default.Edit,
                    contentDescription = "Edit",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            IconButton(onClick = onDelete) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "Hapus",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun AddAccountDialog(
    onDismiss: () -> Unit,
    onConfirm: (name: String, type: AccountType, balance: Double) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var selectedType by remember { mutableStateOf(AccountType.EWALLET) }
    var balance by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Tambah Rekening") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                // Account Type Selection
                Text(text = "Jenis Rekening", fontSize = 14.sp, fontWeight = FontWeight.Medium)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    AccountTypeButton(
                        type = AccountType.EWALLET,
                        selected = selectedType == AccountType.EWALLET,
                        onClick = { selectedType = AccountType.EWALLET },
                        modifier = Modifier.weight(1f)
                    )
                    AccountTypeButton(
                        type = AccountType.BANK,
                        selected = selectedType == AccountType.BANK,
                        onClick = { selectedType = AccountType.BANK },
                        modifier = Modifier.weight(1f)
                    )
                    AccountTypeButton(
                        type = AccountType.CASH,
                        selected = selectedType == AccountType.CASH,
                        onClick = { selectedType = AccountType.CASH },
                        modifier = Modifier.weight(1f)
                    )
                }

                // Account Name
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Nama Rekening") },
                    placeholder = { Text("Contoh: BCA, GoPay, Dompet") },
                    modifier = Modifier.fillMaxWidth()
                )

                // Initial Balance
                OutlinedTextField(
                    value = balance,
                    onValueChange = { balance = it },
                    label = { Text("Saldo Awal (Rp)") },
                    placeholder = { Text("0") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (name.isNotBlank()) {
                        onConfirm(name, selectedType, balance.toDoubleOrNull() ?: 0.0)
                    }
                }
            ) { Text("Tambah") }
        },
        dismissButton = { TextButton(onClick = onDismiss) { Text("Batal") } }
    )
}

@Composable
private fun AccountTypeButton(
    type: AccountType,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val (emoji, label) =
        when (type) {
            AccountType.EWALLET -> "💳" to "E-Wallet"
            AccountType.BANK -> "🏦" to "Bank"
            AccountType.CASH -> "💵" to "Cash"
        }

    Box(
        modifier =
            modifier
                .aspectRatio(1f)
                .clip(RoundedCornerShape(12.dp))
                .background(
                    if (selected)
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                    else Color.Transparent
                )
                .border(
                    width = 2.dp,
                    color =
                        if (selected) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(12.dp)
                )
                .clickable(onClick = onClick)
                .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = emoji, fontSize = 24.sp)
            Text(text = label, fontSize = 10.sp, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
private fun EditAccountDialog(
    account: Account,
    onDismiss: () -> Unit,
    onConfirm: (Account) -> Unit
) {
    var name by remember { mutableStateOf(account.name) }
    var selectedType by remember { mutableStateOf(account.type) }
    var balance by remember { mutableStateOf(account.balance.toString()) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Edit Rekening") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                // Account Type Selection
                Text(text = "Jenis Rekening", fontSize = 14.sp, fontWeight = FontWeight.Medium)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    AccountTypeButton(
                        type = AccountType.EWALLET,
                        selected = selectedType == AccountType.EWALLET,
                        onClick = { selectedType = AccountType.EWALLET },
                        modifier = Modifier.weight(1f)
                    )
                    AccountTypeButton(
                        type = AccountType.BANK,
                        selected = selectedType == AccountType.BANK,
                        onClick = { selectedType = AccountType.BANK },
                        modifier = Modifier.weight(1f)
                    )
                    AccountTypeButton(
                        type = AccountType.CASH,
                        selected = selectedType == AccountType.CASH,
                        onClick = { selectedType = AccountType.CASH },
                        modifier = Modifier.weight(1f)
                    )
                }

                // Account Name
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Nama Rekening") },
                    placeholder = { Text("Contoh: BCA, GoPay, Dompet") },
                    modifier = Modifier.fillMaxWidth()
                )

                // Balance
                OutlinedTextField(
                    value = balance,
                    onValueChange = { balance = it },
                    label = { Text("Saldo (Rp)") },
                    placeholder = { Text("0") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (name.isNotBlank()) {
                        val (icon, color) = when (selectedType) {
                            AccountType.EWALLET -> "💳" to "purple"
                            AccountType.BANK -> "🏦" to "blue"
                            AccountType.CASH -> "💵" to "green"
                        }
                        onConfirm(
                            account.copy(
                                name = name,
                                type = selectedType,
                                balance = balance.toDoubleOrNull() ?: account.balance,
                                icon = icon,
                                color = color
                            )
                        )
                    }
                }
            ) { Text("Simpan") }
        },
        dismissButton = { TextButton(onClick = onDismiss) { Text("Batal") } }
    )
}

