package com.example.autorental.logo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.autorental.ui.theme.AutoRentalTheme

class BrandCarsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get the brand name from intent extras
        val brand = intent.getStringExtra(EXTRA_BRAND) ?: "Unknown"

        setContent {
            AutoRentalTheme {
                // Initialize NavController
                val navController = rememberNavController()

                // Set up a navigation host
                NavHost(navController = navController, startDestination = "brandCarsScreen") {
                    composable("brandCarsScreen") {
                        // Pass brand and onBack function to BrandCarsScreen
                        BrandCarsScreen(
                            brand = brand,
                            onBack = { finish() } // Close the activity on back navigation
                        )
                    }
                }
            }
        }
    }

    companion object {
        private const val EXTRA_BRAND = "extra_brand"

        /**
         * Creates an intent to start this activity with the specified brand.
         *
         * @param context The context to use for creating the intent.
         * @param brand The name of the car brand to display.
         * @return An Intent for starting BrandCarsActivity.
         */
        fun newIntent(context: Context, brand: String): Intent {
            return Intent(context, BrandCarsActivity::class.java).apply {
                putExtra(EXTRA_BRAND, brand)
            }
        }
    }
}
