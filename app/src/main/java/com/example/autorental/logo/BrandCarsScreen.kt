@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.autorental.logo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.autorental.Car
import com.example.autorental.CarCategoryProvider
import com.example.autorental.screens.CarDetailsActivity

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun BrandCarsScreen(brand: String, onBack: () -> Unit) {
    val context = LocalContext.current // Extract context inside the composable function

    val cars = CarCategoryProvider.getCarsForBrand(brand)

    val selectedCategory by remember { mutableStateOf("All") } // Now immutable
    val sortOrder by remember { mutableStateOf(SortOrder.ASCENDING) } // Now immutable

    val filteredCars = if (selectedCategory == "All") cars else cars.filter { it.category == selectedCategory }
    val sortedCars = when (sortOrder) {
        SortOrder.ASCENDING -> filteredCars.sortedBy { it.price.removePrefix("KSh ").removeSuffix("/day").replace(",", "").toDoubleOrNull() ?: 0.0 }
        SortOrder.DESCENDING -> filteredCars.sortedByDescending { it.price.removePrefix("KSh ").removeSuffix("/day").replace(",", "").toDoubleOrNull() ?: 0.0 }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "$brand Cars", color = Color.Black) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.Black)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray)
            )
        }
    ) { padding ->

        Column(modifier = Modifier.padding(padding)) {
            // Category and sorting dropdowns (no change needed)

            Spacer(modifier = Modifier.height(16.dp))

            // If no cars are available for the selected brand, show a message
            if (sortedCars.isEmpty()) {
                Text(text = "No cars available for this brand.", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleLarge)
            } else {
                // List of cars displayed
                LazyColumn(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp) // Adds space between items
                ) {
                    items(sortedCars) { car ->
                        CarCard(
                            car = car,
                            onClick = {
                                // Start the CarDetailsActivity when a car is clicked
                                val intent = CarDetailsActivity.newIntent(context, car)
                                context.startActivity(intent)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CarCard(car: Car, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .clickable(onClick = onClick)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(model = car.imageUrl),
                contentDescription = car.name,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = car.name, style = MaterialTheme.typography.bodyMedium)
                Text(text = "Price: ${car.price}", style = MaterialTheme.typography.bodySmall)
                Text(text = "Seats: ${car.seats}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

enum class SortOrder {
    ASCENDING,
    DESCENDING
}

