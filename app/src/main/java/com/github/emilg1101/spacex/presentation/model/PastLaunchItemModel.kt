package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Launch
import java.text.SimpleDateFormat

class PastLaunchItemModel(
    val patch: String,
    val mission: String,
    val launchTime: String,
    val flightNumber: Int
)

object PastLaunchItemModelMapper {
    fun map(launches: List<Launch>): List<PastLaunchItemModel> {
        val format = SimpleDateFormat("dd MMM`yy-hh:mm")
        return launches.map { launch ->
            PastLaunchItemModel(
                launch.patch ?: "",
                launch.missionName,
                format.format(launch.launchDate),
                launch.flightNumber
            )
        }
    }
}
