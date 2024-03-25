@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.amphibianapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibianapp.R
import com.example.amphibianapp.ui.screen.AmphibianViewModel
import com.example.amphibianapp.ui.screen.HomeScreen

@ExperimentalMaterial3Api
@Composable
fun AmphibianAppScaffold() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { AmphibianTopNavBar(scrollBehavior = scrollBehavior) }
    ) {
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 8.dp)
        ) {
            val amphibianViewModel : AmphibianViewModel = viewModel(
                factory = AmphibianViewModel.Factory
            )

            HomeScreen(
                amphibianUiState = amphibianViewModel.amphibianUiState,
                contentPadding = it,
                retryAction = amphibianViewModel::getAmphibianPhotos
            )
        }
    }
}

@Composable
fun AmphibianTopNavBar(
    scrollBehavior: TopAppBarScrollBehavior,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            )
        },
        scrollBehavior = scrollBehavior,
        modifier = modifier
            .fillMaxWidth()
    )
}