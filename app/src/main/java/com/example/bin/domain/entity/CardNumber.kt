package com.example.bin.domain.entity

import com.example.bin.data.dto.ApiCardNumber

data class CardNumber(
    val length: Int = -1,
    val luhn: Boolean = false,
)

fun ApiCardNumber.toCardNumber() = CardNumber(
    length = length ?: -1,
    luhn = luhn ?: false
)