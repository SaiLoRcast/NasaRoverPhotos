package ru.sailorcast.nasaroverphotos.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.sailorcast.nasaroverphotos.ui.home.NasaRoverPhotosViewModel

val viewModelModule = module {
    viewModel { NasaRoverPhotosViewModel(get()) }
}
