package net.rf43.composecinema.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DetailScreenRoute(
    viewModel: DetailScreenViewModel,
    onNavigate: () -> Unit
) {
    DetailScreen {
        onNavigate()
    }
}

@Composable
private fun DetailScreen(onClick: () -> Unit) {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Text(text = "Detail Screen")
            Button(onClick = { onClick() }) {
                Text(text = "Home Screen")
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    DetailScreen {

    }
}