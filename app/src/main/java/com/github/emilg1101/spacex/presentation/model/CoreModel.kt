package com.github.emilg1101.spacex.presentation.model

class CoreModel(
    val serial: String,
    val block: String,
    val status: String,
    val launchTime: String,
    val missions: List<MissionItemShortModel>,
    val reuseCount: Int,
    val rtlsAttempts: Int,
    val rtlsLandings: Int,
    val asdsAttempts: Int,
    val asdsLandings: Int,
    val waterLanding: String,
    val details: String
)
