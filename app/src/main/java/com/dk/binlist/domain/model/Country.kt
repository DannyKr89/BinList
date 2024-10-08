package com.dk.binlist.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class Country(
    val alpha2: String?,
    val currency: String?,
    val emoji: String?,
    val latitude: Float?,
    val longitude: Float?,
    val name: String?,
    val numeric: String?
)