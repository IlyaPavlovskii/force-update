package io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.impl

import io.github.ilyapavlovskii.kmm.change.theme.domain.repository.ThemeRepository
import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.GetSelectedThemeResult
import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.GetSelectedThemeUseCase

internal class DefaultGetSelectedThemeUseCase(
    private val repository: ThemeRepository,
) : GetSelectedThemeUseCase {
    override suspend fun execute(): GetSelectedThemeResult =
        GetSelectedThemeResult(repository.getTheme())
}
