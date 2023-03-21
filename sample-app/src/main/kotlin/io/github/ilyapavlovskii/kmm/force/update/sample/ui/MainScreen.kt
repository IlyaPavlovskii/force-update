package io.github.ilyapavlovskii.kmm.force.update.sample.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.ilyapavlovskii.kmm.force.update.usecase.GetForceUpdateEventFlowUseCase
import io.github.ilyapavlovskii.kmm.force.update.usecase.impl.SimpleGetForceUpdateEventFlowUseCase

@Composable
internal fun MainScreen(
    useCase: GetForceUpdateEventFlowUseCase,
) {
    val viewModel: MainScreenViewModel = viewModel(
        factory = MainScreenViewModel.createFactory(useCase as SimpleGetForceUpdateEventFlowUseCase)
    )
    val viewState = viewModel.viewState.collectAsState()
    MainScreenView(
        viewState = viewState.value,
        onDropUpdateClicked = viewModel::selectNoUpdate,
        onMediumUpdateClicked = viewModel::selectMedium,
        onForceUpdateClicked = viewModel::selectForce,
    )
}