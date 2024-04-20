package net.rf43.composecinema.common

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

val movieCardList: List<MovieItem> = listOf(
    MovieItem(
        id = "",
        title = "Big Buck Bunny",
        description = "Big Buck Bunny is a short computer-animated comedy film, featuring animals of the forest.",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/c/c5/Big_buck_bunny_poster_big.jpg"
    ),
    MovieItem(
        id = "",
        title = "Sintel",
        description = "A wandering warrior finds an unlikely friend in the form of a young " +
                "dragon. The two develop a close bond, until one day the dragon is snatched " +
                "away. She then sets out on a relentless quest to reclaim her friend, finding " +
                "in the end that her quest exacts a far greater price than she had ever imagined.",
        imageUrl = "https://image.tmdb.org/t/p/w1280/4BMG9hk9NvSBeQvC82sVmVRK140.jpg"
    ),
    MovieItem(
        id = "",
        title = "Tears of Steel",
        description = "The film’s premise is about a group of warriors and scientists, who " +
                "gathered at the “Oude Kerk” in Amsterdam to stage a crucial event from the " +
                "past, in a desperate attempt to rescue the world from destructive robots.",
        imageUrl = "https://image.tmdb.org/t/p/w1280/vamqM0xH998F8B9WicVAkWP6E9N.jpg"
    ),
    MovieItem(
        id = "",
        title = "Cosmos Laundromat",
        description = "On a desolate island, suicidal sheep Franck meets his fate in a quirky " +
                "salesman, who offers him the gift of a lifetime. Little does he know that he " +
                "can only handle this much 'lifetime'.",
        imageUrl = "https://image.tmdb.org/t/p/w1280/5ZXi0oitpEgAdoJglFTc5SZF9nt.jpg"
    ),
    MovieItem(
        id = "",
        title = "Alike",
        description = "In a busy life, Copi is a father who tries to teach the right way to " +
                "his son, Paste. But - What is the correct path?",
        imageUrl = "https://image.tmdb.org/t/p/w1280/eWybsTSw5EtLuhnoJrQewiWJFzB.jpg"
    ),
    MovieItem(
        id = "",
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
        id = "",
        title = "Tiki Bar Funeral Home",
        description = "After 12 years, a failing actress returns to her hometown to attend her " +
                "ex-boyfriend's tiki-themed funeral where she plans to tell his best friend " +
                "she's in love with him, only when she arrives she finds her ex still alive.",
        imageUrl = "https://image.tmdb.org/t/p/w1280/vuu03gGzCHUJ0i1ItAUy9FbFBBf.jpg"
    )
)
