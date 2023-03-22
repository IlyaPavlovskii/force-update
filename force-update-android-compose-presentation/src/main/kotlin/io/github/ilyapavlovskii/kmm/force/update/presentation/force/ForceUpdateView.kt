package io.github.ilyapavlovskii.kmm.force.update.presentation.force

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.github.ilyapavlovskii.kmm.force.update.presentation.R
import io.github.ilyapavlovskii.kmm.force.update.presentation.imageBitmapFromAttribute
import io.github.ilyapavlovskii.kmm.force.update.presentation.imageVectorFromAttribute
import io.github.ilyapavlovskii.kmm.force.update.presentation.stringFromAttribute

@Composable
internal fun ForceUpdateView(
    style: ForceUpdateStyle,
    onForceUpdateCLick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(style.background),
    ) {
        Text(
            modifier = style.titleModifier,
            text = stringFromAttribute(attributeId = R.attr.force_update__force_title)
                ?: stringResource(R.string.force_update__force_title),
            style = style.titleStyle,
        )
        imageVectorFromAttribute(attributeId = R.attr.force_update__force_icon_vector)
            ?.also { imageVector ->
                Image(
                    imageVector = imageVector,
                    modifier = Modifier.weight(4f).then(style.imageModifier),
                    contentDescription = stringResource(id = R.string.force_update__force_icon_content_description)
                )
            }
        imageBitmapFromAttribute(attributeId = R.attr.force_update__force_icon_raster)
            ?.also { imageBitmap ->
                Image(
                    bitmap = imageBitmap,
                    modifier = Modifier.weight(4f).then(style.imageModifier),
                    contentDescription = stringResource(id = R.string.force_update__force_icon_content_description)
                )
            }

        Text(
            modifier = Modifier
                .weight(2f)
                .then(style.descriptionModifier),
            text = stringFromAttribute(attributeId = R.attr.force_update__force_description)
                ?: stringResource(R.string.force_update__force_description),
            style = style.descriptionStyle,
        )
        OutlinedButton(
            onClick = onForceUpdateCLick,
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
    }
}

// @Preview
// @Composable
// private fun PreviewForceUpdateView() {
//     ForceUpdateTheme {
//         ForceUpdateView(
//             style = ForceUpdateStyle.create(),
//             onForceUpdateCLick = {},
//         )
//     }
// }
