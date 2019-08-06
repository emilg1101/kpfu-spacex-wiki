package com.github.emilg1101.spacex.presentation.model

class MissionModel(
    val id: String,
    val name: String,
    val manufacturers: String,
    val payloads: List<PayloadMissionItemModel>,
    val wikipedia: String,
    val website: String,
    val twitter: String,
    val details: String
)