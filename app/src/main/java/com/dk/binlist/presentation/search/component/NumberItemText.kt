package com.dk.binlist.presentation.search.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dk.binlist.domain.model.Number

@Composable
fun NumberItemText(
    modifier: Modifier = Modifier,
    number: Number
) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = "CARD NUMBER"
        )
        Row {
            Column {
                Text(text = "LENGTH")
                Text(text = number.length.toString())
            }
            Column {
                Text(text = "LUHN")
                number.luhn?.let { Text(text = if (it) "yes" else "no") }
            }
        }
    }
}