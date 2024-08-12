package com.dk.binlist.domain.use_case

import com.dk.binlist.domain.repository.BinRepository
import com.dk.binlist.presentation.search.SearchScreenState
import kotlinx.coroutines.flow.Flow

class LoadBinUseCase(private val repository: BinRepository) {

    suspend operator fun invoke(bin: String): Flow<SearchScreenState> {
        return repository.loadBin(bin)
    }
}