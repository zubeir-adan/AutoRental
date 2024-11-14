package com.example.autorental

data class Car(val name: String, val category: String, val price: String, val imageUrl: String, val brand: String)

object EconomyCars {
    fun getCars() = listOf(
        Car("Ford Fiesta", "Economy", "KSh 3,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/ford-fiesta.jpg", "Ford"),
        Car("Honda Fit", "Economy", "KSh 3,600/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/honda-fit.jpg", "Honda"),
        Car("Hyundai Accent", "Economy", "KSh 3,400/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/hyundai-accent.jpg", "Hyundai"),
        Car("Kia Rio", "Economy", "KSh 3,300/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/kia-rio.jpg", "Kia"),
        Car("Nissan Versa", "Economy", "KSh 3,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/nissan-versa.jpg", "Nissan"),
        Car("Toyota Yaris", "Economy", "KSh 3,600/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/economy/toyota-yaris.jpg", "Toyota")
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}

// Standard category
object StandardCars {
    fun getCars() = listOf(
        Car("Honda Civic", "Standard", "KSh 4,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/standard/honda-civic.jpg", "Honda"),
        Car("Hyundai Electra", "Standard", "KSh 4,200/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/standard/hyundai-electra.jpg", "Hyundai"),
        Car("Mazda 3", "Standard", "KSh 3,800/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/standard/mazda3.jpg", "Mazda"),
        Car("Nissan Sentra", "Standard", "KSh 4,100/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/standard/nissan-sentra.jpg", "Nissan"),
        Car("Toyota Corolla", "Standard", "KSh 3,900/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/standard/toyota-corolla.jpg", "Toyota"),
        Car("Volkswagen Jetta", "Standard", "KSh 4,300/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/standard/volkwagen-jetta.jpg", "Volkswagen")
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}

// Luxury category
object LuxuryCars {
    fun getCars() = listOf(
        Car("Audi A4", "Luxury", "KSh 10,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/luxury/audi-a4.jpg", "Audi"),
        Car("Benz C-Class", "Luxury", "KSh 12,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/luxury/benz-c-class.jpg", "Benz"),
        Car("BMW 3", "Luxury", "KSh 11,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/luxury/bmw-3.jpg", "BMW"),
        Car("Cadillac CT5", "Luxury", "KSh 13,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/luxury/cadillac-ct5.jpg", "Cadillac"),
        Car("Genesis G70", "Luxury", "KSh 14,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/luxury/genesis-g70.jpg", "Genesis"),
        Car("Lexus ES", "Luxury", "KSh 12,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/luxury/lexus-es.jpg", "Lexus")
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}

// SUV category
object SUVCars {
    fun getCars() = listOf(
        Car("Chevrolet Tahoe", "SUV", "KSh 7,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/suv/chevrolet-tahoe.jpg", "Chevrolet"),
        Car("Jeep Grand Cherokee", "SUV", "KSh 8,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/suv/jeep-brand.jpg", "Jeep"),
        Car("Mazda CX-5", "SUV", "KSh 6,800/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/suv/mazda-cx5.jpg", "Mazda"),
        Car("Toyota Highlander", "SUV", "KSh 7,200/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/suv/toyota-highlander.jpg", "Toyota"),
        Car("Toyota RAV4", "SUV", "KSh 6,900/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/suv/toyota-rav4.jpg", "Toyota"),
        Car("Toyota Sequoia", "SUV", "KSh 7,700/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/suv/toyota-sequioa.jpg", "Toyota")
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}

// Vans category
object VanCars {
    fun getCars() = listOf(
        Car("Benz Metris", "Vans", "KSh 8,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/vans/benz-metris.jpg", "Benz"),
        Car("Dodge Grand Caravan", "Vans", "KSh 8,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/vans/dodge-grand.jpg", "Dodge"),
        Car("Kia Carnival", "Vans", "KSh 7,900/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/vans/kia-carnival.jpg", "Kia"),
        Car("Toyota Sienna", "Vans", "KSh 8,200/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/vans/toyota-sienna.jpg", "Toyota")
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}

// Pickup category
object PickupCars {
    fun getCars() = listOf(
        Car("Chevrolet Silverado", "Pickup", "KSh 9,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/pickup/chevrolet-silverado.jpg", "Chevrolet"),
        Car("Ford F-150", "Pickup", "KSh 9,200/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/pickup/ford-f150.jpg", "Ford"),
        Car("Nissan Frontier", "Pickup", "KSh 8,800/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/pickup/nissan-frontier.jpg", "Nissan"),
        Car("RAM 1500", "Pickup", "KSh 9,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/pickup/ram1500.jpg", "RAM"),
        Car("Toyota Tacoma", "Pickup", "KSh 8,600/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/pickup/toyota-tacoma.jpg", "Toyota")
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}

// Electric category
object ElectricCars {
    fun getCars() = listOf(
        Car("Chevrolet Bolt EV", "Electric", "KSh 6,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/electric/chevrolet-bolt.jpg", "Chevrolet"),
        Car("Nissan Leaf", "Electric", "KSh 6,800/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/electric/nissan-leaf.jpg", "Nissan"),
        Car("Tesla Model 3", "Electric", "KSh 9,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/electric/tesla-model3.jpg", "Tesla"),
        Car("Volkswagen ID.4", "Electric", "KSh 8,200/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/electric/volkswagen-id4.jpg", "Volkswagen")
    )

    fun getBrands() = getCars().map { it.brand }.distinct()
}

// Convertible category
object ConvertibleCars {
    fun getCars() = listOf(
        Car("Chevrolet Camaro Convertible", "Convertible", "KSh 12,500/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/convertible/chevrolet-camaro.jpg", "Chevrolet"),
        Car("Ford Mustang Convertible", "Convertible", "KSh 13,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/convertible/ford-mustang.jpg", "Ford"),
        Car("Mazda MX-5 Miata", "Convertible", "KSh 11,800/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/convertible/mazda-mx5.jpg", "Mazda"),
        Car("Porsche 911 Cabriolet", "Convertible", "KSh 18,000/day", "https://imaginative-nell-strathmore-34d67bf2.koyeb.app/mobile/category/convertible/porsche-911.jpg", "Porsche")
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

        // Debug: Print total cars before filtering
        println("Total cars available: ${allCars.size}")

        val filteredCars = allCars.filter { it.brand.equals(brand, ignoreCase = true) }

        // Debug: Print filtered cars count
        println("Filtered cars for $brand: ${filteredCars.size}")

        return filteredCars
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
