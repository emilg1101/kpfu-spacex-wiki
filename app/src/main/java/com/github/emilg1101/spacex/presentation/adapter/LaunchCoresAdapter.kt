package com.github.emilg1101.spacex.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.model.CoreLaunchItemModel
import kotlinx.android.synthetic.main.item_launch_core.view.*

class LaunchCoresAdapter : RecyclerView.Adapter<LaunchCoresAdapter.CoreViewHolder>() {

    var items: List<CoreLaunchItemModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onItemClick: ((CoreLaunchItemModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoreViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_launch_core, parent, false)
        return CoreViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CoreViewHolder, viewType: Int) {
        holder.bindView()
    }

    inner class CoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView() = with(itemView) {
            val item = items[adapterPosition]
            text_core.text = item.coreSerial
            text_landing_type.text = item.landingType
            text_landing_vehicle.text = item.landingVehicle
            text_landing_successful.text = item.success.toString()
            text_reused.text = item.reused.toString()

            btn_more.setOnClickListener {
                onItemClick?.invoke(items[adapterPosition])
            }
        }
    }
}