package com.example.bin.domain

import com.example.bin.data.network.NetworkErrors

sealed class RequestResult<out R> {

    data class Success<out T>(val result: T) : RequestResult<T>()
    data class Error<out T>(val exception: NetworkErrors, val data: String? = null) : RequestResult<T>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$result]"
            is Error -> "Error[exception=$exception]"
        }
    }
}