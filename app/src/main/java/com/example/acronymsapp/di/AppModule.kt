package com.example.acronymsapp.di

import com.example.acronymsapp.constants.Constant.BASE_URL
import com.example.acronymsapp.data.AcronymsApiService
import com.example.acronymsapp.data.AcronymsRepository
import com.example.acronymsapp.data.AcronymsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideAcronymsApiService(retrofit: Retrofit) : AcronymsApiService {
        return retrofit.create(AcronymsApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAcronymRepository(apiService: AcronymsApiService): AcronymsRepository {
        return AcronymsRepositoryImpl(apiService)
    }

}