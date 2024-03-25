package ru.sailorcast.nasaroverphotos.data.repository

import ru.sailorcast.nasaroverphotos.data.api.NasaApiService
import ru.sailorcast.nasaroverphotos.data.model.PhotosResponse

class NasaRoverPhotosRepositoryImpl(private val apiService: NasaApiService) :
    NasaRoverPhotosRepository {

    override suspend fun getCuriosityPhotos(sol: Int, page: Int): PhotosResponse {
        return apiService.getCuriosityPhotos(sol, page)
    }

    override suspend fun getOpportunityPhotos(sol: Int, page: Int): PhotosResponse {
        return apiService.getOpportunityPhotos(sol, page)
    }

    override suspend fun getSpiritPhotos(sol: Int, page: Int): PhotosResponse {
        return apiService.getSpiritPhotos(sol, page)
    }


}
