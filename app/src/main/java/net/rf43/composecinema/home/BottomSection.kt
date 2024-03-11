package net.rf43.composecinema.home

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.rf43.composecinema.ui.theme.ComposeCinemaTheme

@Composable
internal fun BottomSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .padding(vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .height(40.dp)
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            Color(0xBE212931),
                            Color.Transparent
                        ),
                        endX = 270.dp.value
                    )
                )
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Popular Movies",
                style = MaterialTheme.typography.titleSmall,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            movieCardList.forEach { movieItem ->
                MovieCard(
                    data = movieItem,
                    onItemClick = { /*TODO*/ },
                    onFavoriteClick = { /*TODO*/ },
                    onItemPlayClick = { /*TODO*/ }
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ComposeCinemaTheme {
        Surface {
            BottomSection()
        }
    }
}
