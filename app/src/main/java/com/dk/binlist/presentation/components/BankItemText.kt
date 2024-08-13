package com.dk.binlist.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dk.binlist.R
import com.dk.binlist.domain.model.Bank

@Composable
fun BankItemText(
    modifier: Modifier = Modifier,
    bank: Bank
) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = stringResource(R.string.bank), color = MaterialTheme.colorScheme.onSecondary
        )
        bank.name?.let { Text(text = it) }
        bank.city?.let { Text(text = it) }
        bank.url?.let { Text(text = it) }
        bank.phone?.let { Text(text = it) }
    }
}