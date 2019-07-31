package com.github.emilg1101.spacex.presentation.ui.main.container.wiki

import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.CapsulesFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.CapsulesModule
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.CapsulesScope
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.content.ContentFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.content.ContentModule
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.content.ContentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class WikiBuilder {

    @ContributesAndroidInjector(modules = [ContentModule::class])
    @ContentScope
    abstract fun provideContentFragment(): ContentFragment

    @ContributesAndroidInjector(modules = [CapsulesModule::class])
    @CapsulesScope
    abstract fun provideCapsulesFragment(): CapsulesFragment
}
