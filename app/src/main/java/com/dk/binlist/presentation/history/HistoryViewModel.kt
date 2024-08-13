package com.dk.binlist.presentation.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dk.binlist.domain.BinResponse
import com.dk.binlist.domain.use_case.GetBinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getBinsUseCase: GetBinsUseCase
) : ViewModel() {
    private val _state: MutableStateFlow<HistoryScreenState> =
        MutableStateFlow(HistoryScreenState.Initial)
    val state = _state.asStateFlow()

    private var job: Job? = null

    private val exceptionHandler = CoroutineExceptionHandler { _, t ->
        _state.value = HistoryScreenState.Error(t)
    }

    init {
        getBins()
    }

    private fun getBins() {
        job?.cancel()
        job = viewModelScope.launch(exceptionHandler) {
            val response = getBinsUseCase.invoke()
            response.collect {
                when (it) {
                    is BinResponse.Error -> {
                        _state.value = HistoryScreenState.Error(it.error)
                    }

                    is BinResponse.Loading -> {
                        _state.value = HistoryScreenState.Loading
                    }

                    is BinResponse.Success -> {
                        _state.value = HistoryScreenState.Success(it.data)
                    }
                }
            }
        }
    }
}