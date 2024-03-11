package net.rf43.composecinema.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import net.rf43.composecinema.R
import net.rf43.composecinema.common.MovieItem
import net.rf43.composecinema.ui.theme.ComposeCinemaTheme

@Composable
internal fun MovieCard(
    modifier: Modifier = Modifier,
    data: MovieItem,
    onItemClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onItemPlayClick: () -> Unit
) {
    // TODO: Why is this reversed?
    var favoriteIconFilled by remember { mutableStateOf(!data.isFavorite) }

    Card(
        modifier = modifier
            .width(200.dp)
            .padding(horizontal = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
        ),
        onClick = onItemClick
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data.imageUrl)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(id = R.drawable.video_chat),
                error = painterResource(id = R.drawable.video_chat),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                alignment = Alignment.Center
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color(0x9A000000),
                            ),
                            endY = 120.dp.value
                        )
                    )
                    .padding(horizontal = 24.dp)
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                IconButton(
                    modifier = Modifier.size(32.dp),
                    onClick = {
                        favoriteIconFilled = !favoriteIconFilled
                        onFavoriteClick()
                    }
                ) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(
                            id = if (favoriteIconFilled) {
                                R.drawable.favorite_outline_24
                            } else {
                                R.drawable.favorite_filled_24
                            }
                        ),
                        contentDescription = null
                    )
                }
                IconButton(
                    modifier = Modifier.size(32.dp),
                    onClick = onItemPlayClick
                ) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(
                            id = R.drawable.play_circle_outline
                        ),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ComposeCinemaTheme {
        Surface {
            MovieCard(
                data = movieCardList[0],
                onItemClick = {},
                onFavoriteClick = {},
                onItemPlayClick = {}
            )
        }
    }
}

val movieCardList: List<MovieItem> = listOf(
    MovieItem(
        title = "Big Buck Bunny",
        description = "Big Buck Bunny is a short computer-animated comedy film, featuring animals of the forest.",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/c/c5/Big_buck_bunny_poster_big.jpg"
    ),
    MovieItem(
        title = "Sintel",
        description = "A wandering warrior finds an unlikely friend in the form of a young " +
                "dragon. The two develop a close bond, until one day the dragon is snatched " +
                "away. She then sets out on a relentless quest to reclaim her friend, finding " +
                "in the end that her quest exacts a far greater price than she had ever imagined.",
        imageUrl = "https://image.tmdb.org/t/p/w1280/4BMG9hk9NvSBeQvC82sVmVRK140.jpg"
    ),
    MovieItem(
        title = "Tears of Steel",
        description = "The film’s premise is about a group of warriors and scientists, who " +
                "gathered at the “Oude Kerk” in Amsterdam to stage a crucial event from the " +
                "past, in a desperate attempt to rescue the world from destructive robots.",
        imageUrl = "https://image.tmdb.org/t/p/w1280/vamqM0xH998F8B9WicVAkWP6E9N.jpg"
    ),
    MovieItem(
        title = "Cosmos Laundromat",
        description = "On a desolate island, suicidal sheep Franck meets his fate in a quirky " +
                "salesman, who offers him the gift of a lifetime. Little does he know that he " +
                "can only handle this much 'lifetime'.",
        imageUrl = "https://image.tmdb.org/t/p/w1280/5ZXi0oitpEgAdoJglFTc5SZF9nt.jpg"
    ),
    MovieItem(
        title = "Alike",
        description = "In a busy life, Copi is a father who tries to teach the right way to " +
                "his son, Paste. But - What is the correct path?",
        imageUrl = "https://image.tmdb.org/t/p/w1280/eWybsTSw5EtLuhnoJrQewiWJFzB.jpg"
    ),
    MovieItem(
        title = "Bio-Dome",
        description = "Bud and Doyle are two losers who are doing nothing with their lives. " +
                "Both of their girlfriends are actively involved in saving the environment, " +
                "but the two friends couldn't care less about saving the Earth. One day, when " +
                "a group of scientists begin a mission to live inside a \"Bio-Dome\" for a year " +
                "without outside contact, Bud and Doyle mistakenly become part of the project " +
                "themselves.",
        imageUrl = "https://image.tmdb.org/t/p/w1280/pkL8rqpO0EryTV1DLJJdrhOZ7sL.jpg"
    ),
    MovieItem(
        title = "Tiki Bar Funeral Home",
        description = "After 12 years, a failing actress returns to her hometown to attend her " +
                "ex-boyfriend's tiki-themed funeral where she plans to tell his best friend " +
                "she's in love with him, only when she arrives she finds her ex still alive.",
        imageUrl = "https://image.tmdb.org/t/p/w1280/vuu03gGzCHUJ0i1ItAUy9FbFBBf.jpg"
    )
)
