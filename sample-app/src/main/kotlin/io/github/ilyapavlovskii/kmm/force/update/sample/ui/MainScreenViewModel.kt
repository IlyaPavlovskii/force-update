package io.github.ilyapavlovskii.kmm.force.update.sample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.ilyapavlovskii.kmm.force.update.model.ForceUpdateType
import io.github.ilyapavlovskii.kmm.force.update.usecase.impl.SimpleGetForceUpdateEventFlowUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

internal class MainScreenViewModel(
    private val useCase: SimpleGetForceUpdateEventFlowUseCase,
) : ViewModel() {
    val viewState: StateFlow<MainScreenViewState> = useCase.event.map { type ->
        val mode = when (type) {
            ForceUpdateType.ABSENT -> "NO_UPDATE"
            ForceUpdateType.MEDIUM -> "MEDIUM"
            ForceUpdateType.FORCE -> "FORCE"
        }
        MainScreenViewState(selectedMode = mode)
    }.stateIn(
        scope = CoroutineScope(Dispatchers.Default),
        started = SharingStarted.Lazily,
        initialValue = MainScreenViewState(selectedMode = "NO_UPDATE")
    )

    fun selectNoUpdate() = useCase.update(ForceUpdateType.ABSENT)
    fun selectMedium() = useCase.update(ForceUpdateType.MEDIUM)
    fun selectForce() = useCase.update(ForceUpdateType.FORCE)

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun createFactory(
            useCase: SimpleGetForceUpdateEventFlowUseCase,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T =
                MainScreenViewModel(useCase) as T
        }
    }
}