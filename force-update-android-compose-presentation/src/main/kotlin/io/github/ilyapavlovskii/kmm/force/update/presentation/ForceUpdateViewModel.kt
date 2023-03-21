package io.github.ilyapavlovskii.kmm.force.update.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.ilyapavlovskii.kmm.force.update.model.ForceUpdateType
import io.github.ilyapavlovskii.kmm.force.update.usecase.GetForceUpdateEventFlowUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

internal class ForceUpdateViewModel(
    private val getForceUpdateEventFlowUseCase: GetForceUpdateEventFlowUseCase,
) : ViewModel() {
    val viewState: StateFlow<ForceUpdateViewState> = getForceUpdateEventFlowUseCase.event
        .map(::ForceUpdateViewState)
        .stateIn(
            scope = CoroutineScope(Dispatchers.Default),
            started = SharingStarted.Lazily,
            initialValue = ForceUpdateViewState(event = ForceUpdateType.ABSENT),
        )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun createFactory(
            getForceUpdateEventFlowUseCase: GetForceUpdateEventFlowUseCase
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return if (modelClass == ForceUpdateViewModel::class.java) {
                    ForceUpdateViewModel(
                        getForceUpdateEventFlowUseCase = getForceUpdateEventFlowUseCase,
                    ) as T
                } else {
                    super.create(modelClass)
                }
            }
        }
    }
}