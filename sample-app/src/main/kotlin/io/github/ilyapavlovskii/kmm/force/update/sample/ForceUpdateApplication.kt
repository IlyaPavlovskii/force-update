package io.github.ilyapavlovskii.kmm.force.update.sample

import android.app.Application
import io.github.ilyapavlovskii.kmm.force.update.usecase.impl.SimpleGetForceUpdateEventFlowUseCase

internal val useCase = SimpleGetForceUpdateEventFlowUseCase()

internal class ForceUpdateApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}