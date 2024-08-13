package com.dk.binlist.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dk.binlist.domain.BinResponse
import com.dk.binlist.domain.use_case.InsertCardUseCase
import com.dk.binlist.domain.use_case.LoadBinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val loadBinUseCase: LoadBinUseCase,
    private val insertCardUseCase: InsertCardUseCase
) :
    ViewModel() {

    private val _state: MutableStateFlow<SearchScreenState> =
        MutableStateFlow(SearchScreenState.Initial)
    val state = _state.asStateFlow()

    private var job: Job? = null

    private val exceptionHandler = CoroutineExceptionHandler { _, t ->
        _state.value = SearchScreenState.Error(t)
    }

    fun loadBin(bin: String) {
        job?.cancel()
        job = viewModelScope.launch(exceptionHandler) {
            val response = loadBinUseCase.invoke(bin)
            response.collect {
                when (it) {
                    is BinResponse.Error -> {
                        _state.value = SearchScreenState.Error(it.error)
                    }

                    is BinResponse.Loading -> {
                        _state.value = SearchScreenState.Loading
                    }

                    is BinResponse.Success -> {
                        _state.value = SearchScreenState.Success(it.data)
                        insertCardUseCase.invoke(it.data.copy(bin = bin))
                    }
                }
            }
        }
    }
}