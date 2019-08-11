package com.github.emilg1101.spacex.domain.usecase.wiki

import com.github.emilg1101.spacex.domain.entity.Rocket
import com.github.emilg1101.spacex.domain.repository.RocketsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetRocketUseCase @Inject constructor() {

    @field:Inject
    lateinit var rocketsRepository: RocketsRepository

    fun getRocket(id: String): Single<Rocket> {
        return rocketsRepository.getRocket(id)
    }
}
