package com.studiomk.arch

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<State: BaseState, Action: BaseAction>(
    initialState: State
): ViewModel() {

    private val viewModelState = State(initialState)
    private val viewModelAction = Action<Action>()

    val state: LiveData<State> = viewModelState.state
    val action: LiveData<Action> = viewModelAction.action

    fun setState(state: (State) -> State) {
        viewModelState.setState(state)
    }

    fun sendAction(action: () -> Action) {
        viewModelAction.sendAction(action)
    }
}