package com.studiomk.dashboard.viewmodel

import com.studiomk.arch.BaseState
import com.studiomk.network.model.MovieData

sealed class DashboardState: BaseState {
    data object DashBoardLoadingState: DashboardState()
    data class DashBoardListState(val list: List<MovieData>): DashboardState()
    data class DashBoardErrorState(val errorMessage: String): DashboardState()
}
