package com.example.amphibianapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibianapp.R
import com.example.amphibianapp.model.AmphibianPhoto

@Composable
fun HomeScreen(
    amphibianUiState: AmphibianUiState,
    modififer : Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    retryAction: () -> Unit
) {
    when (amphibianUiState) {
        is AmphibianUiState.Loading -> LoadingScreen(
            modififer = modififer.fillMaxSize()
        )
        is AmphibianUiState.Success -> AmphibianPhotoGridScreen(
            photos = amphibianUiState.amphibians,
            modififer
        )

        is AmphibianUiState.Error -> ErrorScreen(
            retryAction = retryAction,
            modififer = modififer.fillMaxSize()
        )

    }
}

@Composable
fun LoadingScreen(modififer: Modifier = Modifier) {
    Text(text = stringResource(id = R.string.loading))
}

@Composable
fun ErrorScreen(
    modififer: Modifier = Modifier,
    retryAction: () -> Unit
    ) {
    Column (
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modififer
    ) {
        Text(text = stringResource(id = R.string.fetch_error))
        Button(onClick = retryAction) {
            Text(text = stringResource(id = R.string.retry))
        }
    }
}

@Composable
fun ResultScreen(modififer: Modifier = Modifier) {
    Text(text = "Success \nHello World")
}

@Composable
fun AmphibianPhotoCard(
    photo: AmphibianPhoto,
    modififer: Modifier = Modifier
) {
    Card (
        modifier = modififer
            .padding(horizontal = 0.dp, vertical = 12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modififer.fillMaxWidth().padding(4.dp, 12.dp)
            ) {
            Text(
                text = "${photo.name} (${photo.type})",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
        }
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(photo.imgSrc)
                .crossfade(true)
                .build()
            , 
            contentDescription = stringResource(id = R.string.amphibians_photo),
            contentScale = ContentScale.Crop,
            error = painterResource(id = R.drawable.ic_broken_image),
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = photo.description
        )
    }
}

@Composable
fun AmphibianPhotoGridScreen(
    photos: List<AmphibianPhoto>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(300.dp),
        modifier = modifier.padding(horizontal = 4.dp),
        contentPadding = contentPadding

    ) {

        items(photos) {photo ->
            AmphibianPhotoCard(photo = photo)
        }
    }
}