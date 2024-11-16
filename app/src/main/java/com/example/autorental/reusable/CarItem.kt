package com.example.autorental.reusable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.autorental.Car

@Composable
fun CarItem(car: Car, onClick: () -> Unit) { // Changed onClick to regular function type
    // Your Card layout for the car
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .clickable(onClick = onClick),  // onClick now uses regular function type
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            // Car image
            Image(
                painter = rememberAsyncImagePainter(car.imageUrl),
                contentDescription = car.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Car name
            Text(text = car.name, style = MaterialTheme.typography.bodyMedium)

            // Car category
            Text(text = car.category, style = MaterialTheme.typography.bodyMedium)

            // Car price
            Text(text = car.price, style = MaterialTheme.typography.bodySmall)
        }
    }
}
