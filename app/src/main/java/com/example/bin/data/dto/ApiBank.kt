package com.example.bin.data.dto

import com.squareup.moshi.Json

data class ApiBank(
    @Json(name = "phone")
    val phone: String?,
    @Json(name = "city")
    val city: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "url")
    val url: String?,
)