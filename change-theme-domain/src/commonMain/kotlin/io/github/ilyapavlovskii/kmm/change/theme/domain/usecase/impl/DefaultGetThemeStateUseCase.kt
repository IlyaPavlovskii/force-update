package io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.impl

import io.github.ilyapavlovskii.kmm.change.theme.domain.model.Theme
import io.github.ilyapavlovskii.kmm.change.theme.domain.repository.ThemeRepository
import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.GetThemeStateUseCase
import kotlinx.coroutines.flow.StateFlow

internal class DefaultGetThemeStateUseCase(
    private val repository: ThemeRepository,
) : GetThemeStateUseCase {
    override fun getTheme(): StateFlow<Theme> = repository.themeState
}
