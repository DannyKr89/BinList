package com.dk.binlist.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dk.binlist.R
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
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SimpleItemText(
                    name = stringResource(R.string.scheme_network),
                    value = card.scheme.toString()
                )
                SimpleItemText(name = stringResource(R.string.type), value = card.type.toString())
                card.bank?.let { BankItemText(bank = it) }
            }
            Row(
                modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                card.number?.let { NumberItemText(number = it) }
                card.country?.let { CountryItemText(country = it) }
            }
            Row(modifier = modifier.fillMaxWidth()) {
                SimpleItemText(name = stringResource(R.string.brand), value = card.brand.toString())
                SimpleItemText(
                    name = stringResource(R.string.prepaid),
                    value = if (card.prepaid != null) {
                        if (card.prepaid) {
                            stringResource(R.string.yes)
                        } else {
                            stringResource(R.string.no)
                        }

                    } else stringResource(R.string._null)
                )
            }
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
                latitude = 56f,
                longitude = 10f,
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