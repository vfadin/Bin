package com.example.bin.domain.repo

import com.example.bin.domain.RequestResult
import com.example.bin.domain.entity.BankCard

interface IHomeRepo {
    suspend fun getCardInfo(bin: String): RequestResult<BankCard>
}