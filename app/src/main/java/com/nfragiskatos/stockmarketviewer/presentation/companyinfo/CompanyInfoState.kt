package com.nfragiskatos.stockmarketviewer.presentation.companyinfo

import com.nfragiskatos.stockmarketviewer.domain.model.CompanyInfo
import com.nfragiskatos.stockmarketviewer.domain.model.IntraDayInfo

data class CompanyInfoState(
    val stockInfos: List<IntraDayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)