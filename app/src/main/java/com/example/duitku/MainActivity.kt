package com.example.duitku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.duitku.data.database.DuitKuDatabase
import com.example.duitku.data.repository.DuitKuRepository
import com.example.duitku.ui.navigation.NavGraph
import com.example.duitku.ui.theme.DuitKuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize database and repository
        val database = DuitKuDatabase.getDatabase(applicationContext)
        val repository = DuitKuRepository(
            transactionDao = database.transactionDao(),
            accountDao = database.accountDao()
        )

        setContent {
            DuitKuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavGraph(
                        navController = navController,
                        repository = repository
                    )
                }
            }
        }
    }
}