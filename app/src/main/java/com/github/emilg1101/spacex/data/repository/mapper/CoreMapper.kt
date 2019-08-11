package com.github.emilg1101.spacex.data.repository.mapper

import com.github.emilg1101.spacex.domain.entity.Core

typealias CoreEntity = com.github.emilg1101.spacex.data.spacexapi.pojo.response.Core

object CoreMapper {

    fun map(entity: CoreEntity): Core {
        return Core().apply {
            serial = entity.coreSerial
            block = entity.block
            status = entity.status
            missions = entity.missions.map { Core.Mission(it.name, it.flight) }
            details = entity.details
            reuseCount = entity.reuseCount
            waterLanding = entity.waterLanding
            rtlsAttempts = entity.rtlsAttempts
            rtlsLandings = entity.rtlsLandings
            asdsAttempts = entity.asdsAttempts
            asdsLandings = entity.asdsLandings
        }
    }
}
