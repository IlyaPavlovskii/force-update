package io.github.ilyapavlovskii.kmm.force.update.presentation.medium

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
    val titleColor: Color,
    val descriptionModifier: Modifier,
    val descriptionStyle: TextStyle,
    val descriptionColor: Color,
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
            sheetBackgroundColor = MaterialTheme.colorScheme.surfaceVariant,
            contentModifier = Modifier.padding(16.dp),
            titleModifier = Modifier.padding(vertical = 8.dp),
            titleStyle = MaterialTheme.typography.headlineLarge,
            titleColor = MaterialTheme.colorScheme.onSurfaceVariant,
            descriptionModifier = Modifier.padding(vertical = 8.dp),
            descriptionStyle = MaterialTheme.typography.titleMedium,
            descriptionColor = MaterialTheme.colorScheme.onSurfaceVariant,
            updateButtonModifier = Modifier.padding(all = 8.dp),
            updateButtonColors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.surface
            ),
            updateButtonTextModifier = Modifier.padding(vertical = 4.dp, horizontal = 60.dp),
            updateButtonTextStyle = MaterialTheme.typography.titleMedium,
            cancelButtonModifier = Modifier.padding(all = 8.dp),
            cancelButtonColors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = MaterialTheme.colorScheme.onBackground,
                contentColor = MaterialTheme.colorScheme.surface
            ),
            cancelButtonTextModifier = Modifier.padding(vertical = 4.dp, horizontal = 60.dp),
            cancelButtonTextStyle = MaterialTheme.typography.titleMedium,
        )
    }
}
