package io.github.ilyapavlovskii.kmm.change.theme.domain

import io.github.ilyapavlovskii.kmm.change.theme.domain.ChangeThemeRedux.Effect
import io.github.ilyapavlovskii.kmm.change.theme.domain.ChangeThemeRedux.Message
import io.github.ilyapavlovskii.kmm.change.theme.domain.ChangeThemeRedux.State
import net.humans.kmm.mvi.ComplexReducer
import net.humans.kmm.mvi.Return
import net.humans.kmm.mvi.pure
import net.humans.kmm.mvi.withEffect

internal class ChangeThemeReducer : ComplexReducer<State, Message, Effect> {
    override fun invoke(state: State, msg: Message): Return<State, Effect> = when (msg) {
        is Message.SetTheme -> state withEffect Effect.SetTheme(msg.theme)
        is Message.UpdateThemeState -> state.copy(
            selectedTheme = msg.theme,
        ).pure()

        is Message.UpdateState -> state.copy(
            themes = msg.themes,
            selectedTheme = msg.selectedTheme,
        ).pure()
    }
}