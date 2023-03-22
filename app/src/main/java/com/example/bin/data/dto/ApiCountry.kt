package com.example.bin.data.dto

import com.squareup.moshi.Json

data class ApiCountry(
    @Json(name = "emoji")
    val emoji: String?,
    @Json(name = "latitude")
    val latitude: Int?,
    @Json(name = "alpha2")
    val alpha: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "numeric")
    val numeric: String?,
    @Json(name = "currency")
    val currency: String?,
    @Json(name = "longitude")
    val longitude: Int?,
)