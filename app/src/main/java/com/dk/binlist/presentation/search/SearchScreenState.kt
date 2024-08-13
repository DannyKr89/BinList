package com.dk.binlist.presentation.search

import com.dk.binlist.domain.model.Card

sealed class SearchScreenState {

    data object Initial : SearchScreenState()
    data class Success(val card: Card) : SearchScreenState()
    data class Error(val message: Throwable) : SearchScreenState()
    data object Loading : SearchScreenState()
}