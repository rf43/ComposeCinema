package net.rf43.composecinema.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.rf43.composecinema.ui.theme.ComposeCinemaTheme

@Composable
fun HomeScreenRoute(
    viewModel: HomeScreenViewModel,
    onNavigate: () -> Unit
) {
    Surface {
        HomeScreen {
            onNavigate()
        }
    }
}

@Composable
private fun HomeScreen(
    onClick: () -> Unit
) {
    Scaffold(
        topBar = {
            HomeTopAppBar()
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Hero(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
                BottomSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "id:Nexus 6P",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "id:pixel_5",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun Preview() {
    ComposeCinemaTheme {
        // A surface container using the 'background' color from the theme
        Surface {
            HomeScreen() {}
        }
    }
}
