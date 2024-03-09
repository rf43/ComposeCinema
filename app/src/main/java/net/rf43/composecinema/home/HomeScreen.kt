package net.rf43.composecinema.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.rf43.composecinema.ui.theme.ComposeCinemaTheme

@Composable
fun HomeScreenRoute(
    viewModel: HomeScreenViewModel,
    onNavigate: () -> Unit
) {
    HomeScreen {
        onNavigate()
    }
}

@Composable
private fun HomeScreen(
    onClick: () -> Unit
) {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Text(text = "Home Screen")
            Button(onClick = { onClick() }) {
                Text(text = "Detail Screen")
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ComposeCinemaTheme {
        // A surface container using the 'background' color from the theme
        Surface {
            HomeScreen() {}
        }
    }
}