package com.nfragiskatos.stockmarketviewer.domain.repository

import com.nfragiskatos.stockmarketviewer.domain.model.CompanyListing
import com.nfragiskatos.stockmarketviewer.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>
}