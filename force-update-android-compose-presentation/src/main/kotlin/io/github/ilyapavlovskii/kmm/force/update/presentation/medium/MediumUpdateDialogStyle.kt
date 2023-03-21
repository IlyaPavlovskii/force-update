package io.github.ilyapavlovskii.kmm.force.update.presentation.medium

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

data class MediumUpdateDialogStyle(
    val sheetShape: Shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    val sheetBackgroundColor: Color,
    val contentModifier: Modifier,
    val titleModifier: Modifier,
    val titleStyle: TextStyle,
    val descriptionModifier: Modifier,
    val descriptionStyle: TextStyle,
    val updateButtonModifier: Modifier,
    val updateButtonShape: Shape = RoundedCornerShape(48.dp),
    val updateButtonColors: ButtonColors,
    val updateButtonTextModifier: Modifier,
    val updateButtonTextStyle: TextStyle,
    val cancelButtonModifier: Modifier,
    val cancelButtonShape: Shape = RoundedCornerShape(48.dp),
    val cancelButtonColors: ButtonColors,
    val cancelButtonTextModifier: Modifier,
    val cancelButtonTextStyle: TextStyle,
) {
    companion object {
        @Composable
        fun create() = MediumUpdateDialogStyle(
            sheetBackgroundColor = MaterialTheme.colors.background,
            contentModifier = Modifier.padding(16.dp),
            titleModifier = Modifier.padding(vertical = 8.dp),
            titleStyle = MaterialTheme.typography.h5,
            descriptionModifier = Modifier.padding(vertical = 8.dp),
            descriptionStyle = MaterialTheme.typography.body1,
            updateButtonModifier = Modifier.padding(all = 8.dp),
            updateButtonColors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = MaterialTheme.colors.surface
            ),
            updateButtonTextModifier = Modifier.padding(vertical = 4.dp, horizontal = 48.dp),
            updateButtonTextStyle = MaterialTheme.typography.body2,
            cancelButtonModifier = Modifier.padding(all = 8.dp),
            cancelButtonColors = ButtonDefaults.outlinedButtonColors(),
            cancelButtonTextModifier = Modifier.padding(vertical = 4.dp, horizontal = 48.dp),
            cancelButtonTextStyle = MaterialTheme.typography.body2,
        )
    }
}
