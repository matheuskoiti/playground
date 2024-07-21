package com.studiomk.dashboard.repository

import com.studiomk.network.model.MovieData
import com.studiomk.network.services.MovieService
import java.lang.Exception

class MovieRepository(private val movieService: MovieService) {

    suspend fun fetchList(): List<MovieData> {
        val resp = movieService.getMovies()
        if (resp.isSuccessful) {
            resp.body().let {
                val movieList = it?.results
                if (movieList != null) {
                    return movieList
                } else {
                    throw Exception("List is empty")
                }
            }
        } else {
            throw Exception("${resp.errorBody()?.string()}")
        }
    }
}