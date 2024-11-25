package com.example.autorental.data

data class Car(
    val id: Int,
    val name: String,        // Name of the car
    val category: String,    // Category of the car
    val price: String,       // Rental price per day
    val imageUrl: String,    // Image URL for the car
    val brand: String,       // Brand of the car
    val seats: Int,          // Number of seats
    val doors: Int,          // Number of doors
    val gasCapacity: Double, // Gas capacity in liters
    val majorDetails: String // Major details about the car (e.g., transmission, special features)
)
object EconomyCars {
    fun getCars() = listOf(
        Car(
            1,
            "Ford Fiesta",
            "Economy",
            "KSh 3,500/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/economy/ford-fiesta.png",
            "Ford",
            5,
            4,
            45.0,
            "Manual transmission, Compact size"
        ),
        Car(
            2,
            "Honda Fit",
            "Economy",
            "KSh 3,600/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/economy/honda-fit.png",
            "Honda",
            5,
            4,
            40.0,
            "Automatic transmission, Fuel-efficient"
        ),
        Car(
            3,
            "Hyundai Accent",
            "Economy",
            "KSh 3,400/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/economy/hyundai-accent.png",
            "Hyundai",
            5,
            4,
            45.0,
            "Automatic transmission, Easy to park"
        ),
        Car(
            4,
            "Kia Rio",
            "Economy",
            "KSh 3,300/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/economy/kia-rio.png",
            "Kia",
            5,
            4,
            40.0,
            "Manual transmission, Compact size"
        ),
        Car(
            5,
            "Nissan Versa",
            "Economy",
            "KSh 3,500/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/economy/nissan-versa.png",
            "Nissan",
            5,
            4,
            50.0,
            "Automatic transmission, Reliable"
        ),
        Car(
            6,
            "Toyota Yaris",
            "Economy",
            "KSh 3,600/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/economy/toyota-yaris.png",
            "Toyota",
            5,
            4,
            40.0,
            "Automatic transmission, Great fuel economy"
        )
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}
// Standard category
object StandardCars {
    fun getCars() = listOf(
        Car(
            7,
            "Honda Civic",
            "Standard",
            "KSh 4,000/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/standard/honda-civic.png",
            "Honda",
            5,
            4,
            50.0,
            "Automatic transmission, Smooth ride"
        ),
        Car(
            8,
            "Hyundai Elantra", // Corrected model name
            "Standard",
            "KSh 4,200/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/standard/hyundai-electra.png",
            "Hyundai",
            5,
            4,
            55.0,
            "Automatic transmission, Spacious"
        ),
        Car(
            9,
            "Mazda 3",
            "Standard",
            "KSh 3,800/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/standard/mazda3.png",
            "Mazda",
            5,
            4,
            48.0,
            "Manual transmission, Sporty design"
        ),
        Car(
            10,
            "Nissan Sentra",
            "Standard",
            "KSh 4,100/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/standard/nissan-sentra.png",
            "Nissan",
            5,
            4,
            50.0,
            "Automatic transmission, Reliable"
        ),
        Car(
            11,
            "Toyota Corolla",
            "Standard",
            "KSh 3,900/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/standard/toyota-corolla.png",
            "Toyota",
            5,
            4,
            50.0,
            "Automatic transmission, Great resale value"
        ),
        Car(
            12,
            "Volkswagen Jetta",
            "Standard",
            "KSh 4,300/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/standard/volkswagen-jetta.png",
            "Volkswagen",
            5,
            4,
            60.0,
            "Manual transmission, Smooth handling"
        )
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}
// Luxury category
object LuxuryCars {
    fun getCars() = listOf(
        Car(
            13,
            "Audi A4",
            "Luxury",
            "KSh 10,000/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/luxury/audi-a4.png",
            "Audi",
            5,
            4,
            65.0,
            "Automatic transmission, Luxury interior"
        ),
        Car(
            14,
            "Mercedes-Benz C-Class", // Corrected to full brand name
            "Luxury",
            "KSh 12,000/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/luxury/benz-c-class.png",
            "Mercedes-Benz", // Corrected to full brand name
            5,
            4,
            70.0,
            "Automatic transmission, High performance"
        ),
        Car(
            15,
            "BMW 3 Series", // Full model name
            "Luxury",
            "KSh 11,500/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/luxury/bmw-3.png",
            "BMW",
            5,
            4,
            65.0,
            "Manual transmission, Sporty design"
        ),
        Car(
            16,
            "Cadillac CT5",
            "Luxury",
            "KSh 13,000/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/luxury/cadillac-ct5.png",
            "Cadillac",
            5,
            4,
            70.0,
            "Automatic transmission, Premium features"
        ),
        Car(
            17,
            "Genesis G70",
            "Luxury",
            "KSh 14,000/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/luxury/genesis-g70.png",
            "Genesis",
            5,
            4,
            75.0,
            "Automatic transmission, Elegant styling"
        ),
        Car(
            18,
            "Lexus ES",
            "Luxury",
            "KSh 12,500/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/luxury/lexus-es.png",
            "Lexus",
            5,
            4,
            65.0,
            "Automatic transmission, Luxurious interior"
        )
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}

// SUV category
object SUVCars {
    fun getCars() = listOf(
        Car(
            19,
            "Chevrolet Tahoe",
            "SUV",
            "KSh 7,500/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/suv/chevrolet-tahoe.png",
            "Chevrolet",
            7,
            4,
            80.0,
            "Automatic transmission, Spacious"
        ),
        Car(
            20,
            "Jeep Grand Cherokee",
            "SUV",
            "KSh 8,000/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/suv/jeep-grand.png",
            "Jeep",
            7,
            4,
            85.0,
            "Automatic transmission, Off-road capabilities"
        ),
        Car(
            21,
            "Mazda CX-5",
            "SUV",
            "KSh 6,800/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/suv/maxda-cx5.png",
            "Mazda",
            5,
            4,
            60.0,
            "Manual transmission, Stylish"
        ),
        Car(
            22,
            "Toyota Highlander",
            "SUV",
            "KSh 7,200/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/suv/toyota-highlander.png",
            "Toyota",
            7,
            4,
            75.0,
            "Automatic transmission, Family-friendly"
        ),
        Car(
            23,
            "Toyota RAV4",
            "SUV",
            "KSh 6,900/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/suv/toyota-rav4.png",
            "Toyota",
            5,
            4,
            65.0,
            "Automatic transmission, Great fuel economy"
        ),
        Car(
            24,
            "Toyota Sequoia",
            "SUV",
            "KSh 7,700/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/suv/toyota-sequoia.png",
            "Toyota",
            7,
            4,
            80.0,
            "Automatic transmission, Off-road capabilities"
        )
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}
// Van category
object VanCars {
    fun getCars() = listOf(
        Car(
            25,
            "Toyota Hiace",
            "Vans",
            "KSh 8,500/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/vans/toyota-hiace.png",
            "Toyota",
            12,
            4,
            90.0,
            "Manual transmission, Spacious for groups"
        ),
        Car(
            26,
            "Dodge Grand",
            "Vans",
            "KSh 8,800/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/vans/dodge-grand.png",
            "Dodge",
            12,
            4,
            85.0,
            "Automatic transmission, Family-friendly"
        ),
        Car(
            27,
            "Mercedes-Benz Metris",
            "Vans",
            "KSh 9,200/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/vans/benz-metris.png",
            "Mercedes-Benz",
            8,
            4,
            75.0,
            "Automatic transmission, Luxury"
        ),
        Car(
            28,
            "Kia Carnival",
            "Vans",
            "KSh 8,000/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/vans/kia-carnival.png",
            "Kia",
            12,
            4,
            95.0,
            "Automatic transmission, Spacious cargo space"
        ),
        Car(
            29,
            "Toyota Sienna",
            "Vans",
            "KSh 8,400/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/vans/toyota-sienna.png",
            "Toyota",
            8,
            4,
            85.0,
            "Manual transmission, Efficient"
        ),

    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}
// Pickup category
object PickupCars {
    fun getCars() = listOf(
        Car(
            31,
            "Ford F-150",
            "Pickup",
            "KSh 9,500/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/pickup/ford-f150.png",
            "Ford",
            5,
            4,
            95.0,
            "Automatic transmission, Heavy-duty"
        ),
        Car(
            32,
            "Chevrolet Silverado",
            "Pickup",
            "KSh 10,000/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/pickup/chevrolet-silverado.png",
            "Chevrolet",
            5,
            4,
            100.0,
            "Automatic transmission, Off-road capabilities"
        ),
        Car(
            33,
            "Ram 1500",
            "Pickup",
            "KSh 9,700/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/pickup/ram-1500.png",
            "Ram",
            5,
            4,
            95.0,
            "Automatic transmission, Towing capacity"
        ),
        Car(
            34,
            "Toyota Tacoma",
            "Pickup",
            "KSh 9,800/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/pickup/toyota-tacoma.png",
            "Toyota",
            5,
            4,
            100.0,
            "Automatic transmission, Rugged performance"
        ),
        Car(
            35,
            "Nissan Frontier",
            "Pickup",
            "KSh 9,200/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/pickup/nissan-frontier.png",
            "Nissan",
            5,
            4,
            90.0,
            "Manual transmission, Versatile"
        )

    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}
// Electric category
object ElectricCars {
    fun getCars() = listOf(
        Car(
            37,
            "Tesla Model 3",
            "Electric",
            "KSh 12,000/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/electric/tesla-model3.png",
            "Tesla",
            5,
            4,
            80.0,
            "Electric, Advanced autopilot features"
        ),
        Car(
            38,
            "Toyota Prius",
            "Electric",
            "KSh 11,500/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/electric/toyota-prius.png",
            "Toyota",
            5,
            4,
            66.0,
            "Electric, Affordable"
        ),
        Car(
            39,
            "Nissan Leaf",
            "Electric",
            "KSh 10,000/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/electric/nissan-leaf.png",
            "Nissan",
            5,
            4,
            60.0,
            "Electric, Eco-friendly"
        ),
        Car(
            40,
            "Ford Mach",
            "Electric",
            "KSh 13,000/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/electric/ford-mach.png",
            "Ford",
            4,
            4,
            50.0,
            "Electric, Unique design"
        )
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}
// Convertible category
object ConvertibleCars {
    fun getCars() = listOf(
        Car(
            43,
            "Mazda MX-5 Miata",
            "Convertible",
            "KSh 7,500/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/convertible/mazda-miata.png",
            "Mazda",
            2,
            2,
            45.0,
            "Manual transmission, Sporty roadster"
        ),
        Car(
            44,
            "BMW Z4",
            "Convertible",
            "KSh 12,000/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/convertible/bmw-z4.png",
            "BMW",
            2,
            2,
            50.0,
            "Automatic transmission, Stylish design"
        ),
        Car(
            46,
            "Chevrolet Camaro Convertible",
            "Convertible",
            "KSh 14,000/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/convertible/camaro.png",
            "Chevrolet",
            4,
            2,
            55.0,
            "Automatic transmission, High performance"
        ),
        Car(
            47,
            "Porsche 911 Cabriolet",
            "Convertible",
            "KSh 18,000/day",
            "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/category/convertible/porsche.png",
            "Porsche",
            2,
            2,
            70.0,
            "Manual transmission, Luxury"
        ),        
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}

object CarCategoryProvider {
    // Function to get cars for a selected category
    fun getCarsForCategory(category: String): List<Car> {
        return when (category) {
            "Economy" -> EconomyCars.getCars()
            "Standard" -> StandardCars.getCars()
            "Luxury" -> LuxuryCars.getCars()
            "SUV" -> SUVCars.getCars()
            "Vans" -> VanCars.getCars()
            "Pickup" -> PickupCars.getCars()
            "Electric" -> ElectricCars.getCars()
            "Convertible" -> ConvertibleCars.getCars()
            else -> emptyList() // Return an empty list if the category is unknown
        }
    }

    // Function to get cars for a selected brand
    fun getCarsForBrand(brand: String?): List<Car> {
        if (brand.isNullOrEmpty()) return emptyList() // Return empty list if brand is null or empty

        // Debug: Print the brand we are filtering for
        println("Filtering cars for brand: $brand")

        // Combine all car lists across categories and filter by brand
        val allCars = EconomyCars.getCars()
            .asSequence()
            .plus(StandardCars.getCars())
            .plus(LuxuryCars.getCars())
            .plus(SUVCars.getCars())
            .plus(VanCars.getCars())
            .plus(PickupCars.getCars())
            .plus(ElectricCars.getCars())
            .plus(ConvertibleCars.getCars())
            .toList()

        // Filter cars by brand
        return allCars.filter { it.brand.equals(brand, ignoreCase = true) }
    }

    // Function to get brands for a selected category
    fun getBrandsForCategory(category: String): List<String> {
        return when (category) {
            "Economy" -> EconomyCars.getBrands()
            "Standard" -> StandardCars.getBrands()
            "Luxury" -> LuxuryCars.getBrands()
            "SUV" -> SUVCars.getBrands()
            "Vans" -> VanCars.getBrands()
            "Pickup" -> PickupCars.getBrands()
            "Electric" -> ElectricCars.getBrands()
            "Convertible" -> ConvertibleCars.getBrands()
            else -> emptyList() // Return an empty list if the category is unknown
        }
    }
}
