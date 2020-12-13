package com.example.desafiowebservices.network

import com.example.desafiowebservices.entities.ApiReturn
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApiService {
    @GET("v1/public/series/{seriesId}/comics?apikey=f85b31c8d52fbec8f47891c5db4335c8&hash=066fb31fd4362fb7bbec5dda05682a04&ts=1")
    suspend fun getComics(
        @Path("seriesId") seriesId: Int,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("noVariants") noVariants: Boolean
    ): ApiReturn
}

val contentType = "application/json".toMediaType()
val retrofit = Retrofit.Builder()
        .addConverterFactory(Json{ignoreUnknownKeys = true}.asConverterFactory(contentType))
        .baseUrl("https://gateway.marvel.com/")
        .build()

object MarvelApi{
    val retrofitService: MarvelApiService by lazy {
        retrofit.create(MarvelApiService::class.java)
    }
}