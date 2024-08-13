package com.dk.binlist.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dk.binlist.presentation.components.BinCard
import com.dk.binlist.presentation.components.Loading

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val screenState = viewModel.state.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Search(
            onSearchClick = { viewModel.loadBin(it) }
        )
        when (val currentState = screenState.value) {

            is SearchScreenState.Error -> {
                currentState.message.message?.let { Text(text = it) }
            }

            SearchScreenState.Loading -> Loading()
            is SearchScreenState.Success -> BinCard(card = currentState.card)
            SearchScreenState.Initial -> {}
        }
    }
}