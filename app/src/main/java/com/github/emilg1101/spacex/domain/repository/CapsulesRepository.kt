package com.github.emilg1101.spacex.domain.repository

import com.github.emilg1101.spacex.domain.entity.Capsule
import io.reactivex.Single

interface CapsulesRepository {

    fun getCapsuleBySerial(serial: String): Single<Capsule>

    fun getCapsules(): Single<List<Capsule>>
}
