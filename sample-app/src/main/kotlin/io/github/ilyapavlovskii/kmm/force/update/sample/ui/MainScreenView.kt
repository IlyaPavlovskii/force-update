package io.github.ilyapavlovskii.kmm.force.update.sample.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ilyapavlovskii.kmm.force.update.ui.ForceUpdateTheme

@Composable
internal fun MainScreenView(
    viewState: MainScreenViewState,
    onDropUpdateClicked: () -> Unit,
    onMediumUpdateClicked: () -> Unit,
    onForceUpdateClicked: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(all = 16.dp),
            text = "Don't forget to restart application to apply current mode.",
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier.padding(all = 16.dp),
            text = "Selected mode: ${viewState.selectedMode}",
            textAlign = TextAlign.Center,
        )
        Button(onClick = onDropUpdateClicked) {
            Text(text = "Drop update")
        }
        Button(onClick = onMediumUpdateClicked) {
            Text(text = "Medium update")
        }
        Button(onClick = onForceUpdateClicked) {
            Text(text = "Force update")
        }
    }
}

@Preview
@Composable
private fun PreviewMainScreenView() {
    ForceUpdateTheme {
        MainScreenView(
            viewState = MainScreenViewState(
                "no force update"
            ),
            onDropUpdateClicked = {},
            onMediumUpdateClicked = {},
            onForceUpdateClicked = {}
        )
    }
}