package com.github.emilg1101.spacex.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.model.RocketItemModel
import kotlinx.android.synthetic.main.item_rocket.view.*

class RocketsAdapter : RecyclerView.Adapter<RocketsAdapter.RocketViewHolder>() {

    var items: List<RocketItemModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onItemClick: ((RocketItemModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_rocket, parent, false)
        return RocketViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RocketViewHolder, viewType: Int) {
        holder.bindView()
    }

    inner class RocketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView() = with(itemView) {
            val item = items[adapterPosition]
            text_rocket.text = item.name
            text_description.text = item.description

            setOnClickListener {
                onItemClick?.invoke(item)
            }
        }
    }
}
