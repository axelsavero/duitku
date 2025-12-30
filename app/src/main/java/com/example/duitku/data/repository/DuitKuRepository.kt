package com.example.duitku.data.repository

import com.example.duitku.data.dao.AccountDao
import com.example.duitku.data.dao.TransactionDao
import com.example.duitku.data.model.Account
import com.example.duitku.data.model.Transaction
import com.example.duitku.data.model.TransactionType
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
            val newBalance = if (transaction.type == TransactionType.INCOME) {
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
            val newBalance = if (transaction.type == TransactionType.INCOME) {
                it.balance - transaction.amount
            } else {
                it.balance + transaction.amount
            }
            accountDao.updateAccount(it.copy(balance = newBalance))
        }
    }

    suspend fun updateTransaction(oldTransaction: Transaction, newTransaction: Transaction) {
        // 1. Reverse old transaction balance
        val oldAccount = accountDao.getAccountById(oldTransaction.accountId)
        oldAccount?.let {
            val oldBalance = if (oldTransaction.type == TransactionType.INCOME) {
                it.balance - oldTransaction.amount
            } else {
                it.balance + oldTransaction.amount
            }
            accountDao.updateAccount(it.copy(balance = oldBalance))
        }

        // 2. Apply new transaction balance
        val newAccount = accountDao.getAccountById(newTransaction.accountId)
        newAccount?.let {
            val newBalance = if (newTransaction.type == TransactionType.INCOME) {
                it.balance + newTransaction.amount
            } else {
                it.balance - newTransaction.amount
            }
            accountDao.updateAccount(it.copy(balance = newBalance))
        }

        // 3. Update transaction record
        transactionDao.updateTransaction(newTransaction)
    }

    suspend fun getTransactionById(id: String): Transaction? {
        return transactionDao.getTransactionById(id)
    }

    suspend fun insertAccount(account: Account) {
        accountDao.insertAccount(account)
    }

    suspend fun updateAccount(account: Account) {
        accountDao.updateAccount(account)
    }

    suspend fun getAccountById(id: String): Account? {
        return accountDao.getAccountById(id)
    }

    suspend fun deleteAccount(account: Account) {
        accountDao.deleteAccount(account)
    }
}

