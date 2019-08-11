package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Capsule

class CapsuleItemModel(
    val serial: String,
    val status: String,
    val type: String
)

object CapsuleItemModelMapper {

    fun map(capsules: List<Capsule>): List<CapsuleItemModel> {
        return capsules.map {
            CapsuleItemModel(
                it.serial,
                it.status,
                it.type
            )
        }
    }
}
