package net.rf43.composecinema.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import net.rf43.composecinema.ui.theme.ComposeCinemaTheme
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun TopSection(
    modifier: Modifier = Modifier,
    carouselItems: List<CarouselItemData>
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
        val pagerState = rememberPagerState(pageCount = { carouselItems.size })
        val offsetFraction by remember {
            derivedStateOf {
                pagerState.currentPageOffsetFraction
            }
        }

        AutoCarousel(
            modifier = Modifier.fillMaxSize(),
            pagerState = pagerState,
            itemCount = carouselItems.size,
            itemContent = { page ->
                CarouselItem(
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            val pageOffset =
                                ((pagerState.currentPage - page) + offsetFraction).absoluteValue

                            alpha = lerp(
                                start = 0f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )

                            val scale = lerp(1f, 0.7f, pageOffset)
                            scaleX = scale
                            scaleY = scale
                        },
                    carouselItemData = carouselList[page]
                )
            },
            onPageChange = { }
        )
    }
}

@Preview
@Composable
private fun Preview() {
    ComposeCinemaTheme {
        Surface {
            TopSection(
                carouselItems = carouselList
            )
        }
    }
}
