package com.nfragiskatos.stockmarketviewer.di

import com.nfragiskatos.stockmarketviewer.data.csv.CSVParser
import com.nfragiskatos.stockmarketviewer.data.csv.CompanyListingsParser
import com.nfragiskatos.stockmarketviewer.data.csv.IntraDayInfoParser
import com.nfragiskatos.stockmarketviewer.data.repository.StockRepositoryImpl
import com.nfragiskatos.stockmarketviewer.domain.model.CompanyListing
import com.nfragiskatos.stockmarketviewer.domain.model.IntraDayInfo
import com.nfragiskatos.stockmarketviewer.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsCompanyListingsParser(
        companyListingsParser: CompanyListingsParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindsIntraDayInfoParser(
        intraDayInfoParser: IntraDayInfoParser
    ): CSVParser<IntraDayInfo>

    @Binds
    @Singleton
    abstract fun bindsStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}