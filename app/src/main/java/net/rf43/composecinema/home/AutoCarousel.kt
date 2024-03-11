package net.rf43.composecinema.home

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private const val ANIMATION_DURATION_MILLIS: Int = 1300
private const val ANIMATION_DELAY_MILLIS: Int = 10000

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun AutoCarousel(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    itemCount: Int,
    itemContent: @Composable (page: Int) -> Unit,
    onPageChange: (Int) -> Unit
) {
    val fling = PagerDefaults.flingBehavior(
        state = pagerState,
        pagerSnapDistance = PagerSnapDistance.atMost(1),
        snapPositionalThreshold = 0.2f
    )

    var nextPage by remember { mutableIntStateOf(0) }

    LaunchedEffect(key1 = pagerState.settledPage) {
        // I am not sure yet if there is a bug with this when setting
        // the next page to 0 when the current page is the last one.
        // I need to create a test project to see if I can reproduce
//        nextPage = if (pagerState.currentPage == itemCount - 1) {
//            0
//        } else {
//            pagerState.currentPage + 1
//        }
        nextPage = pagerState.currentPage + 1

        pagerState.animateScrollToPage(
            page = nextPage,
            animationSpec = tween(
                durationMillis = ANIMATION_DURATION_MILLIS,
                delayMillis = ANIMATION_DELAY_MILLIS,
                easing = FastOutSlowInEasing
            )
        )

        snapshotFlow { pagerState.currentPage }.collect { page ->
            onPageChange(page)
        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f),
            pageSize = PageSize.Fill,
            flingBehavior = fling,
        ) { page ->
            itemContent(page)
        }

        CarouselIndexIndicator(
            modifier = Modifier.padding(top = 16.dp),
            dotCount = itemCount,
            selectedIndex = pagerState.currentPage,
            selectedColor = MaterialTheme.colorScheme.primary,
            unselectedColor = MaterialTheme.colorScheme.onSurface,
            selectedDotSize = 10.dp,
            unselectedDotSize = 8.dp
        )
    }
}