package com.dk.binlist.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class Bank(
    val city: String?,
    val name: String?,
    val phone: String?,
    val url: String?
)