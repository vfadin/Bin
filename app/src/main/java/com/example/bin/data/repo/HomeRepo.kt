package com.example.bin.data.repo

import android.content.Context
import com.example.bin.data.datasource.BinListRemoteDataSource
import com.example.bin.domain.RequestResult
import com.example.bin.domain.entity.BankCard
import com.example.bin.domain.entity.historyDataStore
import com.example.bin.domain.entity.toBankCard
import com.example.bin.domain.repo.IHomeRepo
import kotlinx.coroutines.flow.collect

class HomeRepo(
    private val dataSource: BinListRemoteDataSource,
    private val context: Context,
) : IHomeRepo {
    override suspend fun getCardInfo(bin: String): RequestResult<BankCard> {
        context.historyDataStore.updateData {
            it.copy(list = it.list + bin)
        }
        return when (val response = dataSource.getCardInfo(bin)) {
            is RequestResult.Success -> {
                RequestResult.Success(response.result.toBankCard())
            }
            is RequestResult.Error -> RequestResult.Error(response.exception)
        }
    }
}
