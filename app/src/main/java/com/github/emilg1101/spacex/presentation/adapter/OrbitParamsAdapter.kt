package com.github.emilg1101.spacex.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.model.OrbitParamModel
import kotlinx.android.synthetic.main.item_orbit_param.view.*

class OrbitParamsAdapter : RecyclerView.Adapter<OrbitParamsAdapter.OrbitParamViewHolder>() {

    var items: List<OrbitParamModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrbitParamViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_orbit_param, parent, false)
        return OrbitParamViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: OrbitParamViewHolder, viewType: Int) {
        holder.bindView()
    }

    inner class OrbitParamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView() = with(itemView) {
            val item = items[adapterPosition]
            label_param.text = item.param
            text_param.text = item.value
        }
    }
}