package com.example.bin.domain.entity

import com.example.bin.data.dto.ApiBankCard

data class BankCard(
    val number: CardNumber = CardNumber(),
    val country: Country = Country(),
    val bank: Bank = Bank(),
    val scheme: String = "",
    val prepaid: Boolean = false,
    val type: String = "",
    val brand: String = "",
)

fun ApiBankCard.toBankCard() = BankCard(
    number = number?.toCardNumber() ?: CardNumber(),
    country = country?.toCountry() ?: Country(),
    bank = bank?.toBank() ?: Bank(),
    scheme = scheme ?: "",
    prepaid = prepaid ?: false,
    type = type ?: "",
    brand = brand ?: "",
)
