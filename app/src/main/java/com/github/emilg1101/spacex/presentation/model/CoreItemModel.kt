package com.github.emilg1101.spacex.presentation.model

import com.github.emilg1101.spacex.domain.entity.Core

class CoreItemModel(
    val serial: String
)

object CoreItemModelMapper {

    fun map(cores: List<Core>): List<CoreItemModel> {
        return cores.map { CoreItemModel(it.serial) }
    }
}
