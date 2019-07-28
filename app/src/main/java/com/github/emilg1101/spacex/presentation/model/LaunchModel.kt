package com.github.emilg1101.spacex.presentation.model

import com.yandex.mapkit.geometry.Point

class LaunchModel(
    val flightNumber: Int,
    val missionName: String,
    val missionPatch: String,
    val launchTime: String,
    val launchPadId: String,
    val launchPadName: String,
    val launchPadCoords: Point,
    val details: String,
    val cores: List<CoreLaunchItemModel>,
    val payloads: List<PayloadLaunchItemModel>,
    val links: List<LinkLaunchItemModel>,
    val images: List<String>,
    val rocketId: String,
    val rocketName: String
)
