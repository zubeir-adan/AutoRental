package com.example.autorental.categories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.autorental.ui.theme.AutoRentalTheme

class CategoryDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get the category from the intent
        val category = intent.getStringExtra("CATEGORY_NAME") ?: "Unknown"

        setContent {
            AutoRentalTheme {
                // Use CategoryDetailsScreen from CategoryDetailsScreen.kt
                CategoryDetailsScreen(category = category, onBack = {
                    finish()  // Close the activity on back press
                })
            }
        }
    }
}
