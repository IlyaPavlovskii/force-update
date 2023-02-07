package io.github.ilyapavlovskii.kmm.change.theme.domain.usecase

import io.github.ilyapavlovskii.kmm.change.theme.domain.model.Theme

interface GetSelectedThemeUseCase {
    suspend fun execute(): GetSelectedThemeResult
}

data class GetSelectedThemeResult(
    val selectedTheme: Theme,
)