package com.example.bin.domain.entity

import com.example.bin.data.dto.ApiBank

data class Bank(
    val phone: String = "",
    val city: String = "",
    val name: String = "",
    val url: String = "",
)

fun ApiBank.toBank() = Bank(
    phone = phone ?: "",
    city = city ?: "",
    name = name ?: "",
    url = url ?: "",
)
