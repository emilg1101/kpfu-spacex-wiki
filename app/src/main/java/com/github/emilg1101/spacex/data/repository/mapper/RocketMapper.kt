package com.github.emilg1101.spacex.data.repository.mapper

import com.github.emilg1101.spacex.domain.entity.Rocket

typealias RocketEntity = com.github.emilg1101.spacex.data.spacexapi.pojo.response.Rocket

object RocketMapper {

    fun map(entity: RocketEntity): Rocket {
        return Rocket().apply {
            id = entity.rocketId
            name = entity.rocketName
            description = entity.description
            firstFlight = entity.firstFlight
            costPerLaunch = entity.costPerLaunch
            country = entity.country
            company = entity.company
            engine = entity.engines.type
            stages = entity.stages
            boosters = entity.boosters
            successRate = entity.successRatePct
            height = entity.height.meters
            diameter = entity.diameter.meters
            mass = entity.mass.kg
            wikipedia = entity.wikipedia
        }
    }
}
