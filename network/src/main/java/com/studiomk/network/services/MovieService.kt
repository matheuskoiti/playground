package com.studiomk.network.services

import com.studiomk.network.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("/3/movie/popular")
    suspend fun getMovies(@Query("api_key") apiKey: String = "8627a998e7a7d1d6d973cf87b0a1f825"): Response<MovieResponse>
}