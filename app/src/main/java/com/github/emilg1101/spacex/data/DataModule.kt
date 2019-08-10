package com.github.emilg1101.spacex.data

import com.github.emilg1101.spacex.data.repository.binder.RepositoryBinder
import com.github.emilg1101.spacex.data.spacexapi.SpaceXApiModule
import dagger.Module

@Module(includes = [SpaceXApiModule::class, RepositoryBinder::class])
class DataModule
