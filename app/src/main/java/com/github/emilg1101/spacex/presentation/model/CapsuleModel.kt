package com.github.emilg1101.spacex.presentation.model

class CapsuleModel(
    val serial: String,
    val status: String,
    val launchTime: String,
    val missions: List<MissionItemShortModel>,
    val landings: String,
    val type: String,
    val details: String,
    val reuse: String
)
