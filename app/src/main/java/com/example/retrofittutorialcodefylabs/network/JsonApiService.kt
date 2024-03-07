package com.example.retrofittutorialcodefylabs.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

import retrofit2.Retrofit
import retrofit2.http.GET


// the base url is "https://jsonplaceholder.typicode.com"
private const val BASE_URL = "https://jsonplaceholder.typicode.com"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()
interface  JsonApiService {
    @GET("posts")
    suspend fun getJsonDataFromInternet(): List<JsonData>
}
object JsonApi{
    val retrofitService: JsonApiService by lazy{
        retrofit.create(JsonApiService::class.java)

    }
}