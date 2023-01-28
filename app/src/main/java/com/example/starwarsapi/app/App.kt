package com.example.starwarsapi.app

import android.app.Application
import com.example.starwarsapi.di.AppComponent
import com.example.starwarsapi.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().context(this).build()
    }
}