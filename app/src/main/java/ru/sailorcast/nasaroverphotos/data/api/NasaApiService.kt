package ru.sailorcast.nasaroverphotos.data.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import ru.sailorcast.nasaroverphotos.data.model.PhotosResponse

class NasaApiService(private val client: HttpClient) {

    companion object {
        var BASE_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers"
        var API_KEY = "your api key"
    }

    suspend fun getCuriosityPhotos(
        sol: Int,
        page: Int
    ): PhotosResponse {
        val response = client.get {
            url("${BASE_URL}/curiosity/photos")
            parameter("sol", sol)
            parameter("api_key", API_KEY)
            parameter("page", page)
        }
        return response.body()
    }

    suspend fun getOpportunityPhotos(
        sol: Int,
        page: Int
    ): PhotosResponse {
        val response = client.get {
            url("${BASE_URL}/opportunity/photos")
            parameter("sol", sol)
            parameter("api_key", API_KEY)
            parameter("page", page)
        }
        return response.body()
    }

    suspend fun getSpiritPhotos(
        sol: Int,
        page: Int
    ): PhotosResponse {
        val response = client.get {
            url("${BASE_URL}/spirit/photos")
            parameter("sol", sol)
            parameter("api_key", API_KEY)
            parameter("page", page)
        }
        return response.body()
    }

}