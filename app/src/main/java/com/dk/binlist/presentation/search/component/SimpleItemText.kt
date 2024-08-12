package com.dk.binlist.presentation.search.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SimpleItemText(
    modifier: Modifier = Modifier,
    name: String,
    value: String
) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = name.uppercase()
        )
        Text(
            text = value
        )
    }
}