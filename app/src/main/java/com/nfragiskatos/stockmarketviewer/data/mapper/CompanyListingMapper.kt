package com.nfragiskatos.stockmarketviewer.data.mapper

import com.nfragiskatos.stockmarketviewer.data.local.CompanyListingEntity
import com.nfragiskatos.stockmarketviewer.data.remote.dto.CompanyInfoDto
import com.nfragiskatos.stockmarketviewer.domain.model.CompanyInfo
import com.nfragiskatos.stockmarketviewer.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {
    return CompanyInfo(
        symbol = symbol ?: "",
        description = description ?: "",
        name = name ?: "",
        country = country ?: "",
        industry = industry ?: ""
    )
}