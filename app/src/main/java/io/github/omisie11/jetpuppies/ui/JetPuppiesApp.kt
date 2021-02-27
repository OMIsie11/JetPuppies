package io.github.omisie11.jetpuppies.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.omisie11.jetpuppies.ui.screens.details.DetailsScreen
import io.github.omisie11.jetpuppies.ui.screens.main.MainScreen
import io.github.omisie11.jetpuppies.ui.theme.JetPuppiesTheme

@Composable
fun JetPuppiesApp() {
    val navController = rememberNavController()

    JetPuppiesTheme {
        NavHost(navController, startDestination = "home") {
            composable("home") { MainScreen(navController) }
            composable("details") { DetailsScreen(navController) }
        }
    }
}

@Preview
@Composable
fun JetPuppiesAppPreview() {
    JetPuppiesApp()
}