package com.example.autorental.logo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.autorental.ui.theme.AutoRentalTheme

class BrandCarsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get brand name from intent extras
        val brand = intent.getStringExtra(EXTRA_BRAND)

        setContent {
            AutoRentalTheme {
                // Create a NavController instance
                val navController = rememberNavController()

                // Set up a NavHost
                NavHost(navController = navController, startDestination = "brandCarsScreen") {
                    composable("brandCarsScreen") {
                        // Pass brand name and navController to BrandCarsScreen
                        BrandCarsScreen(brand = brand, navController = navController)
                    }
                }
            }
        }
    }

    companion object {
        private const val EXTRA_BRAND = "extra_brand"

        fun newIntent(context: Context, brand: String): Intent {
            return Intent(context, BrandCarsActivity::class.java).apply {
                putExtra(EXTRA_BRAND, brand)
            }
        }
    }
}
