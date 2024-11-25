@file:Suppress("DEPRECATION")

package com.example.autorental.reusable

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(navController: NavController) {
    val bottomNavColor = Color(0xFFD3D3D3) // Set bottom nav bar background color to light gray
    SetupSystemUiColors(bottomNavColor) // Set system navigation bar color

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.History,
        BottomNavItem.Inbox,
        BottomNavItem.Profile
    )

    NavigationBar(
        containerColor = bottomNavColor,
        modifier = Modifier.height(56.dp) // Reduced the height by 20%
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        tint = if (currentRoute == item.route) Color.Black else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        color = if (currentRoute == item.route) Color.Black else Color.Gray
                    )
                },
                alwaysShowLabel = true
            )
        }
    }
}

@SuppressLint("ObsoleteSdkInt")
@Composable
fun SetupSystemUiColors(bottomNavColor: Color) {
    val view = LocalView.current
    val context = LocalContext.current
    SideEffect {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && context is Activity) {
            context.window.navigationBarColor = bottomNavColor.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightNavigationBars = true
        }
    }
}

sealed class BottomNavItem(val route: String, val label: String, val icon: ImageVector) {
    data object Home : BottomNavItem("home", "Home", Icons.Default.Home)
    data object History : BottomNavItem("history", "History", Icons.Default.ThumbUp)
    data object Inbox : BottomNavItem("inbox", "Inbox", Icons.Default.Email)
    data object Profile : BottomNavItem("profile", "Profile", Icons.Default.Person)
}