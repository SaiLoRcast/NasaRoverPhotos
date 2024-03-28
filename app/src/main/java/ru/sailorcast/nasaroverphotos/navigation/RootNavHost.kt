package ru.sailorcast.nasaroverphotos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.koin.androidx.compose.navigation.koinNavViewModel
import ru.sailorcast.nasaroverphotos.ui.home.HomeScreen

@Composable
fun RootNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = RootGraphs.Home.root
    ) {
        composable(route = RootGraphs.Home.root) {
            HomeScreen(viewModel = koinNavViewModel())
        }
    }
}


sealed class RootGraphs(val root: String) {
    object Home : RootGraphs("home")
}