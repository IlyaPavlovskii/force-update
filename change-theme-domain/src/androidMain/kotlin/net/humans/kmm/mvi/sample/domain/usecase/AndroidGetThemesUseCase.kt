package net.humans.kmm.mvi.sample.domain.usecase

import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.GetDefaultThemeResult
import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.GetThemesUseCase
import net.humans.kmm.mvi.sample.domain.module.AndroidTheme

internal class AndroidGetThemesUseCase : GetThemesUseCase {
    override suspend fun execute(): GetDefaultThemeResult = GetDefaultThemeResult(
        themes = linkedSetOf(
            AndroidTheme.SYSTEM,
            AndroidTheme.LIGHT,
            AndroidTheme.DARK,
        ),
    )
}