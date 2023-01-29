package com.example.starwarsapi.di.component

import android.content.Context
import com.example.starwarsapi.di.module.Module
import com.example.starwarsapi.feature.presentation.viewfactory.ViewModelFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
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