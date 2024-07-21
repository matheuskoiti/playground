package com.studiomk.home.viewmodel

import com.studiomk.arch.BaseViewModel

class HomeViewModel : BaseViewModel<HomeState, HomeAction>(
    HomeState.HomeInitialState("Welcome to playground app!!\n\n" +
            "This Android app is a simple project designed for educational purposes. \n" +
            "It demonstrates fundamental concepts of Android development, including user interface design, \n" +
            "data handling, and basic functionality.")
)