package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Capsule
import com.github.emilg1101.spacex.presentation.util.format

class CapsuleModel(
    val serial: String,
    val status: String,
    val launchTime: String,
    val missions: List<MissionItemShortModel>,
    val landings: String,
    val type: String,
    val details: String,
    val reuse: String
)

object CapsuleModelMapper {

    fun map(capsule: Capsule): CapsuleModel {
        return CapsuleModel(
            capsule.serial,
            capsule.status,
            capsule.launch?.format() ?: "",
            capsule.missions.map { MissionItemShortModel(it.name, it.flightNumber) },
            capsule.landings.toString(),
            capsule.type,
            capsule.details ?: "",
            capsule.reuse.toString()
        )
    }
}
