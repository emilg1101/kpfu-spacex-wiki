package com.github.emilg1101.spacex.presentation.ui.main.container.wiki

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
}
