package com.github.emilg1101.spacex.data.repository.binder

import com.github.emilg1101.spacex.data.repository.*
import com.github.emilg1101.spacex.domain.repository.*
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

    @Binds
    abstract fun bindCapsulesRepository(capsulesRepositoryImpl: CapsulesRepositoryImpl): CapsulesRepository

    @Binds
    abstract fun bindMissionsRepository(missionsRepositoryImpl: MissionsRepositoryImpl): MissionsRepository

    @Binds
    abstract fun bindPayloadsRepository(payloadsRepositoryImpl: PayloadsRepositoryImpl): PayloadsRepository
}
