package com.github.emilg1101.spacex.presentation

import com.github.emilg1101.spacex.presentation.ui.CiceroneModule
import com.github.emilg1101.spacex.presentation.ui.RootBuilder
import dagger.Module

@Module(includes = [RootBuilder::class, CiceroneModule::class])
class PresentationModule {

}
