package com.dk.binlist.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import com.dk.binlist.R
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
            text = stringResource(R.string.card_number),
            color = MaterialTheme.colorScheme.onSecondary
        )
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Column {
                Text(text = stringResource(R.string.length))
                Text(text = number.length.toString().capitalize(Locale.current))
            }
            Column {
                Text(text = stringResource(R.string.luhn))
                Text(
                    text = if (number.luhn != null) {
                        if (number.luhn) {
                            stringResource(id = R.string.yes)
                        } else {
                            stringResource(id = R.string.no)
                        }

                    } else stringResource(id = R.string._null)
                )
            }
        }
    }
}