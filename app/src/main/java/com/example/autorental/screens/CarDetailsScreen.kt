package com.example.autorental.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarDetailsScreen(
    name: String,
    category: String,
    price: String, // e.g., "Ksh 3400/day"
    imageUrl: String,
    brand: String,
    seats: Int,
    doors: Int,
    gasCapacity: Double,
    majorDetails: String,
    // Pass the logged-in user's ID here
    onBack: () -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    var selectedRentalPeriod by remember { mutableStateOf("") }
    var isSaving by remember { mutableStateOf(false) }
    var saveSuccess by remember { mutableStateOf(false) }
    var saveError by remember { mutableStateOf<String?>(null) }

    val basePrice = extractPriceFromString(price) ?: 0.0
    val priceForDay = basePrice * 1
    val priceForWeek = basePrice * 6.5
    val priceForMonth = basePrice * 27
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
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            // Existing UI content...

            Spacer(modifier = Modifier.weight(1f))

            // Rent Car Button
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Button(
                        onClick = { showDialog = true },
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
        }
    }

    // Dialog for selecting rental period
    if (showDialog) {
        RentalPeriodDialog(
            options = rentalPriceOptions,
            onDismiss = { showDialog = false },
            onOptionSelected = { period ->
                selectedRentalPeriod = period
                showDialog = false
                isSaving = true
                saveOrderToFirestore(
                    carName = name,
                    rentalPeriod = period,
                    price = price,
                    seats = seats.toString(),
                    doors = doors.toString(),
                    onSuccess = {
                        isSaving = false
                        saveSuccess = true
                    },
                    onFailure = { error ->
                        isSaving = false
                        saveError = error.message
                    }
                )
            }
        )
    }

    if (isSaving) {
        CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))
    }

    if (saveSuccess) {
        Text(
            text = "Order saved successfully!",
            color = MaterialTheme.colorScheme.primary, // Use colorScheme.primary
            modifier = Modifier.padding(top = 16.dp)
        )
    }

    if (saveError != null) {
        Text(
            text = "Error saving order: $saveError",
            color = MaterialTheme.colorScheme.error, // Use colorScheme.error
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}



// Firestore Integration
fun saveOrderToFirestore(
    carName: String,
    rentalPeriod: String,
    price: String,
    seats: String,
    doors: String,
    onSuccess: () -> Unit,
    onFailure: (Exception) -> Unit
) {
    val db = FirebaseFirestore.getInstance()
    val orderData = hashMapOf(
        "carName" to carName,
        "rentalPeriod" to rentalPeriod,
        "price" to price,
        "seats" to seats,
        "doors" to doors,
        "orderDate" to System.currentTimeMillis() // Timestamp for the order
    )

    db.collection("Orders")
        .add(orderData)
        .addOnSuccessListener { onSuccess() }
        .addOnFailureListener { exception -> onFailure(exception) }
}

// RentalPeriodDialog (No changes)
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
// Helper function to extract numeric price from the string
fun extractPriceFromString(price: String): Double? {
    // Extract the numeric value from the price string (e.g., "Ksh 3400/day" -> 3400.0)
    return price.replace(Regex("[^\\d.]"), "").toDoubleOrNull()
}
// Helper function to format price back to a string with currency symbol
fun formatPrice(price: Double): String {
    return "Ksh %.2f".format(price)
}
