package net.humans.kmm.mvi.sample.domain.utils

import android.content.ComponentCallbacks
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.GetThemeStateUseCase
import net.humans.kmm.mvi.sample.domain.module.AndroidComposableTheme
import org.koin.android.ext.android.get

@Composable
fun AndroidComposableTheme.isDarkTheme(): Boolean = when (this) {
    AndroidComposableTheme.SYSTEM -> isSystemInDarkTheme()
    AndroidComposableTheme.LIGHT -> false
    AndroidComposableTheme.DARK -> true
}

@Composable
fun ComponentCallbacks.isDarkTheme(): Boolean {
    val getThemeStateUseCase: GetThemeStateUseCase = get()
    return (getThemeStateUseCase.getTheme().collectAsState()
        .value
        .let { it as? AndroidComposableTheme }
        ?: AndroidComposableTheme.SYSTEM
        ).isDarkTheme()
}