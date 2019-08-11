package com.github.emilg1101.spacex.presentation.model

class PayloadLaunchItemModel(
    val payloadId: String
)

object PayloadLaunchItemModelMapper {
    fun map(payload: String): PayloadLaunchItemModel {
        return PayloadLaunchItemModel(payload)
    }
}
