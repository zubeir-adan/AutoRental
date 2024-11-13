package com.example.autorental

// Data class for Car details
data class Car(
    val name: String,
    val category: String,
    val price: String,
    val imageUrl: String
)

// List of Economy Cars
val economyCars = listOf(
    Car(
        name = "Ford Fiesta",
        category = "Economy",
        price = "Ksh. 3500/day",
        imageUrl = "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/ford-fiesta.jpg"
    ),
    Car(
        name = "Honda Fit",
        category = "Economy",
        price = "Ksh. 3600/day",
        imageUrl = "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/honda-fit.jpg"
    ),
    Car(
        name = "Hyundai Accent",
        category = "Economy",
        price = "Ksh. 3400/day",
        imageUrl = "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/hyundai-accent.jpg"
    ),
    Car(
        name = "Kia Rio",
        category = "Economy",
        price = "Ksh. 3300/day",
        imageUrl = "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/kia-rio.jpg"
    ),
    Car(
        name = "Nissan Versa",
        category = "Economy",
        price = "Ksh. 3400/day",
        imageUrl = "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/nissan-versa.jpg"
    ),
    Car(
        name = "Toyota Yaris",
        category = "Economy",
        price = "Ksh. 3200/day",
        imageUrl = "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/toyota-yaris.jpg"
    )
)
