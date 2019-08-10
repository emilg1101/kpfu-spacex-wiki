package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Launch
import java.text.SimpleDateFormat

class UpcomingLaunchItemModel(
    val patch: String,
    val mission: String,
    val launchTime: String,
    val launchTimeLeft: String,
    val flightNumber: Int
)

object UpcomingLaunchItemModelMapper {
    fun map(launches: List<Launch>): List<UpcomingLaunchItemModel> {
        val format = SimpleDateFormat("dd MMM`yy-hh:mm")
        return launches.map { launch ->
            UpcomingLaunchItemModel(
                launch.patch ?: "",
                launch.missionName,
                format.format(launch.launchDate),
                "",
                launch.flightNumber
            )
        }
    }
}
