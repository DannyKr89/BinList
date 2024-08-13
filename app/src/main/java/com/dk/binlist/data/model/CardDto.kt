package com.dk.binlist.data.model

data class CardDto(
    val bank: BankDto?,
    val brand: String?,
    val country: CountryDto?,
    val number: NumberDto?,
    val prepaid: Boolean?,
    val scheme: String?,
    val type: String?
)