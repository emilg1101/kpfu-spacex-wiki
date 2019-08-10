package com.github.emilg1101.spacex.data.repository.binder

import com.github.emilg1101.spacex.data.repository.LaunchesRepositoryImpl
import com.github.emilg1101.spacex.domain.repository.LaunchesRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryBinder {

    @Binds
    abstract fun bindLaunchesRepository(launchesRepositoryImpl: LaunchesRepositoryImpl): LaunchesRepository
}
