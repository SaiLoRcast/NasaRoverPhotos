package ru.sailorcast.nasaroverphotos.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.sailorcast.nasaroverphotos.data.model.Photo

@Composable
fun RoverPhotoItem(photo: Photo) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Box {
            Row {
                AsyncImage(
                    modifier = Modifier
                        .size(128.dp)
                        .padding(8.dp),
                    model = photo.img_src,
                    contentDescription = null,
                )
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = photo.rover.name)
                    Text(text = photo.camera.getFullName)
                }
            }
        }
    }

}