package com.github.emilg1101.spacex.domain.usecase.wiki

import com.github.emilg1101.spacex.domain.entity.Core
import com.github.emilg1101.spacex.domain.repository.CoresRepository
import io.reactivex.Single
import javax.inject.Inject

class GetCoreUseCase @Inject constructor() {

    @field:Inject
    lateinit var coresRepository: CoresRepository

    fun getCore(serial: String): Single<Core> {
        return coresRepository.getCoreBySerial(serial)
    }
}
