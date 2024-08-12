package com.dk.binlist.di

import com.dk.binlist.data.repository.BinRepositoryImpl
import com.dk.binlist.data.retrofit.ApiService
import com.dk.binlist.domain.repository.BinRepository
import com.dk.binlist.domain.use_case.LoadBinUseCase
import com.dk.binlist.utils.Consts.BASE_URL
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
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService): BinRepository {
        return BinRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideLoadBinUseCase(repository: BinRepository): LoadBinUseCase {
        return LoadBinUseCase(repository)
    }

}