package com.example.bin.data.repo

import com.example.bin.data.datasource.BinListRemoteDataSource
import com.example.bin.data.dto.ApiBankCard
import com.example.bin.domain.RequestResult
import com.example.bin.domain.entity.BankCard
import com.example.bin.domain.entity.toBankCard
import com.example.bin.domain.repo.IHomeRepo

class HomeRepo(
    private val dataSource: BinListRemoteDataSource
) : IHomeRepo {
    override suspend fun getCardInfo(bin: String): RequestResult<BankCard> {
        return when(val response = dataSource.getCardInfo(bin)) {
            is RequestResult.Success -> {
                RequestResult.Success(response.result.toBankCard())
            }
            is RequestResult.Error -> RequestResult.Error(response.exception)
        }
    }
}
