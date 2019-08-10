package com.github.emilg1101.spacex.data.repository.mapper

import com.github.emilg1101.spacex.domain.entity.Launch

typealias LaunchEntity = com.github.emilg1101.spacex.data.spacexapi.pojo.response.Launch

object LaunchMapper {
    fun map(entity: LaunchEntity): Launch {
        return Launch().apply {
            flightNumber = entity.flightNumber
            missionName = entity.missionName
            launchDate = entity.launchDateLocal
            patch = entity.links.missionPatch
        }
    }
}