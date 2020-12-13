package com.example.desafiowebservices.entities

import kotlinx.serialization.Serializable
import java.text.DecimalFormat

@Serializable
data class Comic(val issueNumber: Double, val title: String, val description: String, val pageCount: Int, val dates: List<Date>, val prices: List<Price>, val thumbnail: Image, val images: List<Image> ){
    fun getFormattedIssueNumber() : String{
        return "#"+DecimalFormat("0.#").format(issueNumber)
    }
}