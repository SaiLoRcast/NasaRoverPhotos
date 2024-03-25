package ru.sailorcast.nasaroverphotos

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.sailorcast.nasaroverphotos.di.repositoryModule
import ru.sailorcast.nasaroverphotos.di.viewModelModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MainApplication)
            modules(repositoryModule, viewModelModule)
        }
    }

}