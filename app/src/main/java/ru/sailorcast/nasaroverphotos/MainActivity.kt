package ru.sailorcast.nasaroverphotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.androidx.compose.navigation.koinNavViewModel
import ru.sailorcast.nasaroverphotos.ui.home.HomeScreen
import ru.sailorcast.nasaroverphotos.ui.theme.NasaRoverPhotosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NasaRoverPhotosTheme {
                HomeScreen(viewModel = koinNavViewModel())
            }
        }
    }
}
