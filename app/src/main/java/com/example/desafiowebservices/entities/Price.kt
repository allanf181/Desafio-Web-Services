package com.example.desafiowebservices.entities

import kotlinx.serialization.Serializable

@Serializable
data class Price(val type: String, val price: Double)