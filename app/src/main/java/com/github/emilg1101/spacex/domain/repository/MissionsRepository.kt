package com.github.emilg1101.spacex.domain.repository

import com.github.emilg1101.spacex.domain.entity.Mission
import io.reactivex.Single

interface MissionsRepository {

    fun getMissionById(id: String): Single<Mission>

    fun getMissions(): Single<List<Mission>>
}
