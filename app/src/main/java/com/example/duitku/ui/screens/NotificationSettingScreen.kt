package com.example.duitku.ui.screens

import android.app.TimePickerDialog
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.duitku.data.util.NotificationScheduler
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationSettingScreen(
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val scheduler = remember { NotificationScheduler(context) }

    // --- UBAH DISINI ---
    // Pas layar dibuka, langsung cek apakah ada jam yang disimpan?
    // Kalau ada pakai itu, kalau nggak ada tulis "Belum diatur"
    var selectedTimeText by remember {
        mutableStateOf(scheduler.getSavedTime() ?: "Belum diatur")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pengingat") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Kembali"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Atur Pengingat Harian", style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Waktu saat ini: $selectedTimeText")

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = {
                val calendar = Calendar.getInstance()
                val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
                val currentMinute = calendar.get(Calendar.MINUTE)

                TimePickerDialog(
                    context,
                    { _, hourOfDay, minute ->
                        scheduler.scheduleDailyNotification(hourOfDay, minute)

                        // Update text di layar
                        selectedTimeText = String.format("%02d:%02d", hourOfDay, minute)

                        Toast.makeText(context, "Pengingat diatur jam $selectedTimeText", Toast.LENGTH_SHORT).show()
                    },
                    currentHour,
                    currentMinute,
                    true
                ).show()
            }) {
                Text("Pilih Jam Notifikasi")
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(onClick = {
                scheduler.cancelNotification()
                selectedTimeText = "Dimatikan" // Ubah text jadi dimatikan
                Toast.makeText(context, "Pengingat dimatikan", Toast.LENGTH_SHORT).show()
            }) {
                Text("Matikan Pengingat")
            }
        }
    }
}