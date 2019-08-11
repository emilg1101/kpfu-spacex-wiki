package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Rocket

class RocketItemModel(
    val id: String,
    val name: String,
    val description: String
)

object RocketItemModelMapper {

    fun map(rockets: List<Rocket>): List<RocketItemModel> {
        return rockets.map { RocketItemModel(it.id, it.name, it.description) }
    }
}
