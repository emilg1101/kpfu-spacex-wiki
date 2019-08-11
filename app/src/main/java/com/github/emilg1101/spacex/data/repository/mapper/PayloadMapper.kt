package com.github.emilg1101.spacex.data.repository.mapper

import com.github.emilg1101.spacex.domain.entity.Payload

typealias PayloadEntity = com.github.emilg1101.spacex.data.spacexapi.pojo.response.Payload

object PayloadMapper {

    fun map(entity: PayloadEntity): Payload {
        return Payload().apply {
            serial = entity.payloadId
            customers = entity.customers
            nationality = entity.nationality
            manufacturer = entity.manufacturer
            type = entity.payloadType
            mass = entity.payloadMassKg
            orbitParams = Payload.OrbitParams(
                entity.orbit,
                entity.orbitParams.referenceSystem,
                entity.orbitParams.regime,
                entity.orbitParams.longitude,
                entity.orbitParams.semiMajorAxisKm,
                entity.orbitParams.eccentricity,
                entity.orbitParams.periapsisKm,
                entity.orbitParams.apoapsisKm,
                entity.orbitParams.inclinationDeg,
                entity.orbitParams.periodMin,
                entity.orbitParams.lifespanYears,
                entity.orbitParams.epoch,
                entity.orbitParams.meanMotion,
                entity.orbitParams.raan
            )
        }
    }
}
