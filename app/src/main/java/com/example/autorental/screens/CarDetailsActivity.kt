package com.example.autorental.screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.autorental.ui.theme.AutoRentalTheme
import com.example.autorental.Car

class CarDetailsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Retrieve car details from the intent extras
        val name = intent.getStringExtra(EXTRA_NAME) ?: "Unknown"
        val category = intent.getStringExtra(EXTRA_CATEGORY) ?: "Unknown"
        val price = intent.getStringExtra(EXTRA_PRICE) ?: "N/A"
        val imageUrl = intent.getStringExtra(EXTRA_IMAGE_URL) ?: ""
        val brand = intent.getStringExtra(EXTRA_BRAND) ?: "Unknown"
        val seats = intent.getIntExtra(EXTRA_SEATS, 0)
        val doors = intent.getIntExtra(EXTRA_DOORS, 0)
        val gasCapacity = intent.getDoubleExtra(EXTRA_GAS_CAPACITY, 0.0)
        val majorDetails = intent.getStringExtra(EXTRA_MAJOR_DETAILS) ?: "Details not available."

        setContent {
            AutoRentalTheme {
                CarDetailsScreen(
                    name = name,
                    category = category,
                    price = price,
                    imageUrl = imageUrl,
                    brand = brand,
                    seats = seats,
                    doors = doors,
                    gasCapacity = gasCapacity,
                    majorDetails = majorDetails,
                    onBack = { finish() } // Close the activity when the back button is pressed
                )
            }
        }
    }

    companion object {
        // Keys for intent extras
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_CATEGORY = "extra_category"
        const val EXTRA_PRICE = "extra_price"
        const val EXTRA_IMAGE_URL = "extra_image_url"
        const val EXTRA_BRAND = "extra_brand"
        const val EXTRA_SEATS = "extra_seats"
        const val EXTRA_DOORS = "extra_doors"
        const val EXTRA_GAS_CAPACITY = "extra_gas_capacity"
        const val EXTRA_MAJOR_DETAILS = "extra_major_details"

        /**
         * Creates an Intent to start this activity with car details.
         *
         * @param context The context to use for creating the intent.
         * @param carDetails The details of the car to pass to the activity.
         * @return An Intent to start CarDetailsActivity.
         */
        fun newIntent(
            context: Context,
            carDetails: Car
        ): Intent {
            return Intent(context, CarDetailsActivity::class.java).apply {
                putExtra(EXTRA_NAME, carDetails.name)
                putExtra(EXTRA_CATEGORY, carDetails.category)
                putExtra(EXTRA_PRICE, carDetails.price)
                putExtra(EXTRA_IMAGE_URL, carDetails.imageUrl)
                putExtra(EXTRA_BRAND, carDetails.brand)
                putExtra(EXTRA_SEATS, carDetails.seats)
                putExtra(EXTRA_DOORS, carDetails.doors)
                putExtra(EXTRA_GAS_CAPACITY, carDetails.gasCapacity)
                putExtra(EXTRA_MAJOR_DETAILS, carDetails.majorDetails)
            }
        }
    }
}
