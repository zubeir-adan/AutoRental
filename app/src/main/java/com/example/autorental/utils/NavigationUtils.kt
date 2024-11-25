// NavigationUtils.kt
package com.example.autorental.utils

import android.content.Context
import android.content.Intent
import com.example.autorental.categories.CategoryDetailsActivity


fun Context.navigateToCategoryDetails(category: String) {
    val intent = Intent(this, CategoryDetailsActivity::class.java).apply {
        putExtra("CATEGORY_NAME", category)  // Pass the category to the activity
    }
    startActivity(intent)
}
