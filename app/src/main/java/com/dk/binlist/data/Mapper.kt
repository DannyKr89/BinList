package com.dk.binlist.data

import com.dk.binlist.data.model.BankDto
import com.dk.binlist.data.model.CardDto
import com.dk.binlist.data.model.CountryDto
import com.dk.binlist.data.model.NumberDto
import com.dk.binlist.data.room.entity.CardEntity
import com.dk.binlist.domain.model.Bank
import com.dk.binlist.domain.model.Card
import com.dk.binlist.domain.model.Country
import com.dk.binlist.domain.model.Number

fun CardDto.toCard(): Card {
    return Card(
        bank = bank?.toBank(),
        brand = brand,
        country = country?.toCountry(),
        number = number?.toNumber(),
        prepaid = prepaid,
        scheme = scheme,
        type = type
    )
}

fun BankDto.toBank(): Bank {
    return Bank(
        city = city,
        name = name,
        phone = phone,
        url = url
    )
}

fun CountryDto.toCountry(): Country {
    return Country(
        alpha2 = alpha2,
        currency = currency,
        emoji = emoji,
        latitude = latitude,
        longitude = longitude,
        name = name,
        numeric = numeric
    )
}

fun NumberDto.toNumber(): Number {
    return Number(
        length = length ?: 0,
        luhn = luhn
    )
}

fun CardEntity.toCard(): Card {
    return Card(
        bin = bin,
        bank = Bank(
            city = city,
            name = bankName,
            phone = phone,
            url = url
        ),
        brand = brand,
        country = Country(
            alpha2 = alpha2,
            currency = currency,
            emoji = emoji,
            latitude = latitude,
            longitude = longitude,
            name = countryName,
            numeric = numeric
        ),
        number = Number(
            length = length,
            luhn = luhn
        ),
        prepaid = prepaid,
        scheme = scheme,
        type = type
    )
}

fun Card.toEntity(): CardEntity {
    return CardEntity(
        bin = bin ?: "error",
        city = bank?.city,
        bankName = bank?.name,
        phone = bank?.phone,
        url = bank?.url,
        brand = brand,
        alpha2 = country?.alpha2,
        currency = country?.currency,
        emoji = country?.emoji,
        latitude = country?.latitude,
        longitude = country?.longitude,
        countryName = country?.name,
        numeric = country?.numeric,
        length = number?.length,
        luhn = number?.luhn,
        prepaid = prepaid,
        scheme = scheme,
        type = type
    )

}