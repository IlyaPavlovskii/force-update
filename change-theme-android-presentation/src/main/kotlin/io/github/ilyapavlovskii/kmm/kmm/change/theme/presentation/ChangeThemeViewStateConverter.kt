package io.github.ilyapavlovskii.kmm.kmm.change.theme.presentation

import io.github.ilyapavlovskii.kmm.change.theme.domain.ChangeThemeRedux
import io.github.ilyapavlovskii.kmm.change.theme.presentation.R
import net.humans.kmm.mvi.ViewStateConverter
import net.humans.kmm.mvi.sample.domain.module.AndroidTheme

internal class ChangeThemeViewStateConverter :
    ViewStateConverter<ChangeThemeRedux.State, ChangeThemeViewState> {
    override fun convert(state: ChangeThemeRedux.State): ChangeThemeViewState {
        return ChangeThemeViewState(
            items = (state.selectedTheme as? AndroidTheme)?.let { selectedAndroidTheme ->
                state.themes.filterIsInstance<AndroidTheme>()
                    .map { androidTheme ->
                        androidTheme.toPresentationItem(selectedAndroidTheme)
                    }
            }.orEmpty()
        )
    }

    private fun AndroidTheme.toPresentationItem(
        selectedTheme: AndroidTheme
    ): ChangeThemeViewState.Item = ChangeThemeViewState.Item(
        titleRes = when (this) {
            AndroidTheme.SYSTEM -> R.string.change_theme__system_theme
            AndroidTheme.LIGHT -> R.string.change_theme__light_theme
            AndroidTheme.DARK -> R.string.change_theme__dark_theme
        },
        selected = this == selectedTheme,
        domainMeta = ChangeThemeViewState.Item.DomainMeta(theme = this)
    )
}

