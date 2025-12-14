package com.example.duitku.data.repository

import com.example.duitku.data.dao.AccountDao
import com.example.duitku.data.dao.TransactionDao
import com.example.duitku.data.model.Account
import com.example.duitku.data.model.Transaction
import kotlinx.coroutines.flow.Flow

class DuitKuRepository(
    private val transactionDao: TransactionDao,
    private val accountDao: AccountDao
) {
    val allTransactions: Flow<List<Transaction>> = transactionDao.getAllTransactions()
    val allAccounts: Flow<List<Account>> = accountDao.getAllAccounts()

    suspend fun insertTransaction(transaction: Transaction) {
        transactionDao.insertTransaction(transaction)
        // Update account balance
        val account = accountDao.getAccountById(transaction.accountId)
        account?.let {
            val newBalance = if (transaction.type == com.example.duitku.data.model.TransactionType.INCOME) {
                it.balance + transaction.amount
            } else {
                it.balance - transaction.amount
            }
            accountDao.updateAccount(it.copy(balance = newBalance))
        }
    }

    suspend fun deleteTransaction(transaction: Transaction) {
        transactionDao.deleteTransaction(transaction)
        // Reverse balance change
        val account = accountDao.getAccountById(transaction.accountId)
        account?.let {
            val newBalance = if (transaction.type == com.example.duitku.data.model.TransactionType.INCOME) {
                it.balance - transaction.amount
            } else {
                it.balance + transaction.amount
            }
            accountDao.updateAccount(it.copy(balance = newBalance))
        }
    }

    suspend fun insertAccount(account: Account) {
        accountDao.insertAccount(account)
    }

    suspend fun deleteAccount(account: Account) {
        accountDao.deleteAccount(account)
    }
}
