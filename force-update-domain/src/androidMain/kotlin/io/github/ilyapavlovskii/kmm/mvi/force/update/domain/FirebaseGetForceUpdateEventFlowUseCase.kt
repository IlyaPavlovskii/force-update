package io.github.ilyapavlovskii.kmm.mvi.force.update.domain

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import io.github.ilyapavlovskii.kmm.force.update.model.ForceUpdateType
import io.github.ilyapavlovskii.kmm.force.update.usecase.GetForceUpdateEventFlowUseCase
import io.github.ilyapavlovskii.kmm.mvi.force.update.model.AppUpdatePriority
import io.github.ilyapavlovskii.kmm.mvi.force.update.model.AppUpdateTransferModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit

class FirebaseGetForceUpdateEventFlowUseCase(
    private val json: Json = Json.Default,
    private val currentApplicationVersion: Int,
    private val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig,
    private val fetchTimeout: Duration = 60.seconds,
    private val minimumFetchInterval: Duration = 12.hours,
    private val appUpdateKey: String = APP_UPDATE_KEY,
) : GetForceUpdateEventFlowUseCase {
    private val _event = MutableStateFlow<ForceUpdateType>(ForceUpdateType.ABSENT)
    override val event: StateFlow<ForceUpdateType> = _event

    init {
        val remoteConfigSettings = remoteConfigSettings {
            fetchTimeoutInSeconds = fetchTimeout.toLong(DurationUnit.SECONDS)
            minimumFetchIntervalInSeconds = minimumFetchInterval.toLong(DurationUnit.SECONDS)
        }
        remoteConfig.apply {
            setConfigSettingsAsync(remoteConfigSettings)

            activate()
                .addOnCompleteListener {
                    remoteConfig.fetch()
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Log.d(TAG, "New config was fetched")
                                parseInAppUpdateTransferInfo()
                            } else {
                                Log.d(TAG, "Could not fetch new config")
                            }
                        }
                }
        }
    }

    private fun parseInAppUpdateTransferInfo() {
        val jsonString = remoteConfig.getString(appUpdateKey)
        if (jsonString.isEmpty()) {
            Log.d(TAG, "Remote config for $appUpdateKey key was empty")
        } else {
            runCatching {
                json.decodeFromString<AppUpdateTransferModel>(jsonString)
            }.onSuccess { transferModel ->
                updateEventIfNeeded(transferModel)
            }.onFailure { ex ->
                Log.e(TAG, "Parse jsonModel error", ex)
            }
        }
    }

    private fun updateEventIfNeeded(transferModel: AppUpdateTransferModel) {
        if (currentApplicationVersion < transferModel.versionCode) {
            when (transferModel.priority) {
                AppUpdatePriority.LOW -> {
                    // Do nothing
                }

                AppUpdatePriority.MEDIUM -> {
                    _event.value = ForceUpdateType.MEDIUM
                }

                AppUpdatePriority.HIGH -> {
                    _event.value = ForceUpdateType.FORCE
                }
            }
        }
    }

    companion object {
        private const val TAG = "FirebaseGetForceUpdateEventFlowUseCase"
        private const val APP_UPDATE_KEY = "app_update"
    }
}
