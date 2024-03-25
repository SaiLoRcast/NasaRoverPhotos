package ru.sailorcast.nasaroverphotos.data.repository

import ru.sailorcast.nasaroverphotos.data.model.PhotosResponse

interface NasaRoverPhotosRepository {

    suspend fun getCuriosityPhotos(
        sol: Int, page: Int
    ): PhotosResponse

    suspend fun getOpportunityPhotos(
        sol: Int, page: Int
    ): PhotosResponse

    suspend fun getSpiritPhotos(
        sol: Int, page: Int
    ): PhotosResponse

}