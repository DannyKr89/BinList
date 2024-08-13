package com.dk.binlist.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class Card(
    val bin: String? = null,
    val bank: Bank?,
    val brand: String?,
    val country: Country?,
    val number: Number?,
    val prepaid: Boolean?,
    val scheme: String?,
    val type: String?
)