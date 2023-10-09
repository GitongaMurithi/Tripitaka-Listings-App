package com.example.listingsapp_tripitaca.di

import android.app.Application
import android.content.Context
import com.example.listingsapp_tripitaca.data.repository.ListingsRepositoryImpl
import com.example.listingsapp_tripitaca.domain.repository.ListingsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun provideContext(application: Application) : Context {
        return application.applicationContext
    }
    @Provides
    @Singleton
    fun providesRepository(context: Context) : ListingsRepository {
        return ListingsRepositoryImpl(context)
    }
}