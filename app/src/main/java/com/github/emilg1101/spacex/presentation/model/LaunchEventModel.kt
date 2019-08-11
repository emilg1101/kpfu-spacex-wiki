package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Launch

class LaunchEventModel(
    val time: Long,
    val title: String,
    val description: String,
    val location: String
)

object LaunchEventModelMapper {

    fun map(launch: Launch): LaunchEventModel {
        return LaunchEventModel(
            launch.launchDate.time,
            launch.missionName,
            launch.details ?: "",
            launch.siteName
        )
    }
}
