package ru.sailorcast.nasaroverphotos.ui.rovers

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import ru.sailorcast.nasaroverphotos.data.model.Photo
import ru.sailorcast.nasaroverphotos.ui.components.RoverPhotoItem
import ru.sailorcast.nasaroverphotos.ui.home.NasaRoverPhotosViewModel

@Composable
fun SpiritScreen(viewModel: NasaRoverPhotosViewModel,onItemClicked: (Photo) -> Unit) {

    val photos = viewModel.spiritPhotos.collectAsState()

    if (photos.value.isEmpty()) {
        viewModel.getSpiritPhotos()
    }

    LazyColumn() {
        items(photos.value) {
            RoverPhotoItem(it, onItemClicked)
        }
    }

}