package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Mission

class MissionModel(
    val id: String,
    val name: String,
    val manufacturers: String,
    val payloads: List<PayloadMissionItemModel>,
    val wikipedia: String,
    val website: String,
    val twitter: String,
    val details: String
)

object MissionModelMapper {

    fun map(mission: Mission): MissionModel {
        return MissionModel(
            mission.id,
            mission.name,
            mission.manufacturers.joinToString(" "),
            mission.payloads.map { PayloadMissionItemModel(it) },
            mission.wikipedia ?: "",
            mission.website ?: "",
            mission.twitter ?: "",
            mission.description ?: ""
        )
    }
}
