package io.github.ilyapavlovskii.kmm.change.theme.domain.usecase

import io.github.ilyapavlovskii.kmm.change.theme.domain.model.Theme

interface SetThemeUseCase {
    suspend fun execute(theme: Theme): SetThemeResult
}

data class SetThemeResult(
    val theme: Theme,
)