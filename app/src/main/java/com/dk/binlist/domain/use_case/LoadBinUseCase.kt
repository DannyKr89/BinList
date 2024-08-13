package com.dk.binlist.domain.use_case

import com.dk.binlist.domain.BinResponse
import com.dk.binlist.domain.model.Card
import com.dk.binlist.domain.repository.BinRepository
import com.dk.binlist.utils.Consts
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoadBinUseCase @Inject constructor(private val repository: BinRepository) {

    suspend operator fun invoke(bin: String): Flow<BinResponse<Card>> {
        return if (bin.isNotEmpty() && bin.length >= 6) {
            return repository.loadBin(bin)
        } else {
            flow {
                emit(
                    BinResponse.Error(
                        Throwable(Consts.BIN_LENGTH_WARNING)
                    )
                )
            }
        }

    }
}