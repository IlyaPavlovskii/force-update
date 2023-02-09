package io.github.ilyapavlovskii.kmm.change.theme.domain.usecase

import io.github.ilyapavlovskii.kmm.change.theme.domain.model.Theme

interface GetThemesUseCase {
    suspend fun execute(): GetDefaultThemeResult
}

data class GetDefaultThemeResult(
    val themes: Set<Theme>,
)
