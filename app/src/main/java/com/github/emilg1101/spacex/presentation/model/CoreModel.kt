package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Core
import com.github.emilg1101.spacex.presentation.util.format

class CoreModel(
    val serial: String,
    val block: String,
    val status: String,
    val launchTime: String,
    val missions: List<MissionItemShortModel>,
    val reuseCount: Int,
    val rtlsAttempts: Int,
    val rtlsLandings: Int,
    val asdsAttempts: Int,
    val asdsLandings: Int,
    val waterLanding: String,
    val details: String
)

object CoreModelMapper {

    fun map(core: Core): CoreModel {
        return CoreModel(
            core.serial,
            core.block ?: "-",
            core.status,
            core.launch?.format() ?: "-",
            core.missions.map { MissionItemShortModel(it.name, it.flightNumber) },
            core.reuseCount,
            core.rtlsAttempts,
            core.rtlsLandings,
            core.asdsAttempts,
            core.asdsLandings,
            core.waterLanding.toString(),
            core.details ?: ""
        )
    }
}
