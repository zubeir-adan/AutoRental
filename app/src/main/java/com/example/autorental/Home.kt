@file:Suppress("DEPRECATION")

package com.example.autorental

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowInsetsControllerCompat
import coil.compose.rememberAsyncImagePainter
import com.example.autorental.CarSection
import com.example.autorental.reusable.HeaderSection
import com.example.autorental.ui.theme.AutoRentalTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.isAppearanceLightStatusBars = false
        window.statusBarColor = android.graphics.Color.parseColor("#D3D3D3")

        setContent {
            AutoRentalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        HeaderSection()
                        SearchBar()
                        TopBrandsLabel()
                        CarLogosRow()
                        CarRecommendationsLabel()
                        CarRecommendationsFromSection()
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column {
        // Display the header
        HeaderSection()

    }
}


@Composable
fun CarLogosRow() {
    val logos = listOf(
        "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/nissan.jpg",
        "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/bmw.jpg",
        "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/toyota.jpg",
        "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/audi.jpg",
        "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/ford.jpg",
        "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/chevy.jpg",
        "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/benz.jpg",
        "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/honda.jpg",
        "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/hyundai.png",
        "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/jeep.jpg",
        "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/tesla.jpg",
        "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/logo/volkswagen.jpg"
    )

    Row(
        modifier = Modifier
            .padding(16.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        logos.forEach { url ->
            LogoImage(url)
        }
    }
}

@Composable
fun LogoImage(url: String) {
    val imageSize = 70.dp
    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .size(imageSize)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = rememberAsyncImagePainter(url),
            contentDescription = "Car Logo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun SearchBar() {
    TextField(
        value = "",
        onValueChange = {},
        placeholder = { Text("Search for a car") },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search Icon",
                modifier = Modifier.padding(end = 8.dp)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(56.dp),
        shape = RoundedCornerShape(12.dp),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions.Default
    )
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
}

@Composable
fun CarRecommendationsFromSection() {
    val cars = CarSection.getCarRecommendations()

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        item {
            CarCategoryList()
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
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
        "Economy", "Standard", "Full size", "Luxury", "SUV",
        "Vans", "Pickup", "Electric", "Convertible"
    )

    LazyRow(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        items(categories) { category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun CategoryItem(category: String) {
    Text(
        text = category,
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
            .padding(12.dp)
            .clickable {
                // Handle category selection here
            },
        style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium)
    )
}

@Preview
@Composable
fun PreviewHomeActivity() {
    AutoRentalTheme {
        HomeActivity()
    }
}