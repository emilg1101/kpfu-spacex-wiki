package com.github.emilg1101.spacex.domain.usecase.wiki

import com.github.emilg1101.spacex.domain.entity.Payload
import com.github.emilg1101.spacex.domain.repository.PayloadsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetPayloadUseCase @Inject constructor() {

    @field:Inject
    lateinit var payloadsRepository: PayloadsRepository

    fun getPayload(id: String): Single<Payload> {
        return payloadsRepository.getPayloadById(id)
    }
}
