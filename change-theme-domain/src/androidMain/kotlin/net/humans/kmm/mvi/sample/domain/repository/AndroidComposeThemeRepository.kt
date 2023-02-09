package net.humans.kmm.mvi.sample.domain.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import io.github.ilyapavlovskii.kmm.change.theme.domain.model.Theme
import io.github.ilyapavlovskii.kmm.change.theme.domain.repository.ThemeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import net.humans.kmm.mvi.sample.domain.module.AndroidComposableTheme

internal class AndroidComposeThemeRepository(
    private val sharedPreferences: SharedPreferences,
) : ThemeRepository {
    private val _themeState = MutableStateFlow(
        sharedPreferences.getString(THEME_STATE_KEY, AndroidComposableTheme.SYSTEM.name)
            ?.let { serializedName -> AndroidComposableTheme.valueOf(serializedName) }
            ?: DEFAULT_THEME
    )
    override val themeState: StateFlow<Theme> = _themeState

    constructor(context: Context) : this(
        context.getSharedPreferences(THEME_REPOSITORY_SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    )

    override suspend fun getTheme(): Theme = themeState.value

    override suspend fun setTheme(theme: Theme) {
        val androidComposableTheme: AndroidComposableTheme = theme as? AndroidComposableTheme ?: return
        sharedPreferences.edit {
            putString(THEME_STATE_KEY, androidComposableTheme.name)
        }
        _themeState.value = androidComposableTheme
    }

    companion object {
        private val DEFAULT_THEME: Theme = AndroidComposableTheme.SYSTEM
        private const val THEME_REPOSITORY_SHARED_PREFS_NAME = "theme_repository_shared_prefs"
        private const val THEME_STATE_KEY = "theme"
    }
}
