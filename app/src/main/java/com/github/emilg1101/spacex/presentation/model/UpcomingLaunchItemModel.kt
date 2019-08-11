package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Launch
import com.github.emilg1101.spacex.presentation.util.format

class UpcomingLaunchItemModel(
    val patch: String,
    val mission: String,
    val launchTime: String,
    val launchTimeLeft: String,
    val flightNumber: Int
)

object UpcomingLaunchItemModelMapper {
    fun map(launches: List<Launch>): List<UpcomingLaunchItemModel> {
        return launches.map { launch ->
            UpcomingLaunchItemModel(
                launch.patch ?: "",
                launch.missionName,
                launch.launchDate.format(),
                "",
                launch.flightNumber
            )
        }
    }
}
