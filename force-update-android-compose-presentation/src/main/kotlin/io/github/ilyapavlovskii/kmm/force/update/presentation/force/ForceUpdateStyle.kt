package io.github.ilyapavlovskii.kmm.force.update.presentation.force

import androidx.compose.foundation.layout.fillMaxWidth
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
            background = MaterialTheme.colors.background,
            titleModifier = Modifier.padding(vertical = 8.dp),
            titleStyle = MaterialTheme.typography.h4,
            imageModifier = Modifier.padding(16.dp),
            descriptionModifier = Modifier.padding(vertical = 8.dp),
            descriptionStyle = MaterialTheme.typography.body1,
            updateButtonModifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth(),
            updateButtonColors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = MaterialTheme.colors.surface
            ),
            updateButtonTextModifier = Modifier.padding(vertical = 4.dp, horizontal = 48.dp),
            updateButtonTextStyle = MaterialTheme.typography.button,
        )
    }
}
