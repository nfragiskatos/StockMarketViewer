package com.nfragiskatos.stockmarketviewer.data.repository

import com.nfragiskatos.stockmarketviewer.data.csv.CSVParser
import com.nfragiskatos.stockmarketviewer.data.local.StockDatabase
import com.nfragiskatos.stockmarketviewer.data.mapper.toCompanyListing
import com.nfragiskatos.stockmarketviewer.data.mapper.toCompanyListingEntity
import com.nfragiskatos.stockmarketviewer.data.remote.StockApi
import com.nfragiskatos.stockmarketviewer.domain.model.CompanyListing
import com.nfragiskatos.stockmarketviewer.domain.repository.StockRepository
import com.nfragiskatos.stockmarketviewer.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    private val api: StockApi,
    private val db: StockDatabase,
    private val companyListingsParser: CSVParser<CompanyListing>
) : StockRepository {

    private val dao = db.dao

    override suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String,
    ): Flow<Resource<List<CompanyListing>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListings = dao.searchCompanyListings(query)
            emit(Resource.Success(
                localListings.map { it.toCompanyListing() }
            ))

            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val shouldOnlyLoadFromCache = !isDbEmpty && !fetchFromRemote

            if (shouldOnlyLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteListings = try {
                val response = api.getListings()
                companyListingsParser.parse(response.byteStream())

            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Error loading data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Error loading data"))
                null
            }

            remoteListings?.let { listings ->
                dao.clearCompanyListings()
                dao.insertCompanyListings(listings.map { it.toCompanyListingEntity() })
                emit(Resource.Success(
                    data = dao.searchCompanyListings("")
                        .map { it.toCompanyListing() }
                ))
                emit(Resource.Loading(false))
            }
        }
    }
}