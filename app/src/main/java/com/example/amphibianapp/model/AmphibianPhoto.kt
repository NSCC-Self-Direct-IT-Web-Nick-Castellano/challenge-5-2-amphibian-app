package com.example.amphibianapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AmphibianPhoto(
    val id : String,
    val type: String,
    val description: String,
    @SerialName("img_src")
    val imgSrc :  String
)
