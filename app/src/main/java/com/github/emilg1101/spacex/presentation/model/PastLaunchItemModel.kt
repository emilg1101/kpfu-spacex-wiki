package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Launch
import com.github.emilg1101.spacex.presentation.util.format

class PastLaunchItemModel(
    val patch: String,
    val mission: String,
    val launchTime: String,
    val flightNumber: Int
)

object PastLaunchItemModelMapper {
    fun map(launches: List<Launch>): List<PastLaunchItemModel> {
        return launches.map { launch ->
            PastLaunchItemModel(
                launch.patch ?: "",
                launch.missionName,
                launch.launchDate.format(),
                launch.flightNumber
            )
        }
    }
}
