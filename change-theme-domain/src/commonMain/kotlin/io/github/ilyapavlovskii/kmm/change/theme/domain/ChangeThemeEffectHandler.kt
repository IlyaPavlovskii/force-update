package io.github.ilyapavlovskii.kmm.change.theme.domain

import io.github.ilyapavlovskii.kmm.change.theme.domain.ChangeThemeRedux.Effect
import io.github.ilyapavlovskii.kmm.change.theme.domain.ChangeThemeRedux.Message
import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.GetSelectedThemeUseCase
import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.GetThemesUseCase
import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.SetThemeUseCase
import net.humans.kmm.mvi.CoroutineEffectHandler

internal class ChangeThemeEffectHandler(
    private val getThemesUseCase: GetThemesUseCase,
    private val getSelectedThemeUseCase: GetSelectedThemeUseCase,
    private val setThemeUseCase: SetThemeUseCase,
) : CoroutineEffectHandler<Effect, Message> {
    override suspend fun handle(eff: Effect): Message = when (eff) {
        Effect.Initialize -> Message.UpdateState(
            themes = getThemesUseCase.execute().themes,
            selectedTheme = getSelectedThemeUseCase.execute().selectedTheme,
        )

        is Effect.SetTheme -> setThemeUseCase.execute(theme = eff.theme).let { result ->
            Message.UpdateThemeState(theme = result.theme)
        }
    }
}