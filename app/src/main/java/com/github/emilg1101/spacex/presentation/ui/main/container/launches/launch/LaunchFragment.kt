package com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.chip.Chip
import android.support.v4.view.ViewCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.adapter.LaunchCoresAdapter
import com.github.emilg1101.spacex.presentation.adapter.LaunchImagesAdapter
import com.github.emilg1101.spacex.presentation.adapter.LaunchPayloadsAdapter
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.base.HasToolbar
import com.github.emilg1101.spacex.presentation.model.CoreLaunchItemModel
import com.github.emilg1101.spacex.presentation.model.LinkLaunchItemModel
import com.github.emilg1101.spacex.presentation.model.PayloadLaunchItemModel
import com.squareup.picasso.Picasso
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

    @field:Inject
    lateinit var launchCoresAdapter: LaunchCoresAdapter

    @field:Inject
    lateinit var launchPayloadsAdapter: LaunchPayloadsAdapter

    @field:Inject
    lateinit var launchImagesAdapter: LaunchImagesAdapter

    override val contentLayout = R.layout.fragment_launch

    override fun getToolbar(): Toolbar = toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.initialize(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewCompat.requestApplyInsets(container)
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

        list_cores.adapter = launchCoresAdapter
        list_cores.layoutManager = LinearLayoutManager(context)
        list_payloads.adapter = launchPayloadsAdapter
        list_payloads.layoutManager = LinearLayoutManager(context)
        list_images.adapter = launchImagesAdapter
        list_images.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun showMission(name: String) {
        text_mission_name.text = name
    }

    override fun showLaunchPad(name: String) {
        text_launchpad.text = name
    }

    override fun showLaunchTime(time: String) {
        text_launch_time.text = time
    }

    override fun showDetails(details: String) {
        text_details.text = details
    }

    override fun showRocket(name: String) {
        text_rocket.text = name
    }

    override fun showPatch(patch: String) {
        Picasso.get().load(patch).into(image_patch)
    }

    override fun showLaunchPadOnMap(point: Point) {
        mapview.map.move(CameraPosition(point, 11.0f, 0.0f, 0.0f))
        mapview.setNoninteractive(true)
        mapview.map.mapObjects.addPlacemark(point)
    }

    override fun showCores(items: List<CoreLaunchItemModel>) {
        if (items.isEmpty()) {
            label_cores.visibility = View.GONE
            list_payloads.visibility = View.GONE
        }
        launchCoresAdapter.items = items
        launchCoresAdapter.onItemClick = {
            presenter.openCore(it)
        }
    }

    override fun showPayloads(items: List<PayloadLaunchItemModel>) {
        if (items.isEmpty()) {
            label_payloads.visibility = View.GONE
            list_payloads.visibility = View.GONE
        }
        launchPayloadsAdapter.items = items
        launchPayloadsAdapter.onItemClick = {
            presenter.openPayload(it)
        }
    }

    override fun showLinks(items: List<LinkLaunchItemModel>) {
        if (items.isEmpty()) {
            label_links.visibility = View.GONE
            list_links.visibility = View.GONE
        }
        items.forEach { model ->
            val chip = Chip(context)
            chip.text = model.title
            chip.setOnClickListener {
                presenter.openLink(model)
            }
            list_links.addView(chip)
        }
    }

    override fun showImages(items: List<String>) {
        if (items.isEmpty()) {
            label_images.visibility = View.GONE
            list_images.visibility = View.GONE
        }
        launchImagesAdapter.items = items
    }

    override fun setRocketId(id: String) {
        btn_rocket.setOnClickListener {
            presenter.openRocket(id)
        }
    }

    override fun setLaunchPadId(id: String) {
        text_launchpad.setOnClickListener {
            presenter.openLaunchPad(id)
        }
    }

    @SuppressLint("RestrictedApi")
    override fun showRemind() {
        button_remind.visibility = View.VISIBLE
        button_remind.setOnClickListener {
            presenter.onRemind()
        }
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

    fun getFlightNumber(): Int {
        return arguments?.getInt(FLIGHT_NUMBER) ?: throw IllegalArgumentException()
    }

    companion object {

        val TAG: String = LaunchFragment::class.java.name

        private const val FLIGHT_NUMBER = "flight_number"

        fun newInstance(flightNumber: Int) = LaunchFragment().also {
            it.arguments = Bundle().apply {
                putInt(FLIGHT_NUMBER, flightNumber)
            }
        }
    }
}
