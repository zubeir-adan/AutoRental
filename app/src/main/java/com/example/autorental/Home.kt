@file:Suppress("DEPRECATION")

package com.example.autorental

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowInsetsControllerCompat
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.autorental.CarCategoryProvider.getBrandsForCategory
import com.example.autorental.logo.BrandCarsActivity
import com.example.autorental.reusable.HeaderSection
import com.example.autorental.screens.CarDetailsActivity
import com.example.autorental.screens.CarDetailsScreen
import com.example.autorental.ui.theme.AutoRentalTheme
import com.example.autorental.utils.navigateToCategoryDetails // Keep this as it's still in use


class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.isAppearanceLightStatusBars = false
        window.statusBarColor = android.graphics.Color.parseColor("#D3D3D3")

        setContent {
            AutoRentalTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    // State to hold the selected car

    var selectedCar: Car? by remember { mutableStateOf(null) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        if (selectedCar == null) {
            // Show the main home screen when no car is selected
            Column(modifier = Modifier.padding(innerPadding)) {
                HeaderSection()
                SearchBar()
                TopBrandsLabel()
                CarLogosRow()
                Text(
                    text = "Car Categories",
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                    color = Color.Black,
                    style = TextStyle(fontSize = 18.sp)
                )
                CarCategoryList()
                Spacer(modifier = Modifier.height(16.dp))
                CarRecommendationsLabel()
                CarRecommendationsFromSection(onCarClick = { car ->
                    selectedCar = car // Update the selected car when clicked
                })
            }
        } else {
            // Show the car details screen when a car is selected
            CarDetailsScreen(
                name = selectedCar!!.name,
                category = selectedCar!!.category,
                price = selectedCar!!.price,
                imageUrl = selectedCar!!.imageUrl,
                brand = selectedCar!!.brand,
                seats = selectedCar!!.seats,
                doors = selectedCar!!.doors,
                gasCapacity = selectedCar!!.gasCapacity,
                majorDetails = selectedCar!!.majorDetails,
                onBack = { selectedCar = null } // Go back to the home screen
            )
        }
    }
}
@Composable
fun CarLogosRow() {
    val logos = listOf(
        "nissan" to "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/nissan.jpg",
        "bmw" to "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/bmw.jpg",
        "toyota" to "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/toyota.jpg",
        "audi" to "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/audi.jpg",
        "ford" to "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/ford.jpg",
        "chevy" to "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/chevy.jpg",
        "benz" to "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/benz.jpg",
        "honda" to "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/honda.jpg",
        "hyundai" to "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/hyundai.png",
        "jeep" to "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/jeep.jpg",
        "tesla" to "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/tesla.jpg",
        "volkswagen" to "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/volkswagen.jpg"
    )

    Row(
        modifier = Modifier
            .padding(16.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        logos.forEach { (brand, url) ->
            LogoImage(url = url, brand = brand)
        }
    }
}

@Composable
fun LogoImage(url: String, brand: String) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .size(70.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                // Start BrandCarsActivity when a brand logo is clicked
                context.startActivity(BrandCarsActivity.newIntent(context, brand))
            }
    ) {
        Image(
            painter = rememberAsyncImagePainter(url),
            contentDescription = "$brand Logo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun SearchBar() {
    var searchText by remember { mutableStateOf("") }
    val carsList = remember { mutableStateOf<List<Car>>(emptyList()) }
    val keyboardController = LocalSoftwareKeyboardController.current

    // Update the carsList when the search text changes
    LaunchedEffect(searchText) {
        if (searchText.isNotEmpty()) {
            val allCars = EconomyCars.getCars() +
                    StandardCars.getCars() +
                    LuxuryCars.getCars() +
                    SUVCars.getCars() +
                    VanCars.getCars() +
                    PickupCars.getCars() +
                    ElectricCars.getCars() +
                    ConvertibleCars.getCars()

            carsList.value = allCars.filter { it.name.contains(searchText, ignoreCase = true) }
        } else {
            carsList.value = emptyList()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            placeholder = { Text("Search for a car") },
            trailingIcon = {
                if (searchText.isNotEmpty()) {
                    IconButton(onClick = {
                        searchText = ""
                        keyboardController?.hide() // Hide the keyboard when clearing text
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_clear),
                            contentDescription = "Clear search text"
                        )
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    keyboardController?.hide() // Hide the keyboard on search action
                }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (searchText.isNotEmpty()) {
            if (carsList.value.isEmpty()) {
                Text("No cars found for '$searchText'", style = MaterialTheme.typography.titleLarge)
            } else {
                LazyColumn {
                    items(carsList.value) { car ->
                        CarCardDetail(car)
                    }
                }
            }
        }
    }
}
@Composable
fun CarCardDetail(car: Car) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                // Navigate to CarDetailsActivity when a car is clicked
                context.startActivity(CarDetailsActivity.newIntent(context, car))
            },
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.Gray) // Add a border
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            // Car Image with placeholder
            Image(
                painter = rememberAsyncImagePainter(car.imageUrl),
                contentDescription = car.name,
                modifier = Modifier
                    .size(80.dp)  // Adjust the size of the image
                    .clip(RoundedCornerShape(8.dp)) // Round the corners of the image
            )

            Spacer(modifier = Modifier.width(16.dp)) // Space between image and text

            // Column for car details
            Column(modifier = Modifier.weight(1f)) {
                Text(car.name, style = MaterialTheme.typography.bodyMedium) // Car name
                Text("Category: ${car.category}", style = MaterialTheme.typography.bodySmall) // Car category
                Text("Price: ${car.price}", style = MaterialTheme.typography.bodySmall) // Car price
                Text("Brand: ${car.brand}", style = MaterialTheme.typography.bodySmall) // Car brand

            }
        }
    }
}



@Composable
fun TopBrandsLabel() {
    Text(
        text = "Top brands",
        modifier = Modifier.padding(start = 16.dp, top = 8.dp),
        color = Color.Black,
        style = TextStyle(fontSize = 18.sp)
    )
}

@Composable
fun CarRecommendationsLabel() {
    Text(
        text = "Car recommendations",
        modifier = Modifier.padding(start = 16.dp, top = 6.dp),
        color = Color.Black,
        style = TextStyle(fontSize = 18.sp)
    )
}@Composable
fun CarRecommendationsFromSection(onCarClick: (Car) -> Unit) {
    val cars = CarSection.getCarRecommendations()

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        item { Spacer(modifier = Modifier.height(16.dp)) }
        items(cars.chunked(2)) { carPair ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                carPair.forEach { car ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.White)
                            .clickable { onCarClick(car) }
                            .padding(10.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(car.imageUrl),
                                contentDescription = "Car Image",
                                modifier = Modifier
                                    .fillMaxWidth(0.7f)
                                    .aspectRatio(1f)
                                    .clip(RoundedCornerShape(12.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = car.name,
                                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                            Text(
                                text = car.category,
                                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium)
                            )
                            Text(
                                text = car.price,
                                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium)
                            )
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun CarCategoryList() {
    val categories = listOf(
        "Economy", "Standard", "Luxury", "SUV",
        "Vans", "Pickup", "Electric", "Convertible"
    )

    LazyRow(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        items(categories) { category ->
            val brands = getBrandsForCategory(category)
            CategoryItem(category)
        }
    }
}

@Composable
fun CategoryItem(category: String) {
    val context = LocalContext.current

    Text(
        text = category,
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
            .padding(12.dp)
            .clickable {
                // Use the navigateToCategoryDetails function to navigate to the details activity
                context.navigateToCategoryDetails(category)  // Using the extension function for navigation
            },
        style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium)
    )
}



@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    AutoRentalTheme {
        HomeScreen()
    }
}
