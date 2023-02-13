package io.github.ilyapavlovskii.kmm.change.theme.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.androidx.compose.getViewModel

@Composable
fun ChangeThemeScreen(
    onBackClick: () -> Unit,
) {

    val viewModel: ChangeThemeViewModel = getViewModel()
    val viewState = viewModel.viewState.collectAsState()

    ChangeThemeView(
        viewState = viewState.value,
        onBackClick = onBackClick,
        onItemSelected = viewModel::itemSelected,
    )
}
