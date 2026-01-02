package com.example.duitku.data.util

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import java.util.Calendar
import androidx.core.content.edit

class NotificationScheduler(private val context: Context) {

    private val prefs = context.getSharedPreferences("notification_prefs", Context.MODE_PRIVATE)

    fun scheduleDailyNotification(hour: Int, minute: Int) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, NotificationReceiver::class.java)

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            1001,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)

            // Kalau waktu sudah lewat, set buat besok
            if (before(Calendar.getInstance())) {
                add(Calendar.DAY_OF_YEAR, 1)
            }
        }

        try {
            val alarmClockInfo = AlarmManager.AlarmClockInfo(calendar.timeInMillis, pendingIntent)
            alarmManager.setAlarmClock(alarmClockInfo, pendingIntent)
        } catch (e: SecurityException) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
        }

        prefs.edit().apply {
            putInt("hour", hour)
            putInt("minute", minute)
            putBoolean("is_set", true)
            apply()
        }
    }

    fun cancelNotification() {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, NotificationReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            1001,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        alarmManager.cancel(pendingIntent)
        prefs.edit { clear() }
    }

    fun getSavedTime(): String? {
        val isSet = prefs.getBoolean("is_set", false)
        if (!isSet) return null
        val hour = prefs.getInt("hour", 0)
        val minute = prefs.getInt("minute", 0)
        return String.format("%02d:%02d", hour, minute)
    }
}