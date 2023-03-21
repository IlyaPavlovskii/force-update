package io.github.ilyapavlovskii.kmm.force.update.usecase.impl

import io.github.ilyapavlovskii.kmm.force.update.model.ForceUpdateType
import io.github.ilyapavlovskii.kmm.force.update.usecase.GetForceUpdateEventFlowUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SimpleGetForceUpdateEventFlowUseCase : GetForceUpdateEventFlowUseCase {
    private val _event = MutableStateFlow<ForceUpdateType>(ForceUpdateType.ABSENT)
    override val event: StateFlow<ForceUpdateType> = _event

    fun update(event: ForceUpdateType) {
        println("ForceUpdateScreen. set: $event")
        this._event.value = event
    }
}