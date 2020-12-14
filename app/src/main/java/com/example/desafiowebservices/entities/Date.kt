package com.example.desafiowebservices.entities

import kotlinx.serialization.Serializable
import java.text.SimpleDateFormat

@Serializable
data class Date(val type: String, val date: String){
    fun getFormattedDate(): String{
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
        return SimpleDateFormat("MMMM dd, yyyy").format(format.parse(date))
    }
}