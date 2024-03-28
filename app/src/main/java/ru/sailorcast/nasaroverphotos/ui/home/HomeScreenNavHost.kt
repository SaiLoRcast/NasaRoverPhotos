package ru.sailorcast.nasaroverphotos.ui.home

import ru.sailorcast.nasaroverphotos.data.model.Photo


sealed class HomeScreenNavHost(val route: String, val name: String) {
    object Curiosity : HomeScreenNavHost("Curiosity", "Curiosity")
    object Opportunity : HomeScreenNavHost("Opportunity", "Opportunity")
    object Spirit : HomeScreenNavHost("Spirit", "Spirit")
    object Details : HomeScreenNavHost("/Details", "Details")
}
