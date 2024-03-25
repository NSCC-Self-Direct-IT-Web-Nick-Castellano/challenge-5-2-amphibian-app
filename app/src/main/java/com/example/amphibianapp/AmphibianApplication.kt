package com.example.amphibianapp

import android.app.Application
import com.example.amphibianapp.data.AppContainer
import com.example.amphibianapp.data.DefaultAppContainer

class AmphibianApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}