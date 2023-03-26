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
) {
    override fun toString(): String {
        return buildString {
            append("Платежная система: ${scheme}\n")
            append("Бренд: ${brand}\n")
            append("Длина номера карты: ${number.length}\t")
            append("LUNH: ")
            if (number.luhn) append("Да\n") else append("Нет\n")
            append("Prepaid: ")
            if (prepaid) append("Да\n") else append("Нет\n")
            append("Тип: $type")
        }
    }
}

fun ApiBankCard.toBankCard() = BankCard(
    number = number?.toCardNumber() ?: CardNumber(),
    country = country?.toCountry() ?: Country(),
    bank = bank?.toBank() ?: Bank(),
    scheme = scheme ?: "",
    prepaid = prepaid ?: false,
    type = type ?: "",
    brand = brand ?: "",
)
