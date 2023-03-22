package com.example.bin.data.datasource

import com.example.bin.data.network.safeApiCall
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BinListRemoteDataSource @Inject constructor(
    private val api: IBinListService
) {
    suspend fun getCardInfo(bin: String) = safeApiCall {
        api.getCardInfo(bin)
    }
}