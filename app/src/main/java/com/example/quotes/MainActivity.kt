package com.example.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.quotes.screens.QuoteDetail
import com.example.quotes.ui.theme.QuotesTheme
import com.example.quotes.dataManager
import com.example.quotes.screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        lifecycleScope.launch(Dispatchers.IO) {
            dataManager.loadAssetsFromFile(applicationContext)
        }


        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if (dataManager.isDataLoaded.value) {

        // ✅ BackHandler to prevent Activity from closing
        BackHandler(enabled = dataManager.currentPages.value == Pages.DETAIL) {
            dataManager.switchPages(null) // Go back to list
        }

        if (dataManager.currentPages.value == Pages.LISTING) {
            QuoteListScreen(data = dataManager.data) { selectedQuote ->
                dataManager.currentQuote = selectedQuote
                dataManager.switchPages(selectedQuote)
            }
        } else {
            dataManager.currentQuote?.let { QuoteDetail(quote = it) }
        }
    }
}

enum class Pages{
    LISTING,
    DETAIL
}
