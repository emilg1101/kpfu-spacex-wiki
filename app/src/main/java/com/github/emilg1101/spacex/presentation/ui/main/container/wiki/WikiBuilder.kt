package com.github.emilg1101.spacex.presentation.ui.main.container.wiki

import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.CapsulesFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.CapsulesModule
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.CapsulesScope
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.capsule.CapsuleFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.capsule.CapsuleModule
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.capsule.CapsuleScope
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.content.ContentFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.content.ContentModule
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.content.ContentScope
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores.CoresFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores.CoresModule
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores.CoresScope
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.MissionsFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.MissionsModule
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.MissionsScope
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.mission.MissionFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.mission.MissionModule
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.mission.MissionScope
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.PayloadsFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.PayloadsModule
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.PayloadsScope
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.payload.PayloadFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.payload.PayloadModule
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.payload.PayloadScope
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

    @ContributesAndroidInjector(modules = [CapsuleModule::class])
    @CapsuleScope
    abstract fun provideCapsuleFragment(): CapsuleFragment

    @ContributesAndroidInjector(modules = [MissionsModule::class])
    @MissionsScope
    abstract fun provideMissionsFragment(): MissionsFragment

    @ContributesAndroidInjector(modules = [MissionModule::class])
    @MissionScope
    abstract fun provideMissionFragment(): MissionFragment

    @ContributesAndroidInjector(modules = [PayloadsModule::class])
    @PayloadsScope
    abstract fun providePayloadsFragment(): PayloadsFragment

    @ContributesAndroidInjector(modules = [PayloadModule::class])
    @PayloadScope
    abstract fun providePayloadFragment(): PayloadFragment

    @ContributesAndroidInjector(modules = [CoresModule::class])
    @CoresScope
    abstract fun provideCoresFragment(): CoresFragment
}
