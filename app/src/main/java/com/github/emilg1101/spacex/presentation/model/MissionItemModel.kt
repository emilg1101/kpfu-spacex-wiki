package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Mission

class MissionItemModel(
    val id: String,
    val name: String
)

object MissionItemModelMapper {

    fun map(missions: List<Mission>): List<MissionItemModel> {
        return missions.map { MissionItemModel(it.id, it.name) }
    }
}
