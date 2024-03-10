package net.rf43.composecinema.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.rf43.composecinema.R
import net.rf43.composecinema.ui.theme.ComposeCinemaTheme

@Composable
internal fun MovieCard() {
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .width(200.dp)
            .height(250.dp)
            .background(MaterialTheme.colorScheme.surfaceContainer)
    ) {
        Column {
            Spacer(modifier = Modifier.height(24.dp))
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(x = 4.dp, y = 4.dp),
                    painter = painterResource(id = R.drawable.video_chat),
                    contentDescription = null,
                    tint = Color(0x801A191E)
                )
                Icon(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.video_chat),
                    contentDescription = null,
                    tint = Color(0xFF1A191E)
                )
            }

//            AsyncImage(
//                modifier = Modifier.weight(2f).fillMaxWidth(),
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data("https://image.tmdb.org/t/p/w1280/jCWOkfMLsT2sGHadCkmR65MWtJu.jpg")
//                    .crossfade(true)
//                    .build(),
//                placeholder = painterResource(id = R.drawable.video_chat),
//                contentScale = ContentScale.Fit,
//                contentDescription = null,
//                alignment = Alignment.Center
//            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                text = "This is a movie card",
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Center
            )
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
