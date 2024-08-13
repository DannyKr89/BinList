package com.dk.binlist.di

import android.content.Context
import androidx.room.Room
import com.dk.binlist.data.repository.BinRepositoryImpl
import com.dk.binlist.data.retrofit.ApiService
import com.dk.binlist.data.room.BinDao
import com.dk.binlist.data.room.BinsDatabase
import com.dk.binlist.domain.repository.BinRepository
import com.dk.binlist.domain.use_case.GetBinsUseCase
import com.dk.binlist.domain.use_case.InsertCardUseCase
import com.dk.binlist.domain.use_case.LoadBinUseCase
import com.dk.binlist.utils.Consts.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideBinsDatabase(@ApplicationContext context: Context): BinsDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = BinsDatabase::class.java,
            "bins_database"
        ).build()
    }

    @Provides
    fun provideBinDao(binsDatabase: BinsDatabase): BinDao {
        return binsDatabase.binDao()
    }

    @Provides
    @Singleton
    fun provideRepository(
        apiService: ApiService,
        binDao: BinDao
    ): BinRepository {
        return BinRepositoryImpl(apiService, binDao)
    }

    @Provides
    fun provideLoadBinUseCase(repository: BinRepository): LoadBinUseCase {
        return LoadBinUseCase(repository)
    }

    @Provides
    fun provideInsertCardUseCase(repository: BinRepository): InsertCardUseCase {
        return InsertCardUseCase(repository)
    }

    @Provides
    fun provideGetBinsUseCase(repository: BinRepository): GetBinsUseCase {
        return GetBinsUseCase(repository)
    }


}