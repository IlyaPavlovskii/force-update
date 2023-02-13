package io.github.ilyapavlovskii.kmm.change.theme.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

@Composable
internal fun ChangeThemeView(
    viewState: ChangeThemeViewState,
    onBackClick: () -> Unit,
    onItemSelected: (ChangeThemeViewState.Item) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        IconButton(
            modifier = Modifier
                .padding(top = 16.dp)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = rememberRipple(
                        color = MaterialTheme.colorScheme.primary,
                    ),
                    onClick = { },
                ),
            onClick = onBackClick
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_24),
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = stringResource(id = R.string.change_theme__back_content_description),
            )
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
            text = stringResource(id = R.string.change_theme__title),
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onBackground,
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
        ) {
            items(viewState.items) { item ->
                ChangeThemeSelectorRow(item = item, onItemSelected = onItemSelected)
            }
        }
    }
}

@Composable
internal fun ChangeThemeSelectorRow(
    item: ChangeThemeViewState.Item,
    onItemSelected: (ChangeThemeViewState.Item) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .selectable(
                selected = item.selected,
                onClick = { onItemSelected(item) }
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        RadioButton(
            selected = item.selected,
            onClick = { onItemSelected(item) }
        )
        Text(
            text = stringResource(id = item.titleRes),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

// @Preview
// @Composable
// internal fun PreviewChangeThemeView() {
//     ChangeThemeTheme {
//         ChangeThemeView(
//             viewState = ChangeThemeViewState(
//                 items = listOf(
//                     ChangeThemeViewState.Item(
//                         titleRes = R.string.change_theme__system_theme,
//                         selected = false,
//                         domainMeta = ChangeThemeViewState.Item.DomainMeta(EmptyTheme),
//                     ),
//                     ChangeThemeViewState.Item(
//                         titleRes = R.string.change_theme__light_theme,
//                         selected = true,
//                         domainMeta = ChangeThemeViewState.Item.DomainMeta(EmptyTheme),
//                     ),
//                     ChangeThemeViewState.Item(
//                         titleRes = R.string.change_theme__dark_theme,
//                         selected = false,
//                         domainMeta = ChangeThemeViewState.Item.DomainMeta(EmptyTheme),
//                     ),
//                 )
//             ),
//             onBackClick = {},
//             onItemSelected = {},
//         )
//     }
// }
