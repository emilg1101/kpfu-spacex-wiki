package com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.base.HasToolbar
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import kotlinx.android.synthetic.main.fragment_launch.*
import kotlinx.android.synthetic.main.layout_toolbar.toolbar
import javax.inject.Inject
import javax.inject.Provider

class LaunchFragment : BaseFragment(), LaunchView, HasToolbar {

    @ProvidePresenter
    fun providePresenter(): LaunchPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: LaunchPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<LaunchPresenter>

    override val contentLayout = R.layout.fragment_launch

    override fun getToolbar(): Toolbar = toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.initialize(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val style = "[" +
                "  {" +
                "    \"featureType\" : \"all\"," +
                "    \"stylers\" : {" +
                "      \"hue\" : \"1\"," +
                "      \"saturation\" : \"0.3\"," +
                "      \"lightness\" : \"-0.7\"" +
                "    }" +
                "  }" +
                "]"
        mapview.map.setMapStyle(style)
        mapview.map.move(
                CameraPosition(Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
                Animation(Animation.Type.SMOOTH, 0f),
                null)
    }

    override fun onStop() {
        super.onStop()
        mapview.onStop()
        MapKitFactory.getInstance().onStop()
    }

    override fun onStart() {
        super.onStart()
        mapview.onStart()
        MapKitFactory.getInstance().onStart()
    }

    companion object {

        val TAG: String = LaunchFragment::class.java.name

        const val FLIGHT_NUMBER = "flight_number"

        fun newInstance(flightNumber: Int) = LaunchFragment().also {
            it.arguments = Bundle().apply {
                putInt(FLIGHT_NUMBER, flightNumber)
            }
        }
    }
}
