package com.dk.binlist.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dk.binlist.domain.use_case.LoadBinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val loadBinUseCase: LoadBinUseCase) :
    ViewModel() {

    private val _state: MutableStateFlow<SearchScreenState> =
        MutableStateFlow(SearchScreenState.Initial)
    val state: StateFlow<SearchScreenState> = _state.asStateFlow()

    fun loadBin(bin: String) {
        viewModelScope.launch {
            loadBinUseCase.invoke(bin).collect {
                _state.value = it
            }
        }
    }
}