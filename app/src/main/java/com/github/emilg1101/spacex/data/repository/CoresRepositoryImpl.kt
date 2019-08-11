package com.github.emilg1101.spacex.data.repository

import com.github.emilg1101.spacex.data.repository.mapper.CoreMapper
import com.github.emilg1101.spacex.data.spacexapi.request.SpaceXApiRequest
import com.github.emilg1101.spacex.domain.entity.Core
import com.github.emilg1101.spacex.domain.repository.CoresRepository
import io.reactivex.Single
import javax.inject.Inject

class CoresRepositoryImpl @Inject constructor() : CoresRepository {

    @field:Inject
    lateinit var api: SpaceXApiRequest

    override fun getCoreBySerial(serial: String): Single<Core> {
        TODO("not implemented")
    }

    override fun getCores(): Single<List<Core>> {
        return api.getAllCores()
            .toObservable()
            .flatMapIterable { list -> list }
            .map(CoreMapper::map)
            .toList()
    }
}
