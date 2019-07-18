package com.github.emilg1101.spacex.presentation.ui

import com.github.emilg1101.spacex.presentation.ui.main.MainQualifier
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class CiceroneModule {

    @Singleton
    @Provides
    @MainQualifier
    fun provideMainRouter(): Router = Router()
}
