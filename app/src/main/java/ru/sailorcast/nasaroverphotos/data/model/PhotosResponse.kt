package ru.sailorcast.nasaroverphotos.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PhotosResponse(val photos: List<Photo>)

@Serializable
data class Photo(
    val camera: Camera,
    val earth_date: String,
    val id: String,
    val img_src: String,
    val rover: Rover,
    val sol: String
)

@Serializable
data class Camera(
    val full_name: String,
    val id: Int,
    val name: String,
    val rover_id: Int
) {
    val getFullName get() = "$name - $full_name"
}

@Serializable
data class Rover(
    val roverCameras: List<RoverCamera> = arrayListOf(),
    val id: Int,
    val landing_date: String,
    val launch_date: String,
    val max_date: String,
    val max_sol: Int,
    val name: String,
    val status: String,
    val total_photos: Int
)

@Serializable
data class RoverCamera(val full_name: String, val name: String)