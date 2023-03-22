package io.github.ilyapavlovskii.kmm.force.update.presentation.force

import androidx.compose.foundation.layout.fillMaxWidth
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

data class ForceUpdateStyle(
    val background: Color,
    val titleModifier: Modifier,
    val titleStyle: TextStyle,
    val imageModifier: Modifier,
    val descriptionModifier: Modifier,
    val descriptionStyle: TextStyle,
    val updateButtonModifier: Modifier,
    val updateButtonShape: Shape = RoundedCornerShape(48.dp),
    val updateButtonColors: ButtonColors,
    val updateButtonTextModifier: Modifier,
    val updateButtonTextStyle: TextStyle,
) {
    companion object {
        @Composable
        fun create() = ForceUpdateStyle(
            background = MaterialTheme.colorScheme.background,
            titleModifier = Modifier.padding(vertical = 8.dp),
            titleStyle = MaterialTheme.typography.headlineLarge,
            imageModifier = Modifier.padding(16.dp),
            descriptionModifier = Modifier.padding(vertical = 8.dp),
            descriptionStyle = MaterialTheme.typography.titleMedium,
            updateButtonModifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth(),
            updateButtonColors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.surface
            ),
            updateButtonTextModifier = Modifier.padding(vertical = 4.dp, horizontal = 60.dp),
            updateButtonTextStyle = MaterialTheme.typography.titleMedium,
        )
    }
}
