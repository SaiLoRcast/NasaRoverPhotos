package ru.sailorcast.nasaroverphotos.ui.home


sealed class HomeScreenNavHost(val route: String, val name: String) {
    object Curiosity : HomeScreenNavHost("Curiosity", "Curiosity")
    object Opportunity : HomeScreenNavHost("Opportunity", "Opportunity")
    object Spirit : HomeScreenNavHost("Spirit", "Spirit")
}
