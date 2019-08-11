package com.github.emilg1101.spacex.data.repository

import com.github.emilg1101.spacex.data.repository.mapper.PayloadMapper
import com.github.emilg1101.spacex.data.spacexapi.request.SpaceXApiRequest
import com.github.emilg1101.spacex.domain.entity.Payload
import com.github.emilg1101.spacex.domain.repository.PayloadsRepository
import io.reactivex.Single
import javax.inject.Inject

class PayloadsRepositoryImpl @Inject constructor(): PayloadsRepository {

    @field:Inject
    lateinit var api: SpaceXApiRequest

    override fun getPayloadById(id: String): Single<Payload> {
        TODO("not implemented")
    }

    override fun getPayloads(): Single<List<Payload>> {
        return api.getAllPayloads()
            .toObservable()
            .flatMapIterable { list -> list }
            .map(PayloadMapper::map)
            .toList()
    }
}
