package net.rf43.composecinema.detail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DetailScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState>
        get() = _uiState

    init {
        _uiState.value = DetailUiState(
            screenTitle = "Aqua Teen Hunger Force",
            description = "The surreal adventures of three anthropomorphic fast food items: " +
                    "Master Shake, Frylock and Meatwad, and their human nextdoor neighbor, " +
                    "Carl Brutananadilewski.",
        )
    }
}