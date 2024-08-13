package com.dk.binlist.domain.repository

import com.dk.binlist.domain.BinResponse
import com.dk.binlist.domain.model.Card
import kotlinx.coroutines.flow.Flow

interface BinRepository {
    suspend fun loadBin(bin: String): Flow<BinResponse<Card>>

    suspend fun getBins(): Flow<BinResponse<List<Card>>>

    suspend fun insertCard(card: Card)
}