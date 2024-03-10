package net.rf43.composecinema.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.rf43.composecinema.ui.theme.ComposeCinemaTheme

@Composable
internal fun TopSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF212931),
                        Color.Transparent
                    ),
                    endY = 400.dp.value
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        AutoCarousel(
            modifier = Modifier.fillMaxSize(),
            itemCount = 3,
            itemContent = {
                CarouselItem()
            }
        )
    }
}

@Preview
@Composable
private fun Preview() {
    ComposeCinemaTheme {
        Surface {
            TopSection()
        }
    }
}
