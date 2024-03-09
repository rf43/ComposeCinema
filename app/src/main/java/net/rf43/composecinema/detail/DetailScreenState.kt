package net.rf43.composecinema.detail

data class DetailScreenState(
    val loadState: DetailScreenLoadState,
    val screenTitle: String,
    val description: String,
    val imageUrl: String,
)

enum class DetailScreenLoadState {
    Loading,
    Loaded,
    Error
}
