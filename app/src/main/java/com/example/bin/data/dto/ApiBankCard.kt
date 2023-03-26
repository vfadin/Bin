package com.example.bin.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiBankCard(
    @Json(name = "number")
    val number: ApiCardNumber?,
    @Json(name = "country")
    val country: ApiCountry?,
    @Json(name = "bank")
    val bank: ApiBank?,
    @Json(name = "scheme")
    val scheme: String?,
    @Json(name = "prepaid")
    val prepaid: Boolean?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "brand")
    val brand: String?,
)