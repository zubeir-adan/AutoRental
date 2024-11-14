// Data class for Car details
data class Car(
    val name: String,
    val category: String,
    val price: String,
    val imageUrl: String,
    val brand: String // Add the 'brand' field
)

// Object to hold car data
object CarSection {

    // Function to get a list of car recommendations
    fun getCarRecommendations(): List<Car> {
        return listOf(
            Car(
                name = "Toyota Corolla",
                category = "Standard",
                price = "Ksh. 4000/day",
                imageUrl = "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/standard/toyota-corolla.jpg?w=100&h=200",
                brand = "Toyota" // Add a brand to each car
            ),
            Car(
                name = "Ford Fiesta",
                category = "Economy",
                price = "Ksh. 3500/day",
                imageUrl = "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/ford-fiesta.jpg",
                brand = "Ford" // Add a brand to each car
            ),
            Car(
                name = "Mini Cooper",
                category = "Convertible",
                price = "Ksh. 7000/day",
                imageUrl = "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/convertible/mini-cooper.jpg?w=400&h=200",
                brand = "Mini" // Add a brand to each car
            ),
            Car(
                name = "Honda Civic",
                category = "Standard",
                price = "Ksh. 3100/day",
                imageUrl = "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/standard/honda-civic.jpg?w=400&h=200",
                brand = "Honda" // Add a brand to each car
            ),
            Car(
                name = "Tesla Model 3",
                category = "Electric",
                price = "Ksh. 10,000/day",
                imageUrl = "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/electric/tesla-model3.jpg?w=400&h=200",
                brand = "Tesla" // Add a brand to each car
            ),
            Car(
                name = "Mazda CX5",
                category = "SUV",
                price = "Ksh. 9500/day",
                imageUrl = "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/su/maxda-cx5.jpg?w=400&h=200",
                brand = "Mazda" // Add a brand to each car
            )
        )
    }
}
