package net.rf43.composecinema.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import net.rf43.composecinema.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeTopAppBar() {
    TopAppBar(
        colors = topAppBarColors(containerColor = MaterialTheme.colorScheme.surface),
        title = {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.compose_cinema_logo),
                    contentDescription = stringResource(id = R.string.app_name),
                )
            }
        }
    )
}
