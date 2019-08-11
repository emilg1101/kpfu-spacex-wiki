package com.github.emilg1101.spacex.domain.repository

import com.github.emilg1101.spacex.domain.entity.Payload
import io.reactivex.Single

interface PayloadsRepository {

    fun getPayloadById(id: String): Single<Payload>

    fun getPayloads(): Single<List<Payload>>
}
