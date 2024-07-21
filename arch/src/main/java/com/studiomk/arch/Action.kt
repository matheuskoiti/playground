package com.studiomk.arch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Action<Action: BaseAction> {

    private val _action = MutableLiveData<Action>()
    val action: LiveData<Action> = _action

    fun sendAction(action: () -> Action) {
        _action.value = action()
    }
}