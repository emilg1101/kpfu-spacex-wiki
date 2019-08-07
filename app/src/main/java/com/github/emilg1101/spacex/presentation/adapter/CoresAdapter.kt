package com.github.emilg1101.spacex.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.model.CoreItemModel
import kotlinx.android.synthetic.main.item_core.view.*

class CoresAdapter : RecyclerView.Adapter<CoresAdapter.CoreViewHolder>() {

    var items: List<CoreItemModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onItemClick: ((CoreItemModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoreViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_core, parent, false)
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
            text_core.text = item.serial

            setOnClickListener {
                onItemClick?.invoke(item)
            }
        }
    }
}