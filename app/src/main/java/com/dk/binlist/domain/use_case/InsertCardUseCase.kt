package com.dk.binlist.domain.use_case

import com.dk.binlist.domain.model.Card
import com.dk.binlist.domain.repository.BinRepository
import javax.inject.Inject

class InsertCardUseCase @Inject constructor(private val repository: BinRepository) {

    suspend operator fun invoke(card: Card) {
        repository.insertCard(card)
    }
}