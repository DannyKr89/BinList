package com.dk.binlist.data.repository

import com.dk.binlist.data.retrofit.ApiService
import com.dk.binlist.data.toCard
import com.dk.binlist.domain.repository.BinRepository
import com.dk.binlist.presentation.search.SearchScreenState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BinRepositoryImpl @Inject constructor(private val apiService: ApiService) : BinRepository {

    override suspend fun loadBin(bin: String): Flow<SearchScreenState> = flow {
        emit(SearchScreenState.Loading)
        try {
            val card = apiService.loadBin(bin).toCard()
            emit(SearchScreenState.Success(card))
        } catch (e: Exception) {
            emit(SearchScreenState.Error(e))
        }
    }
}