package com.example.autorental

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
        Car(1,"Ford Fiesta", "Economy", "KSh 3,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/ford-fiesta.jpg", "Ford", 5, 4, 45.0, "Manual transmission, Compact size"),
        Car(2,"Honda Fit", "Economy", "KSh 3,600/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/honda-fit.jpg", "Honda", 5, 4, 40.0, "Automatic transmission, Fuel-efficient"),
        Car(3,"Hyundai Accent", "Economy", "KSh 3,400/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/hyundai-accent.jpg", "Hyundai", 5, 4, 45.0, "Automatic transmission, Easy to park"),
        Car(4,"Kia Rio", "Economy", "KSh 3,300/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/kia-rio.jpg", "Kia", 5, 4, 40.0, "Manual transmission, Compact size"),
        Car(5,"Nissan Versa", "Economy", "KSh 3,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/nissan-versa.jpg", "Nissan", 5, 4, 50.0, "Automatic transmission, Reliable"),
        Car(6,"Toyota Yaris", "Economy", "KSh 3,600/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/toyota-yaris.jpg", "Toyota", 5, 4, 40.0, "Automatic transmission, Great fuel economy")
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}

// Standard category
object StandardCars {
    fun getCars() = listOf(
        Car(7,"Honda Civic", "Standard", "KSh 4,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/standard/honda-civic.jpg", "Honda", 5, 4, 50.0, "Automatic transmission, Smooth ride"),
        Car(8,"Hyundai Electra", "Standard", "KSh 4,200/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/standard/hyundai-electra.jpg", "Hyundai", 5, 4, 55.0, "Automatic transmission, Spacious"),
        Car(9, "Mazda 3", "Standard", "KSh 3,800/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/standard/mazda3.jpg", "Mazda", 5, 4, 48.0, "Manual transmission, Sporty design"),
        Car(10,"Nissan Sentra", "Standard", "KSh 4,100/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/standard/nissan-sentra.jpg", "Nissan", 5, 4, 50.0, "Automatic transmission, Reliable"),
        Car(11,"Toyota Corolla", "Standard", "KSh 3,900/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/standard/toyota-corolla.jpg", "Toyota", 5, 4, 50.0, "Automatic transmission, Great resale value"),
        Car(12,"Volkswagen Jetta", "Standard", "KSh 4,300/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/standard/volkwagen-jetta.jpg", "Volkswagen", 5, 4, 60.0, "Manual transmission, Smooth handling")
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}

// Luxury category
object LuxuryCars {
    fun getCars() = listOf(
        Car(13,"Audi A4", "Luxury", "KSh 10,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/luxury/audi-a4.jpg", "Audi", 5, 4, 65.0, "Automatic transmission, Luxury interior"),
        Car(14,"Benz C-Class", "Luxury", "KSh 12,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/luxury/benz-c-class.jpg", "Benz", 5, 4, 70.0, "Automatic transmission, High performance"),
        Car(15,"BMW 3", "Luxury", "KSh 11,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/luxury/bmw-3.jpg", "BMW", 5, 4, 65.0, "Manual transmission, Sporty design"),
        Car(16,"Cadillac CT5", "Luxury", "KSh 13,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/luxury/cadillac-ct5.jpg", "Cadillac", 5, 4, 70.0, "Automatic transmission, Premium features"),
        Car(17,"Genesis G70", "Luxury", "KSh 14,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/luxury/genesis-g70.jpg", "Genesis", 5, 4, 75.0, "Automatic transmission, Elegant styling"),
        Car(18,"Lexus ES", "Luxury", "KSh 12,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/luxury/lexus-es.jpg", "Lexus", 5, 4, 65.0, "Automatic transmission, Luxurious interior")
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}

// SUV category
object SUVCars {
    fun getCars() = listOf(
        Car(19,"Chevrolet Tahoe", "SUV", "KSh 7,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/suv/chevrolet-tahoe.jpg", "Chevrolet", 7, 4, 80.0, "Automatic transmission, Spacious"),
        Car(20,"Jeep Grand Cherokee", "SUV", "KSh 8,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/suv/jeep-brand.jpg", "Jeep", 7, 4, 85.0, "Automatic transmission, Off-road capabilities"),
        Car(21,"Mazda CX-5", "SUV", "KSh 6,800/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/suv/mazda-cx5.jpg", "Mazda", 5, 4, 60.0, "Manual transmission, Stylish"),
        Car(22,"Toyota Highlander", "SUV", "KSh 7,200/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/suv/toyota-highlander.jpg", "Toyota", 7, 4, 75.0, "Automatic transmission, Family-friendly"),
        Car(23,"Toyota RAV4", "SUV", "KSh 6,900/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/suv/toyota-rav4.jpg", "Toyota", 5, 4, 65.0, "Automatic transmission, Great fuel economy"),
        Car(24,"Toyota Sequoia", "SUV", "KSh 7,700/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/suv/toyota-sequioa.jpg", "Toyota", 7, 4, 80.0, "Automatic transmission, Off-road capabilities")
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}

// Van category
object VanCars {
    fun getCars() = listOf(
        Car(25,"Toyota Hiace", "Van", "KSh 8,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/van/toyota-hiace.jpg", "Toyota", 12, 4, 90.0, "Manual transmission, Spacious for groups"),
        Car(26,"Nissan NV350", "Van", "KSh 8,800/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/van/nissan-nv350.jpg", "Nissan", 12, 4, 85.0, "Automatic transmission, Family-friendly"),
        Car(27,"Mercedes-Benz Metris", "Van", "KSh 9,200/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/van/mercedes-benz-metris.jpg", "Mercedes-Benz", 8, 4, 75.0, "Automatic transmission, Luxury"),
        Car(28,"Ford Transit", "Van", "KSh 8,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/van/ford-transit.jpg", "Ford", 12, 4, 95.0, "Automatic transmission, Spacious cargo space"),
        Car(29,"Ram ProMaster City", "Van", "KSh 8,400/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/van/ram-promaster-city.jpg", "Ram", 8, 4, 85.0, "Manual transmission, Efficient"),
        Car(30,"Chevrolet Express", "Van", "KSh 8,600/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/van/chevrolet-express.jpg", "Chevrolet", 12, 4, 90.0, "Automatic transmission, Spacious")
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}
// Pickup category
object PickupCars {
    fun getCars() = listOf(
        Car(31,"Ford F-150", "Pickup", "KSh 9,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/pickup/ford-f150.jpg", "Ford", 5, 4, 95.0, "Automatic transmission, Heavy-duty"),
        Car(32,"Chevrolet Silverado", "Pickup", "KSh 10,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/pickup/chevrolet-silverado.jpg", "Chevrolet", 5, 4, 100.0, "Automatic transmission, Off-road capabilities"),
        Car(33,"Ram 1500", "Pickup", "KSh 9,700/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/pickup/ram-1500.jpg", "Ram", 5, 4, 95.0, "Automatic transmission, Towing capacity"),
        Car(34,"Toyota Tundra", "Pickup", "KSh 9,800/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/pickup/toyota-tundra.jpg", "Toyota", 5, 4, 100.0, "Automatic transmission, Rugged performance"),
        Car(35,"Nissan Frontier", "Pickup", "KSh 9,200/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/pickup/nissan-frontier.jpg", "Nissan", 5, 4, 90.0, "Manual transmission, Versatile"),
        Car(36,"GMC Sierra", "Pickup", "KSh 10,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/pickup/gmc-sierra.jpg", "GMC", 5, 4, 105.0, "Automatic transmission, Power-packed")
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}

// Electric category
object ElectricCars {
    fun getCars() = listOf(
        Car(37,"Tesla Model 3", "Electric", "KSh 12,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/electric/tesla-model3.jpg", "Tesla", 5, 4, 80.0, "Electric, Advanced autopilot features"),
        Car(38,"Chevrolet Bolt EV", "Electric", "KSh 11,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/electric/chevrolet-bolt.jpg", "Chevrolet", 5, 4, 66.0, "Electric, Affordable"),
        Car(39,"Nissan Leaf", "Electric", "KSh 10,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/electric/nissan-leaf.jpg", "Nissan", 5, 4, 60.0, "Electric, Eco-friendly"),
        Car(40,"BMW i3", "Electric", "KSh 13,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/electric/bmw-i3.jpg", "BMW", 4, 4, 50.0, "Electric, Unique design"),
        Car(41,"Audi e-Tron", "Electric", "KSh 15,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/electric/audi-etron.jpg", "Audi", 5, 4, 95.0, "Electric, High-performance SUV"),
        Car(42,"Jaguar I-Pace", "Electric", "KSh 16,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/electric/jaguar-ipace.jpg", "Jaguar", 5, 4, 90.0, "Electric, Luxury SUV")
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}

// Convertible category
object ConvertibleCars {
    fun getCars() = listOf(
        Car(43,"Mazda MX-5 Miata", "Convertible", "KSh 7,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/convertible/mazda-mx5-miata.jpg", "Mazda", 2, 2, 45.0, "Manual transmission, Sporty roadster"),
        Car(44,"BMW Z4", "Convertible", "KSh 12,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/convertible/bmw-z4.jpg", "BMW", 2, 2, 50.0, "Automatic transmission, Stylish design"),
        Car(45,"Ford Mustang Convertible", "Convertible", "KSh 13,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/convertible/ford-mustang-convertible.jpg", "Ford", 4, 2, 60.0, "Automatic transmission, Iconic design"),
        Car(46,"Chevrolet Camaro Convertible", "Convertible", "KSh 14,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/convertible/chevrolet-camaro.jpg", "Chevrolet", 4, 2, 55.0, "Automatic transmission, High performance"),
        Car(47,"Porsche 911 Cabriolet", "Convertible", "KSh 18,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/convertible/porsche-911-cabriolet.jpg", "Porsche", 2, 2, 70.0, "Manual transmission, Luxury"),
        Car(47,"Mercedes-Benz S-Class Cabriolet", "Convertible", "KSh 20,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/convertible/mercedes-benz-s-class.jpg", "Mercedes-Benz", 4, 2, 75.0, "Automatic transmission, Premium features")
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
            "Van" -> VanCars.getCars()
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
            "Van" -> VanCars.getBrands()
            "Pickup" -> PickupCars.getBrands()
            "Electric" -> ElectricCars.getBrands()
            "Convertible" -> ConvertibleCars.getBrands()
            else -> emptyList() // Return an empty list if the category is unknown
        }
    }
}
