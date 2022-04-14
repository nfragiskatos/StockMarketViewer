package com.nfragiskatos.stockmarketviewer.di

import android.app.Application
import androidx.room.Room
import com.nfragiskatos.stockmarketviewer.BuildConfig
import com.nfragiskatos.stockmarketviewer.data.local.StockDatabase
import com.nfragiskatos.stockmarketviewer.data.remote.StockApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesStockApi(): StockApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.ALPHA_VANTAGE_API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun providesStockDatabase(app: Application): StockDatabase {
        return Room.databaseBuilder(
            app,
            StockDatabase::class.java,
            "stockdb.db"
        )
            .build()
    }
}