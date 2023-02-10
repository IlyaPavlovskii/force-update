package io.github.ilyapavlovskii.kmm.change.theme.presentation

import io.github.ilyapavlovskii.kmm.change.theme.domain.ChangeThemeRedux
import net.humans.kmm.mvi.ViewStateConverter
import net.humans.kmm.mvi.sample.domain.module.AndroidComposableTheme

internal class ChangeThemeViewStateConverter :
    ViewStateConverter<ChangeThemeRedux.State, ChangeThemeViewState> {
    override fun convert(state: ChangeThemeRedux.State): ChangeThemeViewState {
        return ChangeThemeViewState(
            items = (state.selectedTheme as? AndroidComposableTheme)?.let { selectedAndroidTheme ->
                state.themes.filterIsInstance<AndroidComposableTheme>()
                    .map { androidTheme ->
                        androidTheme.toPresentationItem(selectedAndroidTheme)
                    }
            }.orEmpty(),
        )
    }

    private fun AndroidComposableTheme.toPresentationItem(
        selectedTheme: AndroidComposableTheme
    ): ChangeThemeViewState.Item = ChangeThemeViewState.Item(
        titleRes = when (this) {
            AndroidComposableTheme.SYSTEM -> R.string.change_theme__system_theme
            AndroidComposableTheme.LIGHT -> R.string.change_theme__light_theme
            AndroidComposableTheme.DARK -> R.string.change_theme__dark_theme
        },
        selected = this == selectedTheme,
        domainMeta = ChangeThemeViewState.Item.DomainMeta(theme = this)
    )
}
