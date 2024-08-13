package com.dk.binlist.domain.use_case

import com.dk.binlist.domain.BinResponse
import com.dk.binlist.domain.model.Card
import com.dk.binlist.domain.repository.BinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBinsUseCase @Inject constructor(private val repository: BinRepository) {

    suspend operator fun invoke(): Flow<BinResponse<List<Card>>> {
        return repository.getBins()
    }
}