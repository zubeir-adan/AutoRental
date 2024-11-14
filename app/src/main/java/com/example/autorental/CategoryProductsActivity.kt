package com.example.autorental

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class CategoryProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val category = intent.getStringExtra("category") ?: "Unknown Category"

        setContent {
            CategoryProductsScreen(category)
        }
    }
}

@Composable
fun CategoryProductsScreen(category: String) {
    Text(text = "Products for category: $category")
}

@Preview
@Composable
fun PreviewCategoryProductsScreen() {
    CategoryProductsScreen(category = "Standard")
}
