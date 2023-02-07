package io.github.ilyapavlovskii.kmm.change.theme.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import io.github.ilyapavlovskii.kmm.change.theme.ui.ChangeThemeTheme
import io.github.ilyapavlovskii.kmm.kmm.change.theme.presentation.ChangeThemeScreen

internal class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChangeThemeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChangeThemeScreen(
                        onBackClick = ::finish
                    )
                }
            }
        }
    }
}
