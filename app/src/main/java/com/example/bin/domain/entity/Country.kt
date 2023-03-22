package com.example.bin.domain.entity

import com.example.bin.data.dto.ApiCountry

data class Country(
    val emoji: String = "",
    val latitude: Int = -1,
    val alpha: String = "",
    val name: String = "",
    val numeric: String = "",
    val currency: String = "",
    val longitude: Int = -1,
)

fun ApiCountry.toCountry() = Country(
    emoji = emoji ?: "",
    latitude = latitude ?: -1,
    alpha = alpha ?: "",
    name = name ?: "",
    numeric = numeric ?: "",
    currency = currency ?: "",
    longitude = longitude ?: -1
)