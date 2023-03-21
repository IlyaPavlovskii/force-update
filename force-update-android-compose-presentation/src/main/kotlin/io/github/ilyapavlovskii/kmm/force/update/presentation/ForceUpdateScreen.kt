package io.github.ilyapavlovskii.kmm.force.update.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.ilyapavlovskii.kmm.force.update.presentation.medium.MediumUpdateDialogStyle
import io.github.ilyapavlovskii.kmm.force.update.usecase.GetForceUpdateEventFlowUseCase

@Composable
fun ForceUpdateScreen(
    getForceUpdateEventFlowUseCase: GetForceUpdateEventFlowUseCase,
    applicationUri: Uri,
    mediumUpdateDialogStyle: MediumUpdateDialogStyle = MediumUpdateDialogStyle.create(),
    onUpdateClick: (context: Context) -> Unit = { context ->
        context.startActivity(Intent(Intent.ACTION_VIEW, applicationUri))
    },
    onCancelListener: () -> Unit = {},
    onMediumUpdateClick: () -> Unit = {},
    onForceUpdateCLick: () -> Unit = {},
) {
    val viewModel: ForceUpdateViewModel = viewModel(
        factory = ForceUpdateViewModel.createFactory(getForceUpdateEventFlowUseCase)
    )
    val viewState = viewModel.viewState.collectAsState()
    val context = LocalContext.current
    ForceUpdateView(
        mediumUpdateDialogStyle = mediumUpdateDialogStyle,
        viewState = viewState.value,
        onCancelListener = onCancelListener,
        onMediumUpdateClick = {
            onMediumUpdateClick()
            onUpdateClick(context)
        },
        onForceUpdateCLick = {
            onForceUpdateCLick()
            onUpdateClick(context)
        },
    )
}
