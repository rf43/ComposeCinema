package net.rf43.composecinema.components

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

private const val EXAMPLE_VIDEO_URI_01 =
    "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
private const val EXAMPLE_VIDEO_URI_02 =
    "https://player.vimeo.com/external/296210754.hd.mp4?s=08c03c14c04f15d65901f25b542eb2305090a3d7&profile_id=175&oauth2_token_id=57447761"
private const val EXAMPLE_VIDEO_URI_03 =
    "https://commondatastorage.googleapis.com/gtv-videos-bucket/CastVideos/hls/BigBuckBunny.m3u8"
private const val EXAMPLE_VIDEO_URI_04 =
    "https://commondatastorage.googleapis.com/gtv-videos-bucket/CastVideos/hls/ElephantsDream.m3u8"
private const val EXAMPLE_VIDEO_URI_05 =
    "https://sample.vodobox.net/skate_phantom_flex_4k/skate_phantom_flex_4k.m3u8"
private const val EXAMPLE_VIDEO_URI_06 =
    "https://playertest.longtailvideo.com/adaptive/wowzaid3/playlist.m3u8"
private const val EXAMPLE_VIDEO_URI_09 = "https://assets.afcdn.com/video49/20210722/v_645516.m3u8"
private const val EXAMPLE_VIDEO_URI_11 =
    "https://nasatv-lh.akamaihd.net/i/NASA_101@319270/index_1000_av-p.m3u8"

private const val EXAMPLE_VIDEO_URI_12 =
    "https://ntv1.akamaized.net/hls/live/2014075/NASA-NTV1-HLS/master_2000.m3u8" // NASA TV LIVE

@Composable
fun CinemaVideoPlayer(modifier: Modifier = Modifier) {



    val context = LocalContext.current
    val exoPlayer = ExoPlayer.Builder(context).build()

    val mediaSource = remember(EXAMPLE_VIDEO_URI_04) {
        MediaItem.fromUri(EXAMPLE_VIDEO_URI_04)
    }

    LaunchedEffect(mediaSource) {
        exoPlayer.setMediaItem(mediaSource)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    AndroidView(
        factory = { ctx ->
            PlayerView(ctx).apply {
                player = exoPlayer
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}
