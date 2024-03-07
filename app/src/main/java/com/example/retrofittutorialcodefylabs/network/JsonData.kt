package com.example.retrofittutorialcodefylabs.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

    @Serializable

    @SerialName("json_data")
    data class JsonData(
        val body: String,
        val id: Int,
        val title: String,
        val userId: Int
    )
