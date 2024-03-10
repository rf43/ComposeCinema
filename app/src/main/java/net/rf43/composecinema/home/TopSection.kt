package net.rf43.composecinema.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import net.rf43.composecinema.R
import net.rf43.composecinema.ui.theme.ComposeCinemaTheme
import net.rf43.composecinema.ui.theme.posterBackgroundGradientEnd
import net.rf43.composecinema.ui.theme.posterBackgroundGradientStart

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
                        posterBackgroundGradientStart,
                        posterBackgroundGradientEnd
                    ),
                    endY = 400.dp.value
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        AsyncImage(
            modifier = Modifier.weight(3f),
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://image.tmdb.org/t/p/w1280/jCWOkfMLsT2sGHadCkmR65MWtJu.jpg")
                .crossfade(true)
                .build(),
            placeholder = painterResource(id = R.drawable.video_chat),
            contentScale = ContentScale.Fit,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Aqua Teen Hunger Force",
            style = MaterialTheme.typography.titleLarge,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "The surreal adventures of three anthropomorphic fast food items: " +
                    "Master Shake, Frylock and Meatwad, and their human next door neighbor, " +
                    "Carl Brutananadilewski.",
            maxLines = 3,
            style = MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 20.dp),
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
