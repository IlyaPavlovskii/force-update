package io.github.ilyapavlovskii.kmm.change.theme.domain.repository

import io.github.ilyapavlovskii.kmm.change.theme.domain.model.Theme

interface ThemeRepository {
    suspend fun getTheme(): Theme
    suspend fun setTheme(theme: Theme)
}