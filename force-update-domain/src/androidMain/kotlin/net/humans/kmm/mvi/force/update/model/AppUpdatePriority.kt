package net.humans.kmm.mvi.force.update.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal enum class AppUpdatePriority {
    /**
     * Low priority type.
     * Doesn't show/show rarely in app update suggestion with that type.
     * */
    @SerialName("low")
    LOW,
    /**
     * Show in app update each time when user receive that type.
     * */
    @SerialName("medium")
    MEDIUM,
    /**
     * Force update. A user can't use the application until update it.
     * */
    @SerialName("high")
    HIGH,
    ;
}
