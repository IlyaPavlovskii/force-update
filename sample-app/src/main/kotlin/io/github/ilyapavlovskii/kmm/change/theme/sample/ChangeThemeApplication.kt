package io.github.ilyapavlovskii.kmm.change.theme.sample

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

internal class ChangeThemeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ChangeThemeApplication)
            modules(ChangeThemeComponent.modules)
        }
    }
}