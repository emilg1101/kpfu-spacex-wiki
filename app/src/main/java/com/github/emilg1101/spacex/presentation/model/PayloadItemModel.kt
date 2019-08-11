package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Payload

class PayloadItemModel(
    val id: String,
    val manufacturer: String,
    val nationality: String
)

object PayloadItemModelMapper {

    fun map(payloads: List<Payload>): List<PayloadItemModel> {
        return payloads.map {
            PayloadItemModel(
                it.serial,
                it.manufacturer ?: "",
                it.nationality ?: ""
            )
        }
    }
}
