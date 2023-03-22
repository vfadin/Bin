package com.example.bin.data.dto

import com.squareup.moshi.Json

data class ApiCardNumber(
    @Json(name = "length")
    val length: Int?,
    @Json(name = "luhn")
    val luhn: Boolean?,
)