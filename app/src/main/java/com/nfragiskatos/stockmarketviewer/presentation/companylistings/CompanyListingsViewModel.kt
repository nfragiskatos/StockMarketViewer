package com.nfragiskatos.stockmarketviewer.presentation.companylistings

import androidx.lifecycle.ViewModel
import com.nfragiskatos.stockmarketviewer.domain.repository.StockRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CompanyListingsViewModel @Inject constructor(
    private val stockRepository: StockRepository
) : ViewModel() {

}