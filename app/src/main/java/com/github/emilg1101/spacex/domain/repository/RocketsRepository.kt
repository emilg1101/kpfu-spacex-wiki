package com.github.emilg1101.spacex.domain.repository

import com.github.emilg1101.spacex.domain.entity.Rocket
import io.reactivex.Single

interface RocketsRepository {

    fun getRocket(id: String): Single<Rocket>

    fun getRockets(): Single<List<Rocket>>
}
