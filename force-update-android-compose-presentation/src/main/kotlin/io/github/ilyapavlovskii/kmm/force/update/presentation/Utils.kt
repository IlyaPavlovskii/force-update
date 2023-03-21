package io.github.ilyapavlovskii.kmm.force.update.presentation

import android.content.res.Resources
import android.util.TypedValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource

@Composable
internal fun imageVectorFromAttribute(attributeId: Int): ImageVector? {
    val theme = LocalContext.current.theme
    val typedValue = TypedValue().also { theme.resolveAttribute(attributeId, it, true) }
    return if (typedValue.resourceId != Resources.ID_NULL) {
        ImageVector.vectorResource(id = typedValue.resourceId)
    } else {
        null
    }
}

@Composable
internal fun imageBitmapFromAttribute(attributeId: Int): ImageBitmap? {
    val theme = LocalContext.current.theme
    val typedValue = TypedValue().also { theme.resolveAttribute(attributeId, it, true) }
    return if (typedValue.resourceId != Resources.ID_NULL) {
        ImageBitmap.imageResource(id = typedValue.resourceId)
    } else {
        null
    }
}

@Composable
internal fun stringFromAttribute(attributeId: Int): String? {
    val theme = LocalContext.current.theme
    val typedValue = TypedValue().also { theme.resolveAttribute(attributeId, it, true) }
    return typedValue.string?.toString()
}
