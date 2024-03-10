package net.rf43.composecinema.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import net.rf43.composecinema.R

@Composable
internal fun CarouselItem(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .weight(weight = 1f, fill = true)
                .padding(
                    horizontal = 16.dp,
                    vertical = 24.dp
                ),
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://image.tmdb.org/t/p/w1280/jCWOkfMLsT2sGHadCkmR65MWtJu.jpg")
                .crossfade(true)
                .build(),
            placeholder = painterResource(id = R.drawable.video_chat),
            error = painterResource(id = R.drawable.video_chat),
            contentScale = ContentScale.Fit,
            contentDescription = null
        )
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
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 20.dp),
        )
    }
}