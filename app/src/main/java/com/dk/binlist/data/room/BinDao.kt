package com.dk.binlist.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dk.binlist.data.room.entity.CardEntity

@Dao
interface BinDao {
    @Query("select * from bins")
    suspend fun getBins(): List<CardEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(cardEntity: CardEntity)
}