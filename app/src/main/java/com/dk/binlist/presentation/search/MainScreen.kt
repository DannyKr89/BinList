package com.dk.binlist.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dk.binlist.presentation.search.component.BinCard
import com.dk.binlist.presentation.search.component.Loading
import com.dk.binlist.presentation.search.component.Search

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val viewModel: SearchViewModel = viewModel()
    val screenState = viewModel.state.collectAsState(SearchScreenState.Initial)

    Scaffold { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Search {
                viewModel.loadBin(it)
            }
            when (val currentState = screenState.value) {
                SearchScreenState.Initial -> {}

                is SearchScreenState.Error -> {
                    currentState.message.localizedMessage?.let { Text(text = it) }
                }

                SearchScreenState.Loading -> {
                    Loading()
                }

                is SearchScreenState.Success -> {
                    BinCard(card = currentState.card)
                }
            }
        }

    }
}