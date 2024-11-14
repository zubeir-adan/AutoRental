package com.example.autorental.utils

import android.content.Context
import android.content.Intent
import com.example.autorental.CategoryDetails

// Use Jetpack Compose navigation here if you're using NavController

// Context-based navigation via intent (if still using Activities)
fun Context.navigateToCategoryDetails(category: String) {
    val intent = Intent(this, CategoryDetails::class.java).apply {
        putExtra("category", category)
    }
    startActivity(intent)
}

