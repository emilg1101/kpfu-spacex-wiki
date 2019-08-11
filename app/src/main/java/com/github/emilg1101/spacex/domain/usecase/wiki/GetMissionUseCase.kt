package com.github.emilg1101.spacex.domain.usecase.wiki

import com.github.emilg1101.spacex.domain.entity.Mission
import com.github.emilg1101.spacex.domain.repository.MissionsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetMissionUseCase @Inject constructor() {

    @field:Inject
    lateinit var missionsRepository: MissionsRepository

    fun getMission(id: String): Single<Mission> {
        return missionsRepository.getMissionById(id)
    }
}
