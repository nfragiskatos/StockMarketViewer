package com.nfragiskatos.stockmarketviewer.presentation.companyinfo

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.nfragiskatos.stockmarketviewer.domain.model.IntraDayInfo

@Composable
fun StockChart(
    infos: List<IntraDayInfo> = emptyList(),
    modifier: Modifier = androidx.compose.ui.Modifier,
    graphColor: Color = Color.Green
) {

}