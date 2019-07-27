package com.github.emilg1101.spacex.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.model.LinkLaunchItemModel
import kotlinx.android.synthetic.main.item_launch_links.view.*

class LaunchLinksAdapter : RecyclerView.Adapter<LaunchLinksAdapter.LinksViewHolder>() {

    var items: List<LinkLaunchItemModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onItemClick: ((LinkLaunchItemModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinksViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_launch_links, parent, false)
        return LinksViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: LinksViewHolder, viewType: Int) {
        holder.bindView()
    }

    inner class LinksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView() = with(itemView) {
            val item = items[adapterPosition]
            text_link.text = item.title

            text_link.setOnClickListener {
                onItemClick?.invoke(items[adapterPosition])
            }
        }
    }
}