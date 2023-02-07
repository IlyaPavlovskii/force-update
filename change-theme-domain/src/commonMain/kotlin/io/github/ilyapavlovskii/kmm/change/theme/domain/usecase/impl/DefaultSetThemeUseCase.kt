package io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.impl

import io.github.ilyapavlovskii.kmm.change.theme.domain.model.Theme
import io.github.ilyapavlovskii.kmm.change.theme.domain.repository.ThemeRepository
import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.SetThemeResult
import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.SetThemeUseCase

internal class DefaultSetThemeUseCase(
    private val repository: ThemeRepository,
) : SetThemeUseCase {
    override suspend fun execute(theme: Theme): SetThemeResult {
        repository.setTheme(theme)
        return SetThemeResult(theme)
    }
}