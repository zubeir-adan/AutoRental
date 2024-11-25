package com.example.autorental

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.autorental.history.HistoryScreen
import com.example.autorental.home.HomeScreen
import com.example.autorental.inbox.InboxScreen
import com.example.autorental.profile.ProfileScreen
import com.example.autorental.reusable.BottomNavBar
import com.example.autorental.ui.theme.AutoRentalTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AutoRentalTheme {
                // Initialize Firebase instances
                val auth = FirebaseAuth.getInstance()
                val db = FirebaseFirestore.getInstance()

                MainScreen(auth = auth, db = db)
            }
        }
    }
}

@Composable
fun MainScreen(auth: FirebaseAuth, db: FirebaseFirestore) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen()
            }
            composable("history") {
                HistoryScreen()
            }
            composable("inbox") {
                InboxScreen()
            }
            composable("profile") {
                // Pass FirebaseAuth and Firestore to the ProfileScreen
                ProfileScreen(auth = auth, db = db)
            }
        }
    }
}
