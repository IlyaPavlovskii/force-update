package io.github.ilyapavlovskii.kmm.change.theme.presentation

import androidx.annotation.StringRes
import io.github.ilyapavlovskii.kmm.change.theme.domain.model.Theme

internal data class ChangeThemeViewState(
    val items: List<Item> = emptyList(),
) {
    data class Item(
        @StringRes val titleRes: Int,
        val selected: Boolean,
        val domainMeta: DomainMeta,
    ) {
        data class DomainMeta(
            val theme: Theme
        )
    }
}
