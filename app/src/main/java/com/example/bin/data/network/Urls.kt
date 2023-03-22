package com.example.bin.data.network

sealed class Urls {
    class RELEASE : Urls() {
        val BASE_URL = "https://lookup.binlist.net"
    }
}