package ru.sailorcast.nasaroverphotos.ui.home

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.sailorcast.nasaroverphotos.navigation.HomeScreenNavGraph
import ru.sailorcast.nasaroverphotos.ui.components.BottomNavBar

@Composable
fun HomeScreen(
    viewModel: NasaRoverPhotosViewModel,
    navHostController: NavHostController = rememberNavController()
) {

    Scaffold(bottomBar = { BottomNavBar(navController = navHostController) }) { paddingValues ->
        HomeScreenNavGraph(navController = navHostController, viewModel = viewModel)
    }

}
