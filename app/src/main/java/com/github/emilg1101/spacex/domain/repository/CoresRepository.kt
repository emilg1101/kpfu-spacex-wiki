package com.github.emilg1101.spacex.domain.repository

import com.github.emilg1101.spacex.domain.entity.Core
import io.reactivex.Single

interface CoresRepository {

    fun getCoreBySerial(serial: String): Single<Core>

    fun getCores(): Single<List<Core>>
}
