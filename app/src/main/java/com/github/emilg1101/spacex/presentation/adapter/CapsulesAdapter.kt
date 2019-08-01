package com.github.emilg1101.spacex.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.model.CapsuleItemModel
import kotlinx.android.synthetic.main.item_capsule.view.*

class CapsulesAdapter : RecyclerView.Adapter<CapsulesAdapter.CapsuleViewHolder>() {

    var items: List<CapsuleItemModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onItemClick: ((CapsuleItemModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CapsuleViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_capsule, parent, false)
        return CapsuleViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CapsuleViewHolder, viewType: Int) {
        holder.bindView()
    }

    inner class CapsuleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView() = with(itemView) {
            val item = items[adapterPosition]
            text_serial.text = item.serial
            text_status.text = item.status
            text_type.text = item.type

            setOnClickListener {
                onItemClick?.invoke(item)
            }
        }
    }
}