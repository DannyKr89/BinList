package com.dk.binlist.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dk.binlist.data.room.entity.CardEntity

@Database(entities = [CardEntity::class], version = 1)
abstract class BinsDatabase : RoomDatabase() {
    abstract fun binDao(): BinDao
}