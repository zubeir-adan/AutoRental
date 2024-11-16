package com.example.autorental.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.autorental.R // Import the R class for accessing resources
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarDetailsScreen(
    name: String,
    category: String,
    price: String,  // This is the price as a string (e.g., "Ksh 3400/day")
    imageUrl: String,
    brand: String,
    seats: Int,
    doors: Int,
    gasCapacity: Double,
    majorDetails: String,
    onBack: () -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    var selectedRentalPeriod by remember { mutableStateOf("") }

    // Rent duration options
    val rentalOptions = listOf("1 Day", "1 Week", "1 Month")

    // Extract the numeric part of the price (removing "Ksh" and "/day")
    val basePrice = extractPriceFromString(price) ?: 0.0

    // Perform the price calculations
    val priceForDay = basePrice * 1
    val priceForWeek = basePrice * 6.5
    val priceForMonth = basePrice * 27

    // Generate rental price options based on the calculated values
    val rentalPriceOptions = listOf(
        "1 Day - ${formatPrice(priceForDay)}",
        "1 Week - ${formatPrice(priceForWeek)}",
        "1 Month - ${formatPrice(priceForMonth)}"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "$name Details") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray)
            )
        }
    ) { padding ->

        // Main content of the screen
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            // Car Image
            Image(
                painter = rememberAsyncImagePainter(model = imageUrl),
                contentDescription = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Seat, Door, and Gas Icons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconWithText(
                    imageResId = R.drawable.seat,  // Custom seat icon
                    text = "$seats Seats"
                )
                IconWithText(
                    imageResId = R.drawable.door,  // Custom door icon
                    text = "$doors Doors"
                )
                IconWithText(
                    imageResId = R.drawable.gas,  // Custom gas icon
                    text = "%.1f L".format(gasCapacity)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))  // Spacer between icons and text

            // Category, Brand, Price, and Details
            Text(text = "Category: $category", style = MaterialTheme.typography.bodyLarge, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))  // Spacer for separation
            Text(text = "Brand: $brand", style = MaterialTheme.typography.bodyLarge, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))  // Spacer for separation
            Text(text = "Price: $price", style = MaterialTheme.typography.bodyLarge, color = Color.Black)

            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Details: $majorDetails", style = MaterialTheme.typography.bodyMedium, color = Color.DarkGray)

            Spacer(modifier = Modifier.weight(1f))

            // Rent Car Button
            Button(
                onClick = { showDialog = true },  // Show dialog on button click
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text(text = "Rent Car", color = Color.White)
            }
        }
    }

    // Dialog for selecting rental period
    if (showDialog) {
        RentalPeriodDialog(
            options = rentalPriceOptions,
            onDismiss = { showDialog = false },
            onOptionSelected = { period ->
                selectedRentalPeriod = period
                showDialog = false // Close dialog after selection
            }
        )
    }
}

// Helper function to extract numeric price from the string
fun extractPriceFromString(price: String): Double? {
    // Extract the numeric value from the price string (e.g., "Ksh 3400/day" -> 3400.0)
    return price.replace(Regex("[^\\d.]"), "").toDoubleOrNull()
}

// Helper function to format price back to string with currency symbol
fun formatPrice(price: Double): String {
    return "Ksh %.2f".format(price)
}

@Composable
fun IconWithText(imageResId: Int, text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = text,
            modifier = Modifier.size(48.dp)  // Increased icon size
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun RentalPeriodDialog(
    options: List<String>,
    onDismiss: () -> Unit,
    onOptionSelected: (String) -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Select Rental Period") },
        text = {
            Column {
                options.forEach { option ->
                    TextButton(onClick = { onOptionSelected(option) }) {
                        Text(text = option)
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
