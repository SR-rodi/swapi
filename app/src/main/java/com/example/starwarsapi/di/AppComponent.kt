package com.example.starwarsapi.di

import com.example.starwarsapi.feature.presentation.viewfactory.ViewModelFactory
import dagger.Component

@Component(modules = [Module::class])
interface AppComponent {

    val viewModelFactory: ViewModelFactory
}