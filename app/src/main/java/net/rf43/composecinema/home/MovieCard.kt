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
import net.rf43.composecinema.common.movieCardList
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
            .width(100.dp)
            .height(120.dp)
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
                    .height(60.dp)
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
                    modifier = Modifier.size(18.dp),
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
                    modifier = Modifier.size(24.dp),
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
