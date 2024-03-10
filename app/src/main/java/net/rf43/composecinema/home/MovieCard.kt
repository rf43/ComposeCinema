package net.rf43.composecinema.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
internal fun MovieCard(
    modifier: Modifier = Modifier,
    onFavoriteClick: () -> Unit = {}
) {
    var favoriteIconFilled by remember { mutableStateOf(true) }

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .width(200.dp)
            .height(250.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
        )
    ) {
        Column {
            Spacer(modifier = Modifier.height(24.dp))
            AsyncImage(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxWidth(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://upload.wikimedia.org/wikipedia/commons/c/c5/Big_buck_bunny_poster_big.jpg")
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(id = R.drawable.video_chat),
                contentScale = ContentScale.Fit,
                contentDescription = null,
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                text = "Big Buck Bunny",
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center
            )
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(
                    modifier = Modifier.size(24.dp),
                    onClick = {
                        favoriteIconFilled = !favoriteIconFilled
                        onFavoriteClick()
                    }
                ) {
                    Icon(
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
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ComposeCinemaTheme {
        Surface {
            MovieCard()
        }
    }
}
