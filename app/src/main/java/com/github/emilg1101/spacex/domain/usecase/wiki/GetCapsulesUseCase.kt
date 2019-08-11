package com.github.emilg1101.spacex.domain.usecase.wiki

import com.github.emilg1101.spacex.domain.entity.Capsule
import com.github.emilg1101.spacex.domain.repository.CapsulesRepository
import io.reactivex.Single
import javax.inject.Inject

class GetCapsulesUseCase @Inject constructor() {

    @field:Inject
    lateinit var capsulesRepository: CapsulesRepository

    fun getCapsules(): Single<List<Capsule>> {
        return capsulesRepository.getCapsules()
    }
}
