package ru.sailorcast.nasaroverphotos.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.sailorcast.nasaroverphotos.ui.rovers.CuriosityScreen
import ru.sailorcast.nasaroverphotos.ui.rovers.OpportunityScreen
import ru.sailorcast.nasaroverphotos.ui.rovers.SpiritScreen

@Composable
fun HomeScreen(
    viewModel: NasaRoverPhotosViewModel,
) {

    val navController = rememberNavController()

    val items = listOf(
        HomeScreenNavHost.Curiosity,
        HomeScreenNavHost.Opportunity,
        HomeScreenNavHost.Spirit,
    )

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icons.Filled.Settings },
                        label = { Text(screen.name) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = HomeScreenNavHost.Curiosity.route, Modifier.padding(innerPadding)) {
            composable(HomeScreenNavHost.Curiosity.route) { CuriosityScreen(viewModel = viewModel) }
            composable(HomeScreenNavHost.Opportunity.route) { OpportunityScreen(viewModel = viewModel) }
            composable(HomeScreenNavHost.Spirit.route) { SpiritScreen(viewModel = viewModel) }
        }

    }

}
