package com.example.amphibianapp.ui.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    amphibianUiState: AmphibianUiState,
    modififer : Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Text(text = "Success")
}

@Composable
fun LoadingScreen(modififer: Modifier = Modifier) {
    Text(text = "Loading...")
}

@Composable
fun ErrorScreen(modififer: Modifier = Modifier) {
    Text(text = "Error")
}

@Composable
fun ResultScreen(modififer: Modifier = Modifier) {
    Text(text = "Success \nHello World")
}