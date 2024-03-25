package com.example.amphibianapp.data

import com.example.amphibianapp.model.AmphibianPhoto
import com.example.amphibianapp.network.AmphibianApiService

interface AmphibianPhotosRepository {
    suspend fun getAmphibianPhotos() : List<AmphibianPhoto>
}

class NetworkAmphibianPhotosRepository(
    private val amphibianApiService: AmphibianApiService
) : AmphibianPhotosRepository {
    override suspend fun getAmphibianPhotos(): List<AmphibianPhoto> =
        amphibianApiService.getPhotos()

}