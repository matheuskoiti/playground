package com.studiomk.arch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class State<State: BaseState>(initialState: State) {

    private val _state = MutableLiveData(initialState)
    val state: LiveData<State> = _state

    fun setState(state: (State) -> State) {
        _state.value = state(_state.value!!)
    }
}