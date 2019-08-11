package com.github.emilg1101.spacex.data.repository.mapper

import com.github.emilg1101.spacex.domain.entity.Capsule

typealias CapsuleEntity = com.github.emilg1101.spacex.data.spacexapi.pojo.response.Capsule

object CapsuleMapper {

    fun map(entity: CapsuleEntity): Capsule {
        return Capsule().apply {
            serial = entity.capsuleSerial
            id = entity.capsuleId
            status = entity.status
            launch = entity.originalLaunch
            missions = entity.missions.map { Capsule.Mission(it.name, it.flight) }
            landings = entity.landings
            type = entity.type
            details = entity.details
            reuse = entity.reuseCount
        }
    }
}
