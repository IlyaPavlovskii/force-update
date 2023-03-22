package io.github.ilyapavlovskii.kmm.mvi.force.update.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class AppUpdateTransferModel(
    @SerialName("priority") val priority: AppUpdatePriority,
    @SerialName("version_code") val versionCode: Int
)
