package com.example.starwarsapi.di

import android.content.Context
import com.example.starwarsapi.feature.presentation.viewfactory.ViewModelFactory
import dagger.BindsInstance
import dagger.Component

@Component(modules = [Module::class])
interface AppComponent {

    val viewModelFactory: ViewModelFactory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}