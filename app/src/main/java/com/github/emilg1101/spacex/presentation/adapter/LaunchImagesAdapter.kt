package com.github.emilg1101.spacex.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.emilg1101.spacex.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_launch_images.view.*

class LaunchImagesAdapter : RecyclerView.Adapter<LaunchImagesAdapter.ImageViewHolder>() {

    var items: List<String> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_launch_images, parent, false)
        return ImageViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, viewType: Int) {
        holder.bindView()
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView() = with(itemView) {
            val item = items[adapterPosition]
            Picasso.get().load(item).fit().into(image)
        }
    }
}