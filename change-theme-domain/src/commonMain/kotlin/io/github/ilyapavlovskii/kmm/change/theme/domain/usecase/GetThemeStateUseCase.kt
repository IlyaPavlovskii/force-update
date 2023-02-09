package io.github.ilyapavlovskii.kmm.change.theme.domain.usecase

import io.github.ilyapavlovskii.kmm.change.theme.domain.model.Theme
import kotlinx.coroutines.flow.StateFlow

interface GetThemeStateUseCase {
    fun getTheme(): StateFlow<Theme>
}