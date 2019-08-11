package com.github.emilg1101.spacex.domain.entity

import java.util.*

class Payload {
    var serial: String = ""
    var customers: List<String> = listOf()
    var nationality: String? = null
    var manufacturer: String? = null
    var type: String = ""
    var reused: Boolean = false
    var mass: Double? = null
    var orbitParams: OrbitParams? = null

    class OrbitParams(
        val orbit: String,
        val referenceSystem: String?,
        val regime: String?,
        val longtitude: Double,
        val semiMajorAxisKm: Double?,
        val eccentricity: Double?,
        val periapsisKm: Double?,
        val apoapsisKm: Double?,
        val inclinationDeg: Double?,
        val periodMin: Double?,
        val lifespanYears: Double?,
        val epoch: Date?,
        val meanMotion: Double?,
        val raan: Double?
    )
}