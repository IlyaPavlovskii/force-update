package io.github.ilyapavlovskii.kmm.change.theme.presentation

import androidx.lifecycle.ViewModel
import io.github.ilyapavlovskii.kmm.change.theme.domain.ChangeThemeRedux
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import net.humans.kmm.mvi.ComplexReducer
import net.humans.kmm.mvi.CoroutineEffectHandler
import net.humans.kmm.mvi.LaunchReduxEngine
import net.humans.kmm.mvi.ViewStateConverter
import net.humans.kmm.mvi.consume
import net.humans.kmm.mvi.withEffect

internal class ChangeThemeViewModel(
    reducer: ComplexReducer<ChangeThemeRedux.State, ChangeThemeRedux.Message, ChangeThemeRedux.Effect>,
    effectHandler: CoroutineEffectHandler<ChangeThemeRedux.Effect, ChangeThemeRedux.Message>,
    viewStateConverter: ViewStateConverter<ChangeThemeRedux.State, ChangeThemeViewState>,
) : ViewModel() {
    private val _viewState = MutableStateFlow(ChangeThemeViewState())
    val viewState: StateFlow<ChangeThemeViewState> = _viewState

    private val engine = LaunchReduxEngine(
        tag = TAG,
        initial = ChangeThemeRedux.State() withEffect ChangeThemeRedux.Effect.Initialize,
        reducer = reducer,
        effectHandler = effectHandler,
    ).also { consume(it, _viewState, viewStateConverter) }

    fun itemSelected(item: ChangeThemeViewState.Item) =
        engine.send(ChangeThemeRedux.Message.SetTheme(item.domainMeta.theme))

    companion object {
        private const val TAG = "ChangeThemeViewModel"
    }
}
