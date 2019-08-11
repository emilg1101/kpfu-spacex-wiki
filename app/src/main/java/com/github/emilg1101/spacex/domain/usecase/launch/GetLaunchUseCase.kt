package com.github.emilg1101.spacex.domain.usecase.launch

import com.github.emilg1101.spacex.domain.entity.Launch
import com.github.emilg1101.spacex.domain.repository.LaunchesRepository
import io.reactivex.Single
import javax.inject.Inject

class GetLaunchUseCase @Inject constructor() {

    @field:Inject
    lateinit var launchesRepository: LaunchesRepository

    fun getLaunch(flightNumber: Int): Single<Launch> {
        return launchesRepository.getLaunch(flightNumber)
    }
}