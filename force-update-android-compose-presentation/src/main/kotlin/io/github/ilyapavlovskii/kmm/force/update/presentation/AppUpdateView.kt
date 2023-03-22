package io.github.ilyapavlovskii.kmm.force.update.presentation

import androidx.compose.runtime.Composable
import io.github.ilyapavlovskii.kmm.force.update.model.ForceUpdateType
import io.github.ilyapavlovskii.kmm.force.update.presentation.force.ForceUpdateStyle
import io.github.ilyapavlovskii.kmm.force.update.presentation.force.ForceUpdateView
import io.github.ilyapavlovskii.kmm.force.update.presentation.medium.MediumUpdateDialog
import io.github.ilyapavlovskii.kmm.force.update.presentation.medium.MediumUpdateDialogStyle

@Composable
internal fun ForceUpdateView(
    mediumUpdateDialogStyle: MediumUpdateDialogStyle,
    forceUpdateStyle: ForceUpdateStyle,
    viewState: AppUpdateViewState,
    onCancelListener: () -> Unit,
    onMediumUpdateClick: () -> Unit,
    onForceUpdateCLick: () -> Unit,
) {
    when (viewState.event) {
        ForceUpdateType.ABSENT -> {
            // Do nothing
        }

        ForceUpdateType.MEDIUM ->
            MediumUpdateDialog(
                style = mediumUpdateDialogStyle,
                onCancelListener = onCancelListener,
                onMediumUpdateClick = onMediumUpdateClick,
            )

        ForceUpdateType.FORCE ->
            ForceUpdateView(
                style = forceUpdateStyle,
                onForceUpdateCLick = onForceUpdateCLick,
            )
    }
}
