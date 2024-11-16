package com.example.autorental

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.autorental.ui.theme.AutoRentalTheme
import androidx.compose.ui.platform.LocalContext
import com.example.autorental.screens.CarDetailsActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDetailsScreen(category: String, onBack: () -> Unit) {
    val cars = CarCategoryProvider.getCarsForCategory(category)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "$category Vehicles") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFD3D3D3))
            )
        }
    ) { paddingValues ->
        val context = LocalContext.current // Get the context here before passing it to CarCard

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                items(cars) { car ->
                    CarCard(
                        car = car,
                        onClick = {
                            startCarDetailsActivity(context, car) // Now you can safely call the context here
                        }
                    )
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

fun startCarDetailsActivity(context: Context, car: Car) {
    val intent = CarDetailsActivity.newIntent(context, car)
    context.startActivity(intent)
}

@Preview
@Composable
fun PreviewCategoryDetailsScreen() {
    AutoRentalTheme {
        CategoryDetailsScreen(category = "Economy") {}
    }
}
