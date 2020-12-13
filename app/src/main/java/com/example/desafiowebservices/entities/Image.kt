package com.example.desafiowebservices.entities

import kotlinx.serialization.Serializable

@Serializable
data class Image(val path: String, val extension: String) {
    fun getFullUrl(): String{
        return "$path.$extension".replace("http", "https")
    }
}