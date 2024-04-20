package net.rf43.composecinema.common

data class MovieItem(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val isFavorite: Boolean = false,
)
