package com.studiomk.home.viewmodel

import com.studiomk.arch.BaseState

sealed class HomeState: BaseState {
    data class HomeInitialState(val welcomeText: String = ""): HomeState()
}