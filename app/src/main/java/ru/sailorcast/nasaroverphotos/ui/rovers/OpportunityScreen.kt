package ru.sailorcast.nasaroverphotos.ui.rovers

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import ru.sailorcast.nasaroverphotos.ui.components.RoverPhotoItem
import ru.sailorcast.nasaroverphotos.ui.home.NasaRoverPhotosViewModel

@Composable
fun OpportunityScreen(viewModel: NasaRoverPhotosViewModel) {

    val photos = viewModel.opportunityPhotos.collectAsState()

    if (photos.value.isEmpty()) {
        viewModel.getOpportunityPhotos()
    }

    LazyColumn() {
        items(photos.value) {
            RoverPhotoItem(it)
        }
    }

}