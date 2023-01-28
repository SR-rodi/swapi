package com.example.starwarsapi.di.module

import com.example.starwarsapi.di.binds.AppBinds
import com.example.starwarsapi.feature.data.api.StarWarsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module(
    includes = [
        AppBinds::class,
        DatabaseModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
    ]
)
class Module {

    @Provides
    fun providerRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideApi(retrofit: Retrofit) = retrofit.create<StarWarsApi>()

    companion object {
        private const val BASE_URL = "https://swapi.dev/api/"
    }
}