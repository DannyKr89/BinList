package com.dk.binlist.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bins")
data class CardEntity(
    @PrimaryKey(autoGenerate = false)
    val bin: String,
    val city: String?,
    val bankName: String?,
    val phone: String?,
    val url: String?,
    val brand: String?,
    val alpha2: String?,
    val currency: String?,
    val emoji: String?,
    val latitude: Float?,
    val longitude: Float?,
    val countryName: String?,
    val numeric: String?,
    val length: Int?,
    val luhn: Boolean?,
    val prepaid: Boolean?,
    val scheme: String?,
    val type: String?
)