package com.dk.binlist.presentation.search.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dk.binlist.domain.model.Country

@Composable
fun CountryItemText(
    modifier: Modifier = Modifier,
    country: Country
) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = "COUNTRY"
        )
        country.name?.let {
            Text(
                text = it + country.emoji
            )
        }
        Text(text = "(latitude: ${country.latitude}, longitude: ${country.longitude})")
    }
}