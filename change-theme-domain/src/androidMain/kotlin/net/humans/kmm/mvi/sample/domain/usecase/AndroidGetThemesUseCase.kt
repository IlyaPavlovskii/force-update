package net.humans.kmm.mvi.sample.domain.usecase

import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.GetDefaultThemeResult
import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.GetThemesUseCase
import net.humans.kmm.mvi.sample.domain.module.AndroidComposableTheme

internal class AndroidGetThemesUseCase : GetThemesUseCase {
    override suspend fun execute(): GetDefaultThemeResult = GetDefaultThemeResult(
        themes = linkedSetOf(
            AndroidComposableTheme.SYSTEM,
            AndroidComposableTheme.LIGHT,
            AndroidComposableTheme.DARK,
        ),
    )
}