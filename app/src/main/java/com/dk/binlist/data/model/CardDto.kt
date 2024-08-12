package com.dk.binlist.data.model

import androidx.compose.runtime.Immutable

@Immutable
data class CardDto(
    val bank: BankDto?,
    val brand: String?,
    val country: CountryDto?,
    val number: NumberDto?,
    val prepaid: Boolean?,
    val scheme: String?,
    val type: String?
)