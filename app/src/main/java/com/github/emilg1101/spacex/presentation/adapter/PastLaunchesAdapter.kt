package com.github.emilg1101.spacex.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.model.PastLaunchItemModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_launch.view.*

class PastLaunchesAdapter : RecyclerView.Adapter<PastLaunchesAdapter.LaunchViewHolder>() {

    var items: List<PastLaunchItemModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onItemClick: ((PastLaunchItemModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_launch, parent, false)
        return LaunchViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, viewType: Int) {
        holder.bindView()
    }

    inner class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView() = with(itemView) {
            text_mission.text = items[adapterPosition].mission
            text_launch_time.text = items[adapterPosition].launchTime

            items[adapterPosition].patch.takeIf { it.isNotEmpty() }?.also {
                Picasso.get().load(it).into(patch)
            }

            setOnClickListener {
                onItemClick?.invoke(items[adapterPosition])
            }
        }
    }
}
