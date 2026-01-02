package com.example.duitku.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.duitku.data.model.Account
import com.example.duitku.data.model.Transaction
import com.example.duitku.data.model.TransactionType
import com.example.duitku.data.util.CsvExporter
import com.example.duitku.ui.components.BalanceCard
import com.example.duitku.ui.components.formatCurrency
import java.util.Locale
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import com.example.duitku.ui.components.TrendingUp
import com.example.duitku.ui.components.Trending_down

// --- ICON SECTIONS (Tetap sama seperti sebelumnya) ---
val Wifi_off: ImageVector
    get() {
        if (_Wifi_off != null) return _Wifi_off!!
        _Wifi_off = ImageVector.Builder(
            name = "Wifi_off",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(790f, 904f)
                lineTo(414f, 526f)
                quadToRelative(-47f, 11f, -87.5f, 33f)
                reflectiveQuadTo(254f, 614f)
                lineToRelative(-84f, -86f)
                quadToRelative(32f, -32f, 69f, -56f)
                reflectiveQuadToRelative(79f, -42f)
                lineToRelative(-90f, -90f)
                quadToRelative(-41f, 21f, -76.5f, 46.5f)
                reflectiveQuadTo(84f, 444f)
                lineTo(0f, 358f)
                quadToRelative(32f, -32f, 66.5f, -57.5f)
                reflectiveQuadTo(140f, 252f)
                lineToRelative(-84f, -84f)
                lineToRelative(56f, -56f)
                lineToRelative(736f, 736f)
                close()
                moveToRelative(-310f, -64f)
                quadToRelative(-42f, 0f, -71f, -29.5f)
                reflectiveQuadTo(380f, 740f)
                quadToRelative(0f, -42f, 29f, -71f)
                reflectiveQuadToRelative(71f, -29f)
                reflectiveQuadToRelative(71f, 29f)
                reflectiveQuadToRelative(29f, 71f)
                quadToRelative(0f, 41f, -29f, 70.5f)
                reflectiveQuadTo(480f, 840f)
                moveToRelative(236f, -238f)
                lineToRelative(-29f, -29f)
                lineToRelative(-29f, -29f)
                lineToRelative(-144f, -144f)
                quadToRelative(81f, 8f, 151.5f, 41f)
                reflectiveQuadTo(790f, 528f)
                close()
                moveToRelative(160f, -158f)
                quadToRelative(-77f, -77f, -178.5f, -120.5f)
                reflectiveQuadTo(480f, 280f)
                quadToRelative(-21f, 0f, -40.5f, 1.5f)
                reflectiveQuadTo(400f, 286f)
                lineTo(298f, 184f)
                quadToRelative(44f, -12f, 89.5f, -18f)
                reflectiveQuadToRelative(92.5f, -6f)
                quadToRelative(142f, 0f, 265f, 53f)
                reflectiveQuadToRelative(215f, 145f)
                close()
            }
        }.build()
        return _Wifi_off!!
    }
private var _Wifi_off: ImageVector? = null

val Shield: ImageVector
    get() {
        if (_Shield != null) return _Shield!!
        _Shield = ImageVector.Builder(
            name = "Shield",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(480f, 880f)
                quadToRelative(-139f, -35f, -229.5f, -159.5f)
                reflectiveQuadTo(160f, 444f)
                verticalLineToRelative(-244f)
                lineToRelative(320f, -120f)
                lineToRelative(320f, 120f)
                verticalLineToRelative(244f)
                quadToRelative(0f, 152f, -90.5f, 276.5f)
                reflectiveQuadTo(480f, 880f)
                moveToRelative(0f, -84f)
                quadToRelative(104f, -33f, 172f, -132f)
                reflectiveQuadToRelative(68f, -220f)
                verticalLineToRelative(-189f)
                lineToRelative(-240f, -90f)
                lineToRelative(-240f, 90f)
                verticalLineToRelative(189f)
                quadToRelative(0f, 121f, 68f, 220f)
                reflectiveQuadToRelative(172f, 132f)
                moveToRelative(0f, -316f)
            }
        }.build()
        return _Shield!!
    }
private var _Shield: ImageVector? = null

val Download: ImageVector
    get() {
        if (_Download != null) return _Download!!
        _Download = ImageVector.Builder(
            name = "Download",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(480f, 640f)
                lineTo(280f, 440f)
                lineToRelative(56f, -58f)
                lineToRelative(104f, 104f)
                verticalLineToRelative(-326f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(326f)
                lineToRelative(104f, -104f)
                lineToRelative(56f, 58f)
                close()
                moveTo(240f, 800f)
                quadToRelative(-33f, 0f, -56.5f, -23.5f)
                reflectiveQuadTo(160f, 720f)
                verticalLineToRelative(-120f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(120f)
                horizontalLineToRelative(480f)
                verticalLineToRelative(-120f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(120f)
                quadToRelative(0f, 33f, -23.5f, 56.5f)
                reflectiveQuadTo(720f, 800f)
                close()
            }
        }.build()
        return _Download!!
    }
private var _Download: ImageVector? = null


// --- MAIN SCREEN ---

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    transactions: List<Transaction>,
    accounts: List<Account>,
    totalBalance: Double,
    onNavigateToAddTransaction: () -> Unit,
    onNavigateToAccounts: () -> Unit,
    onNavigateToNotificationSettings: () -> Unit,
    onEditTransaction: (Transaction) -> Unit,
    onDeleteTransaction: (Transaction) -> Unit,
    onExportCsv: (String) -> Unit
) {
    var selectedTab by remember { mutableStateOf(0) } // 0: Transaksi, 1: Statistik

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "DuitKu",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.padding(top = 4.dp)
                        ) {
                            StatusChip(
                                icon = Wifi_off,
                                text = "Offline",
                                color = Color(0xFF10B981)
                            )
                            StatusChip(
                                icon = Shield,
                                text = "Aman",
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                },
                actions = {
                    IconButton(onClick = onNavigateToAccounts) {
                        Icon(Wallet, "Rekening")
                    }
                    IconButton(onClick = onNavigateToNotificationSettings) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Atur Notifikasi"
                        )
                    }
                    IconButton(onClick = {
                        val csvContent = CsvExporter.exportTransactionsToCsv(transactions, accounts)
                        onExportCsv(csvContent)
                    }) {
                        Icon(Download, "Export")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background.copy(alpha = 0.8f)
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNavigateToAddTransaction,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Add, "Tambah Transaksi")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(8.dp))
                BalanceCard(
                    transactions = transactions,
                    totalBalance = totalBalance
                )
            }

            // Tab Selector
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TabButton(
                        text = "Transaksi",
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 },
                        modifier = Modifier.weight(1f)
                    )
                    TabButton(
                        text = "Statistik",
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 },
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            if (selectedTab == 0) {
                if (transactions.isEmpty()) {
                    item { EmptyState() }
                } else {
                    val groupedTransactions = transactions.groupBy { it.date }
                    groupedTransactions.forEach { (date, txList) ->
                        item {
                            Text(
                                text = formatDate(date),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                        }
                        items(txList) { transaction ->
                            TransactionItem(
                                transaction = transaction,
                                onEdit = { onEditTransaction(transaction) },
                                onDelete = { onDeleteTransaction(transaction) }
                            )
                        }
                    }
                }
            } else {
                // STATISTIK VIEW
                item {
                    StatisticsView(transactions)
                }
            }

            item { Spacer(modifier = Modifier.height(80.dp)) }
        }
    }
}

@Composable
private fun TabButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .padding(4.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(
                if (selected) MaterialTheme.colorScheme.background
                else Color.Transparent
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Medium,
            color = if (selected) MaterialTheme.colorScheme.onBackground
            else MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun StatusChip(
    icon: ImageVector,
    text: String,
    color: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = color,
            modifier = Modifier.size(12.dp)
        )
        Text(
            text = text,
            color = color,
            fontSize = 12.sp
        )
    }
}

@Composable
private fun TransactionItem(
    transaction: Transaction,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
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
                    .background(
                        if (transaction.type == TransactionType.INCOME)
                            Color(0xFF10B981).copy(alpha = 0.2f)
                        else
                            Color(0xFFEF4444).copy(alpha = 0.2f)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = if (transaction.type == TransactionType.INCOME)
                        TrendingUp
                    else
                        Trending_down,
                    contentDescription = null,
                    tint = if (transaction.type == TransactionType.INCOME)
                        Color(0xFF10B981)
                    else
                        Color(0xFFEF4444),
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = transaction.description,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
                Text(
                    text = transaction.category,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "${if (transaction.type == TransactionType.INCOME) "+" else "-"}${formatCurrency(transaction.amount)}",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = if (transaction.type == TransactionType.INCOME)
                        Color(0xFF10B981)
                    else
                        Color(0xFFEF4444)
                )
            }

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
private fun EmptyState() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = TrendingUp,
            contentDescription = null,
            modifier = Modifier.size(64.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Belum ada transaksi",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "Mulai catat pemasukan dan pengeluaran Anda",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

// --- STATISTICS COMPONENTS (CUSTOM CHART) ---

data class ChartData(
    val category: String,
    val amount: Double,
    val percentage: Float,
    val color: Color
)

@Composable
private fun StatisticsView(transactions: List<Transaction>) {
    // 1. Prepare Data
    val expenses = transactions.filter { it.type == TransactionType.EXPENSE }
    val totalExpense = expenses.sumOf { it.amount }

    // Group by category, sum amounts, and map to ChartData
    val chartData = expenses.groupBy { it.category }
        .mapValues { (_, list) -> list.sumOf { it.amount } }
        .map { (category, amount) ->
            ChartData(
                category = category,
                amount = amount,
                percentage = if (totalExpense > 0) (amount / totalExpense).toFloat() else 0f,
                color = getCategoryColor(category)
            )
        }
        .sortedByDescending { it.amount } // Sort biggest first

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface) // Uses theme surface color
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Pengeluaran per Kategori",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(32.dp))

            if (chartData.isEmpty()) {
                Text(
                    text = "Belum ada pengeluaran",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 32.dp)
                )
            } else {
                // 2. Custom Donut Chart
                DonutChart(
                    data = chartData,
                    modifier = Modifier.size(200.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                // 3. Grid Legend (2 Columns)
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Chunk data into rows of 2 items
                    chartData.chunked(2).forEach { rowItems ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            rowItems.forEach { item ->
                                LegendItem(
                                    item = item,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                            // If row has only 1 item, add Spacer to keep alignment
                            if (rowItems.size == 1) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DonutChart(
    data: List<ChartData>,
    modifier: Modifier = Modifier,
    thickness: Dp = 40.dp
) {
    Canvas(modifier = modifier) {
        var startAngle = -90f // Start from top (12 o'clock)
        val strokeWidth = thickness.toPx()

        data.forEach { item ->
            val sweepAngle = item.percentage * 360f

            drawArc(
                color = item.color,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Butt)
            )

            startAngle += sweepAngle
        }
    }
}

@Composable
fun LegendItem(
    item: ChartData,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Colored Dot
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(CircleShape)
                .background(item.color)
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Category Name
        Text(
            text = item.category,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.weight(1f)
        )

        // Percentage
        Text(
            text = "${(item.percentage * 100).toInt()}%",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

private fun formatDate(dateString: String): String {
    return try {
        val date = LocalDate.parse(dateString)
        val formatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale("id", "ID"))
        date.format(formatter)
    } catch (e: Exception) {
        dateString
    }
}

private fun getCategoryColor(category: String): Color {
    return when (category) {
        "Makanan" -> Color(0xFF10B981)     // Green
        "Transportasi" -> Color(0xFF3B82F6)// Blue
        "Belanja" -> Color(0xFFF59E0B)     // Orange/Yellow
        "Hiburan" -> Color(0xFFEC4899)     // Pink
        "Tagihan" -> Color(0xFFEF4444)     // Red
        "Kesehatan" -> Color(0xFF8B5CF6)   // Purple
        "Pendidikan" -> Color(0xFF06B6D4)  // Cyan
        else -> Color(0xFF6B7280)          // Gray
    }
}