package com.example.amphibianapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibianapp.ui.screen.AmphibianViewModel
import com.example.amphibianapp.ui.screen.HomeScreen
import com.example.amphibianapp.ui.theme.AmphibianAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphibianAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val amphibianViewModel : AmphibianViewModel = viewModel(
                        factory = AmphibianViewModel.Factory
                    )
                    HomeScreen(amphibianUiState = amphibianViewModel.amphibianUiState)
                }
            }
        }
    }
}
