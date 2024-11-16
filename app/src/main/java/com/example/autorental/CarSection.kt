package com.example.autorental

object CarSection {

    // Function to get a list of car recommendations
    fun getCarRecommendations(): List<Car> {
        return listOf(
            Car(
                id = 1,
                name = "Toyota Corolla",
                category = "Standard",
                price = "KSh 4,000/day",
                imageUrl = "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/standard/toyota-corolla.jpg",
                brand = "Toyota",
                seats = 5,
                doors = 4,
                gasCapacity = 50.0,
                majorDetails = "Automatic transmission, Great resale value"
            ),
            Car(
                id = 2,
                name = "Ford Fiesta",
                category = "Economy",
                price = "KSh 3,500/day",
                imageUrl = "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/ford-fiesta.jpg",
                brand = "Ford",
                seats = 5,
                doors = 4,
                gasCapacity = 45.0,
                majorDetails = "Manual transmission, Compact size"
            ),
            Car(
                id = 3,
                name = "Mini Cooper",
                category = "Convertible",
                price = "KSh 7,000/day",
                imageUrl = "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/convertible/mini-cooper.jpg",
                brand = "Mini",
                seats = 4,
                doors = 2,
                gasCapacity = 40.0,
                majorDetails = "Automatic transmission, Stylish design"
            ),
            Car(
                id = 4,
                name = "Honda Civic",
                category = "Standard",
                price = "KSh 3,100/day",
                imageUrl = "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/standard/honda-civic.jpg",
                brand = "Honda",
                seats = 5,
                doors = 4,
                gasCapacity = 50.0,
                majorDetails = "Automatic transmission, Smooth ride"
            ),
            Car(
                id = 5,
                name = "Tesla Model 3",
                category = "Electric",
                price = "KSh 10,000/day",
                imageUrl = "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/electric/tesla-model3.jpg",
                brand = "Tesla",
                seats = 5,
                doors = 4,
                gasCapacity = 80.0,
                majorDetails = "Electric, Advanced autopilot features"
            ),
            Car(
                id = 6,
                name = "Mazda CX-5",
                category = "SUV",
                price = "KSh 9,500/day",
                imageUrl = "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/suv/mazda-cx5.jpg",
                brand = "Mazda",
                seats = 5,
                doors = 4,
                gasCapacity = 60.0,
                majorDetails = "Manual transmission, Stylish"
            )
        )
    }
}
