package com.example.duitku.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val type: TransactionType,
    val amount: Double,
    val category: String,
    val description: String,
    val date: String,
    val accountId: String,
    val createdAt: Long = System.currentTimeMillis()
)

enum class TransactionType {
    INCOME, EXPENSE
}

@Entity(tableName = "accounts")
data class Account(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val type: AccountType,
    val balance: Double,
    val icon: String,
    val color: String,
    val createdAt: Long = System.currentTimeMillis()
)

enum class AccountType {
    EWALLET, BANK, CASH
}