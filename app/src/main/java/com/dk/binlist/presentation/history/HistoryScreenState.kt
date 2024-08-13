package com.dk.binlist.presentation.history

import com.dk.binlist.domain.model.Card

sealed class HistoryScreenState {
    data object Initial : HistoryScreenState()
    data class Success(val binList: List<Card>) : HistoryScreenState()
    data class Error(val message: Throwable) : HistoryScreenState()
    data object Loading : HistoryScreenState()
}