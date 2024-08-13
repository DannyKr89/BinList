package com.dk.binlist.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp

@Composable
fun SimpleItemText(
    modifier: Modifier = Modifier,
    name: String,
    value: String?
) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = name.uppercase(), color = MaterialTheme.colorScheme.onSecondary
        )
        Text(
            text = value?.capitalize(Locale.current).toString()
        )
    }
}