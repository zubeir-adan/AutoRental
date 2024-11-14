package com.example.autorental

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown

class CategoryDetails : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val category = intent.getStringExtra("category") ?: "Unknown"
        setContent {
            CategoryDetailsScreen(category = category, onBack = { finish() })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDetailsScreen(category: String, onBack: () -> Unit) {
    val cars = CarCategoryProvider.getCarsForCategory(category)
    val brands = CarCategoryProvider.getBrandsForCategory(category)

    var selectedBrand by remember { mutableStateOf<String?>(null) }
    var sortOrder by remember { mutableStateOf(SortOrder.ASCENDING) }
    var expandedBrandDropdown by remember { mutableStateOf(false) }
    var expandedSortDropdown by remember { mutableStateOf(false) }

    val filteredCars = cars.filter { car ->
        selectedBrand == null || car.brand == selectedBrand
    }

    val sortedCars = when (sortOrder) {
        SortOrder.ASCENDING -> filteredCars.sortedBy {
            it.price.removePrefix("KSh ").removeSuffix("/day").replace(",", "").toDoubleOrNull() ?: 0.0
        }
        SortOrder.DESCENDING -> filteredCars.sortedByDescending {
            it.price.removePrefix("KSh ").removeSuffix("/day").replace(",", "").toDoubleOrNull() ?: 0.0
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "$category Vehicles") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFD3D3D3)
                ),
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Brand Filter Dropdown
                ExposedDropdownMenuBox(
                    expanded = expandedBrandDropdown,
                    onExpandedChange = { expandedBrandDropdown = !expandedBrandDropdown },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                ) {
                    OutlinedTextField(
                        value = selectedBrand ?: "All Brands",
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { Icon(Icons.Filled.ArrowDropDown, "Dropdown") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor(),  // Add menuAnchor to link dropdown with text field
                        label = { Text("Select Brand") }
                    )
                    DropdownMenu(
                        expanded = expandedBrandDropdown,
                        onDismissRequest = { expandedBrandDropdown = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("All Brands") },
                            onClick = {
                                selectedBrand = null
                                expandedBrandDropdown = false
                            }
                        )
                        brands.forEach { brand ->
                            DropdownMenuItem(
                                text = { Text(brand) },
                                onClick = {
                                    selectedBrand = brand
                                    expandedBrandDropdown = false
                                }
                            )
                        }
                    }
                }

                // Sort Order Dropdown
                ExposedDropdownMenuBox(
                    expanded = expandedSortDropdown,
                    onExpandedChange = { expandedSortDropdown = !expandedSortDropdown },
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                ) {
                    OutlinedTextField(
                        value = if (sortOrder == SortOrder.ASCENDING) "Low to High" else "High to Low",
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { Icon(Icons.Filled.ArrowDropDown, "Dropdown") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor(),  // Add menuAnchor to link dropdown with text field
                        label = { Text("Sort by price") }
                    )
                    DropdownMenu(
                        expanded = expandedSortDropdown,
                        onDismissRequest = { expandedSortDropdown = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Low to High") },
                            onClick = {
                                sortOrder = SortOrder.ASCENDING
                                expandedSortDropdown = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("High to Low") },
                            onClick = {
                                sortOrder = SortOrder.DESCENDING
                                expandedSortDropdown = false
                            }
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(sortedCars) { car ->
                    CarCard(car = car)
                }
            }
        }
    }
}

@Composable
fun CarCard(car: Car) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(car.imageUrl),
                contentDescription = "${car.brand} ${car.name}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${car.brand} ${car.name}",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = car.price,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

enum class SortOrder {
    ASCENDING,
    DESCENDING
}
