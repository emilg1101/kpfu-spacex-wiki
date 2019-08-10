package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Launch

class CoreLaunchItemModel(
    val coreSerial: String,
    val landingVehicle: String,
    val landingType: String,
    val reused: Boolean,
    val success: Boolean
)

object CoreLaunchItemModelMapper {
    fun map(core: Launch.Core): CoreLaunchItemModel {
        return CoreLaunchItemModel(
            core.serial,
            core.landingVehicle ?: "-",
            core.landingType ?: "-",
            core.reused,
            core.landingSuccessful ?: false
        )
    }
}
