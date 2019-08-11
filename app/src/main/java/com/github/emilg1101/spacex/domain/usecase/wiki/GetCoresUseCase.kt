package com.github.emilg1101.spacex.domain.usecase.wiki

import com.github.emilg1101.spacex.domain.entity.Core
import com.github.emilg1101.spacex.domain.repository.CoresRepository
import io.reactivex.Single
import javax.inject.Inject

class GetCoresUseCase @Inject constructor() {

    @field:Inject
    lateinit var coresRepository: CoresRepository

    fun getCores(): Single<List<Core>> {
        return coresRepository.getCores()
    }
}
