package com.example.amphibianapp.ui.screen

import android.net.http.HttpException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface AmphibianUiState {
    data class Success(val amphibians : String) : AmphibianUiState

    object Error : AmphibianUiState
    object Loading : AmphibianUiState
}


class AmphibianViewModel() : ViewModel() {

    var amphibianUiState : AmphibianUiState by mutableStateOf(AmphibianUiState.Loading)

    init {
        getAmphibianPhotos()
    }

    fun getAmphibianPhotos() {
        viewModelScope.launch {
            amphibianUiState = AmphibianUiState.Loading

            amphibianUiState = try {
                AmphibianUiState.Success("Success")
            } catch (e : IOException) {
                AmphibianUiState.Error
            }
//            catch (e : HttpException) {
//                AmphibianUiState.Error
//            }
        }
    }

    companion object {
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {

                // view model
                AmphibianViewModel()
            }
        }
    }
}