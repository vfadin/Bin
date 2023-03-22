package com.example.bin.data.datasource

import com.example.bin.data.dto.ApiBankCard
import retrofit2.http.GET
import retrofit2.http.Path

interface IBinListService {
    @GET("/{bin}")
    suspend fun getCardInfo(
        @Path("bin") bin: String,
    ): ApiBankCard
}
