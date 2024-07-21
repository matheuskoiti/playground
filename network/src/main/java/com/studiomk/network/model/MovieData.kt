package com.studiomk.network.model

import com.google.gson.annotations.SerializedName

data class MovieData(
    val id: Int,
    val overview: String,
    val popularity: Double,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
)
