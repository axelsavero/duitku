package com.example.duitku.data.util

import com.example.duitku.data.model.Account
import com.example.duitku.data.model.Transaction
import com.example.duitku.data.model.TransactionType

object CsvExporter {
    
    /**
     * Export transactions to CSV format string
     * @param transactions List of transactions to export
     * @param accounts List of accounts for referencing account names
     * @return CSV formatted string
     */
    fun exportTransactionsToCsv(
        transactions: List<Transaction>,
        accounts: List<Account>
    ): String {
        val header = "Tanggal,Tipe,Kategori,Deskripsi,Jumlah,Rekening\n"
        
        if (transactions.isEmpty()) {
            return header
        }
        
        val rows = transactions.map { tx ->
            val accountName = accounts.find { it.id == tx.accountId }?.name ?: "Unknown"
            val type = if (tx.type == TransactionType.INCOME) "Pemasukan" else "Pengeluaran"
            // Escape commas and quotes in text fields
            val safeDescription = escapeField(tx.description)
            val safeCategory = escapeField(tx.category)
            val safeAccountName = escapeField(accountName)
            
            "${tx.date},$type,$safeCategory,$safeDescription,${tx.amount},$safeAccountName"
        }.joinToString("\n")
        
        return header + rows
    }
    
    /**
     * Generate a default filename for export
     * @return Filename with current date
     */
    fun generateFilename(): String {
        val dateFormat = java.text.SimpleDateFormat("yyyyMMdd_HHmmss", java.util.Locale.getDefault())
        val dateStr = dateFormat.format(java.util.Date())
        return "duitku_export_$dateStr.csv"
    }
    
    /**
     * Escape CSV field if it contains special characters
     */
    private fun escapeField(field: String): String {
        return if (field.contains(",") || field.contains("\"") || field.contains("\n")) {
            "\"${field.replace("\"", "\"\"")}\""
        } else {
            field
        }
    }
}
