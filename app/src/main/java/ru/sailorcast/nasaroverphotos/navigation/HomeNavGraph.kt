package ru.sailorcast.nasaroverphotos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.sailorcast.nasaroverphotos.ui.details.DetailsScreen
import ru.sailorcast.nasaroverphotos.ui.home.HomeScreenNavHost
import ru.sailorcast.nasaroverphotos.ui.home.NasaRoverPhotosViewModel
import ru.sailorcast.nasaroverphotos.ui.rovers.CuriosityScreen
import ru.sailorcast.nasaroverphotos.ui.rovers.OpportunityScreen
import ru.sailorcast.nasaroverphotos.ui.rovers.SpiritScreen

@Composable
fun HomeScreenNavGraph(
    navController: NavHostController = rememberNavController(),
    viewModel: NasaRoverPhotosViewModel
) {
    NavHost(navController = navController, startDestination = HomeScreenNavHost.Curiosity.route) {
        composable(HomeScreenNavHost.Curiosity.route) {
            CuriosityScreen(
                viewModel = viewModel,
                onItemClicked = {
                    viewModel.setCurrentPhoto(it)
                    navController.navigate(HomeScreenNavHost.Details.route)
                })
        }

        composable(HomeScreenNavHost.Opportunity.route) {
            OpportunityScreen(viewModel = viewModel,
                onItemClicked = {
                    viewModel.setCurrentPhoto(it)
                    navController.navigate(HomeScreenNavHost.Details.route)
                })
        }

        composable(HomeScreenNavHost.Spirit.route) {
            SpiritScreen(viewModel = viewModel,
                onItemClicked = {
                    viewModel.setCurrentPhoto(it)
                    navController.navigate(HomeScreenNavHost.Details.route)
                })
        }

        composable(HomeScreenNavHost.Details.route) {
            DetailsScreen(viewModel = viewModel, navController = navController)
        }
    }
}
