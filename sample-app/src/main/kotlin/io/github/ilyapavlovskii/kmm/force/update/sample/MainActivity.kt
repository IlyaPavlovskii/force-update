package io.github.ilyapavlovskii.kmm.force.update.sample

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import io.github.ilyapavlovskii.kmm.force.update.model.ForceUpdateType
import io.github.ilyapavlovskii.kmm.force.update.presentation.ForceUpdateScreen
import io.github.ilyapavlovskii.kmm.force.update.sample.ui.MainScreen
import io.github.ilyapavlovskii.kmm.force.update.ui.ForceUpdateTheme

internal class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForceUpdateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(useCase = useCase)

                    ForceUpdateScreen(
                        getForceUpdateEventFlowUseCase = useCase,
                        applicationUri = Uri.parse("https://play.google.com/store/apps/details?id=by.bulba.ipsc.calculator"),
                        onCancelListener = { useCase.update(ForceUpdateType.ABSENT) },
                        onMediumUpdateClick = { useCase.update(ForceUpdateType.ABSENT) },
                    )
                }
            }
        }
    }
}
