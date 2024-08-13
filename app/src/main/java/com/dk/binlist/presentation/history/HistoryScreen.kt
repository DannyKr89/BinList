package com.dk.binlist.presentation.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dk.binlist.presentation.components.BinCard
import com.dk.binlist.presentation.components.Loading

@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier,
    viewModel: HistoryViewModel = hiltViewModel()
) {
    val screenState = viewModel.state.collectAsState()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        when (val currentState = screenState.value) {
            is HistoryScreenState.Error -> {
                currentState.message.localizedMessage?.let { Text(text = it) }
            }

            HistoryScreenState.Loading -> Loading()

            is HistoryScreenState.Success -> {
                LazyColumn(
                    modifier = modifier.padding(16.dp)
                ) {
                    items(currentState.binList.reversed()) {
                        Text(text = "BIN/IIN: ${it.bin.toString()}")
                        BinCard(card = it)
                    }
                }
            }

            HistoryScreenState.Initial -> {}
        }
    }

}