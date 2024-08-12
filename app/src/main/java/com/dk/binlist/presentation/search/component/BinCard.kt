package com.dk.binlist.presentation.search.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dk.binlist.domain.model.Bank
import com.dk.binlist.domain.model.Card
import com.dk.binlist.domain.model.Country
import com.dk.binlist.domain.model.Number

@Composable
fun BinCard(
    modifier: Modifier = Modifier,
    card: Card
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            item {
                card.scheme?.let { SimpleItemText(name = "scheme/network", value = it) }
            }
            item {
                card.type?.let { SimpleItemText(name = "type", value = it) }
            }
            item { card.country?.let { CountryItemText(country = it) } }

            item {
                card.brand?.let { SimpleItemText(name = "brand", value = it) }
            }
            item {
                card.prepaid?.let {
                    SimpleItemText(
                        name = "prepaid",
                        value = if (it) "yes" else "no"
                    )
                }
            }
            item { card.bank?.let { BankItemText(bank = it) } }

            item { card.number?.let { NumberItemText(number = it) } }
        }
    }
}

@Preview
@Composable
fun PreviewBinCard(modifier: Modifier = Modifier) {
    BinCard(
        card = Card(
            bank = Bank(
                city = "Hjorring",
                name = "Jyske Bank",
                phone = "+4589893300",
                url = "www.jyskebank.dk"
            ),
            brand = "Visa/Dankort",
            country = Country(
                alpha2 = "DK",
                currency = "DKK",
                emoji = "🇩🇰",
                latitude = 56,
                longitude = 10,
                name = "Denmark",
                numeric = "208"
            ),
            number = Number(
                length = 16,
                luhn = true
            ),
            prepaid = false,
            scheme = "visa",
            type = "debit"
        )
    )
}