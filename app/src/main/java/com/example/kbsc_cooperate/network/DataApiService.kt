package com.example.kbsc_cooperate.network

import com.example.kbsc_cooperate.data.ExploreModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DataApiService {
    @GET("photos")
    suspend fun getPhotos(): List<ExploreModel>
}

object RooftopApi {
    val retrofitService : DataApiService by lazy {
        retrofit.create(DataApiService::class.java)}
}