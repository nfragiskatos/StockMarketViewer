package com.nfragiskatos.stockmarketviewer.presentation.companylistings

import com.nfragiskatos.stockmarketviewer.domain.model.CompanyListing

data class CompanyListingsState(
    val companies: List<CompanyListing> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)
