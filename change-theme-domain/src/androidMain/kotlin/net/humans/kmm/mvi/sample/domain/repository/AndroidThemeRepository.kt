package net.humans.kmm.mvi.sample.domain.repository

import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import io.github.ilyapavlovskii.kmm.change.theme.domain.model.Theme
import io.github.ilyapavlovskii.kmm.change.theme.domain.repository.ThemeRepository
import net.humans.kmm.mvi.sample.domain.module.AndroidTheme

internal class AndroidThemeRepository : ThemeRepository {

    override suspend fun getTheme(): Theme = when (AppCompatDelegate.getDefaultNightMode()) {
        MODE_NIGHT_NO -> AndroidTheme.LIGHT
        MODE_NIGHT_YES -> AndroidTheme.DARK
        else -> AndroidTheme.SYSTEM
    }

    override suspend fun setTheme(theme: Theme) {
        (theme as? AndroidTheme)?.let { androidTheme ->
            when (androidTheme) {
                AndroidTheme.SYSTEM -> MODE_NIGHT_FOLLOW_SYSTEM
                AndroidTheme.LIGHT -> MODE_NIGHT_NO
                AndroidTheme.DARK -> MODE_NIGHT_YES
            }
        }?.also(AppCompatDelegate::setDefaultNightMode)
    }
}