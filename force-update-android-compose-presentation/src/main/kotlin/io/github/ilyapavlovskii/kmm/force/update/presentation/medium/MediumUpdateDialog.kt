package io.github.ilyapavlovskii.kmm.force.update.presentation.medium

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import io.github.ilyapavlovskii.kmm.force.update.presentation.R
import io.github.ilyapavlovskii.kmm.force.update.presentation.stringFromAttribute
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun MediumUpdateDialog(
    style: MediumUpdateDialogStyle = MediumUpdateDialogStyle.create(),
    onCancelListener: () -> Unit,
    onMediumUpdateClick: () -> Unit,
) {
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Expanded,
        confirmStateChange = {
            onCancelListener()
            it != ModalBottomSheetValue.HalfExpanded
        },
    )
    val coroutineScope = rememberCoroutineScope()
    BackHandler(sheetState.isVisible) {
        coroutineScope.launch { sheetState.hide() }
        onCancelListener()
    }

    ModalBottomSheetLayout(
        modifier = Modifier.fillMaxSize(),
        sheetState = sheetState,
        sheetContent = {
            MediumUpdateDialogContent(
                style = style,
                onMediumUpdateClick = {
                    coroutineScope.launch { sheetState.hide() }
                    onMediumUpdateClick()
                },
                onCancelListener = {
                    coroutineScope.launch { sheetState.hide() }
                    onCancelListener()
                },
            )
        },
        sheetShape = style.sheetShape,
        sheetBackgroundColor = style.sheetBackgroundColor,
        content = {}
    )
}

@Composable
private fun MediumUpdateDialogContent(
    style: MediumUpdateDialogStyle,
    onCancelListener: () -> Unit,
    onMediumUpdateClick: () -> Unit,
) {
    Column(
        modifier = style.contentModifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = style.titleModifier,
            text = stringFromAttribute(attributeId = R.attr.force_update__medium_title)
                ?: stringResource(R.string.force_update__medium_title),
            style = style.titleStyle,
            color = style.titleColor,
        )
        Text(
            modifier = style.descriptionModifier,
            text = stringFromAttribute(attributeId = R.attr.force_update__medium_description)
                ?: stringResource(R.string.force_update__medium_description),
            style = style.descriptionStyle,
            color = style.descriptionColor,
        )
        OutlinedButton(
            onClick = onMediumUpdateClick,
            modifier = style.updateButtonModifier,
            shape = style.updateButtonShape,
            colors = style.updateButtonColors,
        ) {
            Text(
                text = stringFromAttribute(attributeId = R.attr.force_update__button_update)
                    ?: stringResource(R.string.force_update__button_update),
                modifier = style.updateButtonTextModifier,
                style = style.updateButtonTextStyle,
            )
        }
        OutlinedButton(
            onClick = onCancelListener,
            modifier = style.cancelButtonModifier,
            shape = style.cancelButtonShape,
            colors = style.cancelButtonColors,
        ) {
            Text(
                text = stringFromAttribute(attributeId = R.attr.force_update__button_cancel)
                    ?: stringResource(R.string.force_update__button_cancel),
                modifier = style.cancelButtonTextModifier,
                style = style.cancelButtonTextStyle,
            )
        }
    }
}

// @Preview
// @Composable
// private fun PreviewMediumUpdateDialog() {
//     ForceUpdateTheme {
//         MediumUpdateDialogContent(
//             style = MediumUpdateDialogStyle.create(),
//             onMediumUpdateClick = {},
//             onCancelListener = {},
//         )
//     }
// }
