package ru.sailorcast.nasaroverphotos.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.sailorcast.nasaroverphotos.data.model.Photo
import ru.sailorcast.nasaroverphotos.data.repository.NasaRoverPhotosRepositoryImpl

class NasaRoverPhotosViewModel(private val repository: NasaRoverPhotosRepositoryImpl) :
    ViewModel() {

    private val _curiosityPhotos = MutableStateFlow<List<Photo>>(listOf())
    val curiosityPhotos: StateFlow<List<Photo>> = _curiosityPhotos

    private val _currentPhoto = MutableStateFlow<Photo?>(null)
    val currentPhoto: StateFlow<Photo?> = _currentPhoto

    private val _opportunityPhotos = MutableStateFlow<List<Photo>>(listOf())
    val opportunityPhotos: StateFlow<List<Photo>> = _opportunityPhotos

    private val _spiritPhotos = MutableStateFlow<List<Photo>>(listOf())
    val spiritPhotos: StateFlow<List<Photo>> = _spiritPhotos

    private val _error = MutableStateFlow("")
    val error: MutableStateFlow<String> = _error

    fun getCuriosityPhotos() {
        viewModelScope.launch {
            try {
                val response = repository.getCuriosityPhotos(1000, 1)
                _curiosityPhotos.value = response.photos

            } catch (e: Exception) {
                _error.value = e.message ?: ""
            }
        }
    }

    fun getOpportunityPhotos() {
        viewModelScope.launch {
            try {
                val response = repository.getOpportunityPhotos(1000, 1)
                _opportunityPhotos.value = response.photos

            } catch (e: Exception) {
                _error.value = e.message ?: ""
            }
        }
    }

    fun getSpiritPhotos() {
        viewModelScope.launch {
            try {
                val response = repository.getSpiritPhotos(1000, 1)
                _spiritPhotos.value = response.photos

            } catch (e: Exception) {
                _error.value = e.message ?: ""
            }
        }
    }

    fun setCurrentPhoto(photo: Photo) {
        _currentPhoto.value = photo
    }

}