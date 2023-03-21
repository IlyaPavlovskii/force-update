package io.github.ilyapavlovskii.kmm.force.update.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.ilyapavlovskii.kmm.force.update.presentation.force.ForceUpdateStyle
import io.github.ilyapavlovskii.kmm.force.update.presentation.medium.MediumUpdateDialogStyle
import io.github.ilyapavlovskii.kmm.force.update.usecase.GetForceUpdateEventFlowUseCase

@Composable
fun AppUpdateScreen(
    getForceUpdateEventFlowUseCase: GetForceUpdateEventFlowUseCase,
    applicationUri: Uri,
    mediumUpdateDialogStyle: MediumUpdateDialogStyle = MediumUpdateDialogStyle.create(),
    forceUpdateStyle: ForceUpdateStyle = ForceUpdateStyle.create(),
    onUpdateClick: (context: Context) -> Unit = { context ->
        context.startActivity(Intent(Intent.ACTION_VIEW, applicationUri))
    },
    onCancelListener: () -> Unit = {},
    onMediumUpdateClick: () -> Unit = {},
    onForceUpdateCLick: () -> Unit = {},
) {
    val viewModel: AppUpdateViewModel = viewModel(
        factory = AppUpdateViewModel.createFactory(getForceUpdateEventFlowUseCase)
    )
    val viewState = viewModel.viewState.collectAsState()
    val context = LocalContext.current
    ForceUpdateView(
        mediumUpdateDialogStyle = mediumUpdateDialogStyle,
        forceUpdateStyle = forceUpdateStyle,
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
