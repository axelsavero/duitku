package com.example.duitku.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.duitku.data.dao.AccountDao
import com.example.duitku.data.dao.TransactionDao
import com.example.duitku.data.model.Account
import com.example.duitku.data.model.Transaction

@Database(
    entities = [Transaction::class, Account::class],
    version = 1,
    exportSchema = false
)
abstract class DuitKuDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    abstract fun accountDao(): AccountDao

    companion object {
        @Volatile
        private var INSTANCE: DuitKuDatabase? = null

        fun getDatabase(context: Context): DuitKuDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DuitKuDatabase::class.java,
                    "duitku_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}