package com.github.emilg1101.spacex.data.repository

import com.github.emilg1101.spacex.data.repository.mapper.CapsuleMapper
import com.github.emilg1101.spacex.data.spacexapi.request.SpaceXApiRequest
import com.github.emilg1101.spacex.domain.entity.Capsule
import com.github.emilg1101.spacex.domain.repository.CapsulesRepository
import io.reactivex.Single
import javax.inject.Inject

class CapsulesRepositoryImpl @Inject constructor() : CapsulesRepository {

    @field:Inject
    lateinit var api: SpaceXApiRequest

    override fun getCapsuleBySerial(serial: String): Single<Capsule> {
        TODO("not implemented")
    }

    override fun getCapsules(): Single<List<Capsule>> {
        return api.getAllCapsules()
            .toObservable()
            .flatMapIterable { list -> list }
            .map(CapsuleMapper::map)
            .toList()
    }
}
