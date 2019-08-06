package com.github.emilg1101.spacex.presentation.model

class PayloadModel(
    val serial: String,
    val customers: String,
    val nationality: String,
    val manufacturer: String,
    val type: String,
    val mass: String,
    val reused: String,
    val orbitParams: List<OrbitParamModel>
)