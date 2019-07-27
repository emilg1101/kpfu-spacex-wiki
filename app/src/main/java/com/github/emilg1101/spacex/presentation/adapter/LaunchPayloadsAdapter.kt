package com.github.emilg1101.spacex.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.model.PayloadLaunchItemModel
import kotlinx.android.synthetic.main.item_launch_payload.view.*

class LaunchPayloadsAdapter : RecyclerView.Adapter<LaunchPayloadsAdapter.PayloadViewHolder>() {

    var items: List<PayloadLaunchItemModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onItemClick: ((PayloadLaunchItemModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayloadViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_launch_payload, parent, false)
        return PayloadViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PayloadViewHolder, viewType: Int) {
        holder.bindView()
    }

    inner class PayloadViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView() = with(itemView) {
            val item = items[adapterPosition]
            text_payload.text = item.payloadId

            setOnClickListener {
                onItemClick?.invoke(items[adapterPosition])
            }
        }
    }
}