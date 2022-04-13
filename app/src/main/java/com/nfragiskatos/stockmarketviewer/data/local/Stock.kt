package com.nfragiskatos.stockmarketviewer.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CompanyListingEntity::class],
    version = 1
)
abstract class Stock : RoomDatabase(){
    abstract val dao: StockDao
}