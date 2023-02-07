package io.github.ilyapavlovskii.kmm.change.theme.domain

import io.github.ilyapavlovskii.kmm.change.theme.domain.model.EmptyTheme
import io.github.ilyapavlovskii.kmm.change.theme.domain.model.Theme

object ChangeThemeRedux {
    data class State(
        val themes: Set<Theme> = emptySet(),
        val selectedTheme: Theme = EmptyTheme,
    )

    sealed class Message {
        data class UpdateState(
            val themes: Set<Theme>,
            val selectedTheme: Theme,
        ) : Message()

        data class UpdateThemeState(
            val theme: Theme,
        ) : Message()

        data class SetTheme(
            val theme: Theme,
        ) : Message()
    }

    sealed class Effect {
        object Initialize : Effect()
        data class SetTheme(
            val theme: Theme,
        ) : Effect()
    }
}