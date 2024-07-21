package com.studiomk.network.di

import com.studiomk.network.RetrofitInstance
import com.studiomk.network.services.MovieService
import org.koin.dsl.module

val networkModule = module {
    factory<MovieService> { RetrofitInstance.getInstance().create(MovieService::class.java) }
}