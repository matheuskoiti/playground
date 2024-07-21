package com.studiomk.dashboard.viewmodel

import androidx.lifecycle.viewModelScope
import com.studiomk.arch.BaseViewModel
import com.studiomk.dashboard.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class DashboardViewModel(
    private val repository: MovieRepository
) : BaseViewModel<DashboardState, DashboardAction>(
    DashboardState.DashBoardLoadingState
) {

    init {
        fetchList()
    }

    fun fetchList() {
        setState { DashboardState.DashBoardLoadingState }
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.fetchList().let { list ->
                    withContext(Dispatchers.Main){
                        setState {
                            DashboardState.DashBoardListState(list)
                        }
                    }
                }
            } catch (ex: Exception){
                withContext(Dispatchers.Main){
                    setState {
                        DashboardState.DashBoardErrorState(ex.message ?: "Generic error!")
                    }
                }
            }
        }
    }
}