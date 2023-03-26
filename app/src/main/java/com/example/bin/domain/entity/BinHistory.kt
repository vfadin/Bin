package com.example.bin.domain.entity

import android.content.Context
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

val Context.historyDataStore by dataStore("history.json", BinHistorySerializer)

@kotlinx.serialization.Serializable
data class BinHistory(
    val list: List<String> = emptyList()
)

object BinHistorySerializer : Serializer<BinHistory> {

    override val defaultValue: BinHistory
        get() = BinHistory()

    override suspend fun readFrom(input: InputStream): BinHistory {
        return try {
            Json.decodeFromString(
                deserializer = BinHistory.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: SerializationException) {
            e.printStackTrace()
            defaultValue
        }
    }

    override suspend fun writeTo(t: BinHistory, output: OutputStream) {
        withContext(Dispatchers.IO) {
            output.write(
                Json.encodeToString(
                    serializer = BinHistory.serializer(),
                    value = t
                ).encodeToByteArray()
            )
        }
    }
}