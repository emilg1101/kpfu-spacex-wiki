package com.github.emilg1101.spacex.data.repository.binder

import com.github.emilg1101.spacex.data.repository.CompanyInfoRepositoryImpl
import com.github.emilg1101.spacex.data.repository.LaunchesRepositoryImpl
import com.github.emilg1101.spacex.data.repository.TimelineRepositoryImpl
import com.github.emilg1101.spacex.domain.repository.CompanyInfoRepository
import com.github.emilg1101.spacex.domain.repository.LaunchesRepository
import com.github.emilg1101.spacex.domain.repository.TimelineRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryBinder {

    @Binds
    abstract fun bindLaunchesRepository(launchesRepositoryImpl: LaunchesRepositoryImpl): LaunchesRepository

    @Binds
    abstract fun bindTimelineRepository(timelineRepositoryImpl: TimelineRepositoryImpl): TimelineRepository

    @Binds
    abstract fun bindCompanyInfoRepository(companyInfoRepositoryImpl: CompanyInfoRepositoryImpl): CompanyInfoRepository
}
