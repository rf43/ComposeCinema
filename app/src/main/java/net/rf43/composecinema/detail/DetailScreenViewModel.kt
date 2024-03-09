package net.rf43.composecinema.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

val detailUiState = DetailUiState(
    screenTitle = "Aqua Teen Hunger Force",
    description = "The surreal adventures of three anthropomorphic fast food items: Master Shake, Frylock and Meatwad, and their human nextdoor neighbor, Carl Brutananadilewski.",
    imageUrl = "https://image.tmdb.org/t/p/w1280/jCWOkfMLsT2sGHadCkmR65MWtJu.jpg"
)

class DetailScreenViewModel : ViewModel() {
    private val _uiState = mutableStateOf(detailUiState)
    val uiState: State<DetailUiState> = _uiState
}