package io.github.ilyapavlovskii.kmm.change.theme.domain.repository

import io.github.ilyapavlovskii.kmm.change.theme.domain.model.Theme
import kotlinx.coroutines.flow.StateFlow

interface ThemeRepository {
    val themeState: StateFlow<Theme>
    suspend fun getTheme(): Theme
    suspend fun setTheme(theme: Theme)
}