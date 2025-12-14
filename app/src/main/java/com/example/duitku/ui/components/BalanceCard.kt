package com.example.duitku.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.duitku.data.model.Transaction
import com.example.duitku.data.model.TransactionType
import java.text.NumberFormat
import java.util.*
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin


val TrendingUp: ImageVector
    get() {
        if (_TrendingUp != null) return _TrendingUp!!

        _TrendingUp = ImageVector.Builder(
            name = "TrendingUp",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveToRelative(22f, 7f)
                lineToRelative(-8.5f, 8.5f)
                lineToRelative(-5f, -5f)
                lineTo(2f, 17f)
            }
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(16f, 7f)
                horizontalLineToRelative(6f)
                verticalLineToRelative(6f)
            }
        }.build()

        return _TrendingUp!!
    }

private var _TrendingUp: ImageVector? = null






val Trending_down: ImageVector
    get() {
        if (_Trending_down != null) return _Trending_down!!

        _Trending_down = ImageVector.Builder(
            name = "Trending_down",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveTo(640f, 720f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(104f)
                lineTo(536f, 434f)
                lineTo(376f, 594f)
                lineTo(80f, 296f)
                lineToRelative(56f, -56f)
                lineToRelative(240f, 240f)
                lineToRelative(160f, -160f)
                lineToRelative(264f, 264f)
                verticalLineToRelative(-104f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(240f)
                close()
            }
        }.build()

        return _Trending_down!!
    }

private var _Trending_down: ImageVector? = null

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





@Composable
fun BalanceCard(
    transactions: List<Transaction>,
    totalBalance: Double,
    modifier: Modifier = Modifier
) {
    val income = transactions.filter { it.type == TransactionType.INCOME }.sumOf { it.amount }
    val expense = transactions.filter { it.type == TransactionType.EXPENSE }.sumOf { it.amount }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier =
                Modifier.fillMaxWidth()
                    .background(
                        brush =
                            Brush.linearGradient(
                                colors =
                                    listOf(
                                        Color(0xFF10B981),
                                        Color(0xFF059669)
                                    )
                            )
                    )
                    .padding(24.dp)
        ) {
            // Background decoration circles
            Box(
                modifier =
                    Modifier.size(128.dp)
                        .offset(x = 200.dp, y = (-32).dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.1f))
            )

            Box(
                modifier =
                    Modifier.size(96.dp)
                        .offset(x = (-16).dp, y = 100.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.05f))
            )

            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Icon(
                        imageVector = Account_balance_wallet,
                        contentDescription = null,
                        tint = Color.White.copy(alpha = 0.8f),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Total Saldo",
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 14.sp
                    )
                }

                Text(
                    text = formatCurrency(totalBalance),
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BalanceItem(
                        icon = TrendingUp,
                        label = "Pemasukan",
                        amount = income
                    )
                    BalanceItem(
                        icon = Trending_down,
                        label = "Pengeluaran",
                        amount = expense
                    )
                }
            }
        }
    }
}

@Composable
private fun BalanceItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    amount: Double
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier =
                Modifier.size(40.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.2f)),
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
        Column {
            Text(text = label, color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp)
            Text(
                text = formatCurrency(amount),
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

fun formatCurrency(amount: Double): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
    return formatter.format(amount).replace(",00", "")
}
