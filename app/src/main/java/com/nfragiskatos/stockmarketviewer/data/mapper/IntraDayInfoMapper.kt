package com.nfragiskatos.stockmarketviewer.data.mapper

import com.nfragiskatos.stockmarketviewer.data.remote.dto.IntraDayInfoDto
import com.nfragiskatos.stockmarketviewer.domain.model.IntraDayInfo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun IntraDayInfoDto.toIntraDayInfo() : IntraDayInfo {
    val datePattern = "yyyy-MM-dd HH:mm:ss"
    val  formatter = DateTimeFormatter.ofPattern(datePattern, Locale.getDefault())
    val localDateTime = LocalDateTime.parse(timestamp, formatter)

    return IntraDayInfo(
        date = localDateTime,
        close = close
    )
}