package com.studiomk.dashboard.di

import com.studiomk.dashboard.repository.MovieRepository
import com.studiomk.dashboard.viewmodel.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dashboardModule = module {
    factory { MovieRepository(get()) }
    viewModel { DashboardViewModel(get()) }
}