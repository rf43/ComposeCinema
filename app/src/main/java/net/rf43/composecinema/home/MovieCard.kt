package net.rf43.composecinema.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun MovieCard() {
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .width(200.dp)
            .height(250.dp)
            .background(MaterialTheme.colorScheme.surfaceContainer)
    )
}
