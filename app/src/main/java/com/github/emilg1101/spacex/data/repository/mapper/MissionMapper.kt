package com.github.emilg1101.spacex.data.repository.mapper

import com.github.emilg1101.spacex.domain.entity.Mission

typealias MissionEntity = com.github.emilg1101.spacex.data.spacexapi.pojo.response.Mission

object MissionMapper {

    fun map(entity: MissionEntity): Mission {
        return Mission().apply {
            name = entity.missionName
            id = entity.missionId
            manufacturers = entity.manufacturers
            payloads = entity.payloadIds
            wikipedia = entity.wikipedia
            website = entity.website
            twitter = entity.twitter
            description = entity.description
        }
    }
}
