package com.nfragiskatos.stockmarketviewer.data.remote

import com.nfragiskatos.stockmarketviewer.BuildConfig
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {

    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("apikey") apiKey: String = BuildConfig.ALPHA_VANTAGE_API_KEY
    ) : ResponseBody
}