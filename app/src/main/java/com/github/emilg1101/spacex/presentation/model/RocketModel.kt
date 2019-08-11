package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Rocket

class RocketModel(
    val name: String,
    val costPerLaunch: String,
    val firstFlight: String,
    val country: String,
    val company: String,
    val stages: String,
    val boosters: String,
    val successRate: String,
    val height: String,
    val diameter: String,
    val mass: String,
    val engine: String,
    val wikipedia: String,
    val description: String
)

object RocketModelMapper {

    fun map(rocket: Rocket): RocketModel {
        return RocketModel(
            rocket.name,
            rocket.costPerLaunch.toString(),
            rocket.firstFlight,
            rocket.country,
            rocket.company,
            rocket.stages.toString(),
            rocket.boosters.toString(),
            rocket.successRate.toString(),
            rocket.height.toString(),
            rocket.diameter.toString(),
            rocket.mass.toString(),
            rocket.engine,
            rocket.wikipedia,
            rocket.description
        )
    }
}
