package com.example.desafiowebservices.entities

import kotlinx.serialization.Serializable

@Serializable
data class ApiData(val results: List<Comic>)