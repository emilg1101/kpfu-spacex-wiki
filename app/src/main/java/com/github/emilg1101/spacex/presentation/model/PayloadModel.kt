package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Payload

class PayloadModel(
    val serial: String,
    val customers: String,
    val nationality: String,
    val manufacturer: String,
    val type: String,
    val mass: String,
    val reused: String,
    val orbitParams: List<OrbitParamModel>
)

object PayloadModelMapper {

    fun map(payload: Payload): PayloadModel {
        return PayloadModel(
            payload.serial,
            payload.customers.joinToString(" "),
            payload.nationality ?: "-",
            payload.manufacturer ?: "-",
            payload.type,
            payload.mass?.toString() ?: "-",
            payload.reused.toString(),
            listOf(
                OrbitParamModel("Orbit", payload.orbitParams?.orbit ?: "-"),
                OrbitParamModel("Reference system", payload.orbitParams?.referenceSystem ?: "-"),
                OrbitParamModel("Regime", payload.orbitParams?.regime ?: "-"),
                OrbitParamModel("Longitude", payload.orbitParams?.longtitude.toString()),
                OrbitParamModel("Semi Major Axis", payload.orbitParams?.semiMajorAxisKm?.toString() ?: "-"),
                OrbitParamModel("Eccentricity", payload.orbitParams?.eccentricity?.toString() ?: "-"),
                OrbitParamModel("Periapsis", payload.orbitParams?.periapsisKm?.toString() ?: "-"),
                OrbitParamModel("Apoapsis", payload.orbitParams?.apoapsisKm?.toString() ?: "-"),
                OrbitParamModel("Inclination deg", payload.orbitParams?.inclinationDeg?.toString() ?: "-"),
                OrbitParamModel("Period min", payload.orbitParams?.periodMin?.toString() ?: "-"),
                OrbitParamModel("Lifespan years", payload.orbitParams?.lifespanYears?.toString() ?: "-")
            )
        )
    }
}
