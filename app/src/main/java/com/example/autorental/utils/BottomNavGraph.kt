// BottomNavGraph.kt
package com.example.autorental.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.autorental.history.HistoryScreen
import com.example.autorental.home.HomeScreen
import com.example.autorental.inbox.InboxScreen
import com.example.autorental.profile.Profile

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home" // Initial screen to load when the app starts
    ) {
        composable(route = "home") {
            HomeScreen() // This references the `HomeScreen` composable in your renamed `Home.kt`
        }
        composable(route = "history") {
            HistoryScreen() // Replace with the composable for the History screen
        }
        composable(route = "inbox") {
            InboxScreen() // Replace with the composable for the Inbox screen
        }
        composable(route = "profile") {
            Profile() // Replace with the composable for the Profile screen
        }
    }
}
