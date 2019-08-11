package com.github.emilg1101.spacex.domain.usecase.wiki

import com.github.emilg1101.spacex.domain.entity.Capsule
import com.github.emilg1101.spacex.domain.repository.CapsulesRepository
import io.reactivex.Single
import javax.inject.Inject

class GetCapsuleUseCase @Inject constructor() {

    @field:Inject
    lateinit var capsulesRepository: CapsulesRepository

    fun getCapsule(serial: String): Single<Capsule> {
        return capsulesRepository.getCapsuleBySerial(serial)
    }
}
