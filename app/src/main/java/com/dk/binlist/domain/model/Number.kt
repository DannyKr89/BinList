package com.dk.binlist.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class Number(
    val length: Int?,
    val luhn: Boolean?
)