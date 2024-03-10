package net.rf43.composecinema.home

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun AutoCarousel(
    modifier: Modifier = Modifier,
    animationDurationMillis: Int,
    animationDelayMillis: Int,
    itemCount: Int,
    itemContent: @Composable (index: Int) -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { itemCount })

    LaunchedEffect(key1 = pagerState.settledPage) {
        pagerState.animateScrollToPage(
            page = if (pagerState.settledPage == itemCount - 1) 0 else (pagerState.settledPage + 1),
            animationSpec = tween(
                durationMillis = animationDurationMillis,
                delayMillis = animationDelayMillis,
                easing = FastOutSlowInEasing
            )
        )
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f),
        ) { index ->
            itemContent(index)
        }

        CarouselIndexIndicator(
            modifier = Modifier.padding(top = 16.dp),
            dotCount = itemCount,
            selectedIndex = pagerState.settledPage
        )
    }
}