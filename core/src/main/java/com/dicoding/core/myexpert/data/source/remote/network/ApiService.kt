package com.dicoding.core.myexpert.data.source.remote.network

import com.dicoding.core.myexpert.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET

interface ApiService {
    @GET("popular")
    suspend fun getList(): ListMovieResponse
}
