@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.autorental.logo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.navigation.NavController
import com.example.autorental.CarCategoryProvider
import com.example.autorental.reusable.CarItem
import com.example.autorental.Car
@Composable
fun BrandCarsScreen(brand: String?, navController: NavController) {
    // Fetch the list of cars for the given brand
    val cars = CarCategoryProvider.getCarsForBrand(brand)

    // Debug: Check if the brand and cars are being fetched properly
    println("Brand: $brand")
    println("Cars for $brand: ${cars.size}")

    Column(modifier = Modifier.padding(16.dp)) {
        TopAppBar(
            title = {
                Text(text = "Cars for $brand", style = MaterialTheme.typography.headlineSmall)
            },
            navigationIcon = {
                IconButton(onClick = {
                    // Navigate to the Home screen explicitly
                    navController.popBackStack("home", false) // "home" is the route name for the Home screen
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        // LazyColumn to display cars
        if (cars.isEmpty()) {
            // If no cars are available, show a message
            Text("No cars available for this brand.")
        } else {
            LazyColumn {
                items(cars) { car ->
                    CarItem(car)
                }
            }
        }
    }
}
