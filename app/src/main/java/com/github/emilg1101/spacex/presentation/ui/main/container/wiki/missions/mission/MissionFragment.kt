package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.mission

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.base.HasToolbar
import kotlinx.android.synthetic.main.layout_toolbar.*

class MissionFragment : BaseFragment(), MissionView, HasToolbar {

    @ProvidePresenter
    fun providePresenter(): MissionPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: MissionPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<MissionPresenter>

    override val contentLayout = R.layout.fragment_mission

    override fun getToolbar(): Toolbar = toolbar

    fun getMissionId(): String = arguments?.getString(MISSION_ID) ?: throw IllegalArgumentException()

    companion object {

        val TAG = MissionFragment::class.java.name

        private const val MISSION_ID = "mission_id"

        fun newInstance(missionId: String) = MissionFragment().also {
            it.arguments = Bundle().apply {
                putString(MISSION_ID, missionId)
            }
        }
    }
}
