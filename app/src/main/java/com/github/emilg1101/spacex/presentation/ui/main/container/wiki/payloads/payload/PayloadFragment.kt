package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.payload

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.adapter.OrbitParamsAdapter
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.base.HasToolbar
import com.github.emilg1101.spacex.presentation.model.OrbitParamModel
import kotlinx.android.synthetic.main.fragment_payload.*
import kotlinx.android.synthetic.main.layout_toolbar.toolbar
import javax.inject.Inject
import javax.inject.Provider

class PayloadFragment : BaseFragment(), PayloadView, HasToolbar {

    @ProvidePresenter
    fun providePresenter(): PayloadPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: PayloadPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<PayloadPresenter>

    @field:Inject
    lateinit var orbitParamsAdapter: OrbitParamsAdapter

    override val contentLayout = R.layout.fragment_payload

    override fun getToolbar(): Toolbar = toolbar

    fun getPayloadId(): String = arguments?.getString(PAYLOAD_ID) ?: throw IllegalArgumentException()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_orbit_params.adapter = orbitParamsAdapter
        list_orbit_params.layoutManager = LinearLayoutManager(context)
    }

    override fun showSerial(serial: String) {
        text_serial.text = serial
    }

    override fun showCustomers(customers: String) {
        text_customers.text = customers
    }

    override fun showNationality(nationality: String) {
        text_nationality.text = nationality
    }

    override fun showManufacturer(manufacturer: String) {
        text_manufacturer.text = manufacturer
    }

    override fun showMass(mass: String) {
        text_mass.text = mass
    }

    override fun showType(type: String) {
        text_type.text = type
    }

    override fun showReused(reused: String) {
        text_reused.text = reused
    }

    override fun showOrbitParams(items: List<OrbitParamModel>) {
        orbitParamsAdapter.items = items
    }

    companion object {

        val TAG = PayloadFragment::class.java.name
        private const val PAYLOAD_ID = "payload_id"

        fun newInstance(payloadId: String) = PayloadFragment().also {
            it.arguments = Bundle().apply {
                putString(PAYLOAD_ID, payloadId)
            }
        }
    }
}
