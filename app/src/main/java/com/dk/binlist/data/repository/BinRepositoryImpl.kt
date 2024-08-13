package com.dk.binlist.data.repository

import com.dk.binlist.data.retrofit.ApiService
import com.dk.binlist.data.room.BinDao
import com.dk.binlist.data.toCard
import com.dk.binlist.data.toEntity
import com.dk.binlist.domain.BinResponse
import com.dk.binlist.domain.model.Card
import com.dk.binlist.domain.repository.BinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BinRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val binDao: BinDao
) : BinRepository {

    override suspend fun loadBin(bin: String): Flow<BinResponse<Card>> = flow {
        emit(BinResponse.Loading())
        try {
            val cardDto = apiService.loadBin(bin)
            emit(BinResponse.Success(cardDto.toCard()))
        } catch (e: Exception) {
            emit(BinResponse.Error(e))
        }

    }

    override suspend fun getBins(): Flow<BinResponse<List<Card>>> = flow {
        emit(BinResponse.Loading())
        try {
            val result = binDao.getBins()
            emit(BinResponse.Success(
                result.map {
                    it.toCard()
                }
            ))
        } catch (e: Exception) {
            emit(BinResponse.Error(e))
        }

    }

    override suspend fun insertCard(card: Card) {
        binDao.insertCard(card.toEntity())
        getBins()
    }
}