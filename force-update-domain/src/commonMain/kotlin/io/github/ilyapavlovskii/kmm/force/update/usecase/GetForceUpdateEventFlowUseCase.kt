package io.github.ilyapavlovskii.kmm.force.update.usecase

import io.github.ilyapavlovskii.kmm.force.update.model.ForceUpdateType
import kotlinx.coroutines.flow.StateFlow

interface GetForceUpdateEventFlowUseCase {
    val event: StateFlow<ForceUpdateType>
}
