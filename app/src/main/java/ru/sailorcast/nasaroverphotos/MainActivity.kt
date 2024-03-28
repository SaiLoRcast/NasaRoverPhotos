package ru.sailorcast.nasaroverphotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import ru.sailorcast.nasaroverphotos.navigation.RootNavHost
import ru.sailorcast.nasaroverphotos.ui.theme.NasaRoverPhotosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NasaRoverPhotosTheme {
                RootNavHost(navHostController = rememberNavController())
            }
        }
    }
}
