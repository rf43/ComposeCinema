package net.rf43.composecinema.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import net.rf43.composecinema.ui.theme.ComposeCinemaTheme

@Composable
internal fun CarouselIndexIndicator(
    modifier: Modifier = Modifier,
    dotCount: Int,
    selectedIndex: Int,
    selectedColor: Color,
    unselectedColor: Color,
    selectedDotSize: Dp,
    unselectedDotSize: Dp
) {
    Box(modifier = modifier) {
        LazyRow(
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(dotCount) { index ->
                IndicatorDot(
                    size = if (index == selectedIndex) selectedDotSize else unselectedDotSize,
                    color = if (index == selectedIndex) selectedColor else unselectedColor
                )
                if (index != dotCount - 1) {
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}

@Composable
private fun IndicatorDot(
    modifier: Modifier = Modifier,
    size: Dp,
    color: Color
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(color)
    )
}

@Preview
@Composable
fun DotsPreview() {
    ComposeCinemaTheme {
        Surface {
            CarouselIndexIndicator(
                dotCount = 5,
                selectedIndex = 2,
                selectedColor = Color.White,
                unselectedColor = Color.Gray,
                selectedDotSize = 12.dp,
                unselectedDotSize = 8.dp
            )
        }
    }
}
