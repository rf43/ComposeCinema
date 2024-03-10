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
    carouselItemData: CarouselItemData
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
                .data(carouselItemData.imageUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(id = R.drawable.video_chat),
            error = painterResource(id = R.drawable.video_chat),
            contentScale = ContentScale.Fit,
            contentDescription = null
        )
        Text(
            text = carouselItemData.title,
            style = MaterialTheme.typography.titleLarge,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = carouselItemData.description,
            maxLines = 3,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 20.dp),
        )
    }
}

data class CarouselItemData(
    val title: String,
    val description: String,
    val imageUrl: String
)

val carouselList: List<CarouselItemData> = listOf(
    CarouselItemData(
        title = "Aqua Teen Hunger Force",
        description = "The surreal adventures of three anthropomorphic fast food items: " +
                "Master Shake, Frylock and Meatwad, and their human next door neighbor, " +
                "Carl Brutananadilewski.",
        imageUrl = "https://image.tmdb.org/t/p/w1280/jCWOkfMLsT2sGHadCkmR65MWtJu.jpg"
    ),
    CarouselItemData(
        title = "Grandma's Boy",
        description = "Even though he's 35, Alex acts more like he's 13, spending his days " +
                "as the world's oldest video game tester and his evenings developing the " +
                "next big Xbox game. But when he gets kicked out of his apartment, he's " +
                "forced to move in with his grandmother.",
        imageUrl = "https://image.tmdb.org/t/p/w1280/zaGIcb0hXxUbuyIZ0j7uCmbO1li.jpg"
    ),
    CarouselItemData(
        title = "The Replacements",
        description = "Maverick old-guard coach Jimmy McGinty is hired in the wake of a " +
                "players' strike to help the Washington Sentinels advance to the playoffs. " +
                "But that impossible dream hinges on whether his replacements can hunker down " +
                "and do the job. So, McGinty dusts off his secret dossier of ex-players who " +
                "never got a chance (or screwed up the one they were given) and knits together " +
                "a bad-dream team of guys who just may give the Sentinels their title shot.",
        imageUrl = "https://image.tmdb.org/t/p/w1280/6qerI41HqkdRlio1sG0d5HLZcFN.jpg"
    )
)