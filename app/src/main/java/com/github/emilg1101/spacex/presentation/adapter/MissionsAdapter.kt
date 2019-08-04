package com.github.emilg1101.spacex.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.model.MissionItemModel
import kotlinx.android.synthetic.main.item_mission_short.view.*

class MissionsAdapter : RecyclerView.Adapter<MissionsAdapter.MissionViewHolder>() {

    var items: List<MissionItemModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onItemClick: ((MissionItemModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MissionViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_mission, parent, false)
        return MissionViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MissionViewHolder, viewType: Int) {
        holder.bindView()
    }

    inner class MissionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView() = with(itemView) {
            val item = items[adapterPosition]
            text_mission.text = item.name

            setOnClickListener {
                onItemClick?.invoke(item)
            }
        }
    }
}