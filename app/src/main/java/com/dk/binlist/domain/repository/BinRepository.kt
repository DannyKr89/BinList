package com.dk.binlist.domain.repository

import com.dk.binlist.presentation.search.SearchScreenState
import kotlinx.coroutines.flow.Flow

interface BinRepository {
    suspend fun loadBin(bin: String): Flow<SearchScreenState>
}