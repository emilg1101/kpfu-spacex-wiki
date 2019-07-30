package com.github.emilg1101.spacex.presentation.adapter

import android.support.design.chip.Chip
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.model.HistoricalEventItemModel
import kotlinx.android.synthetic.main.item_history_event.view.*
import com.github.vipulasri.timelineview.TimelineView

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryEventViewHolder>() {

    var items: List<HistoricalEventItemModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onItemClick: ((HistoricalEventItemModel) -> Unit)? = null
    var onLinkClick: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryEventViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_history_event, parent, false)
        return HistoryEventViewHolder(v, viewType)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HistoryEventViewHolder, viewType: Int) {
        holder.bindView()
    }

    override fun getItemViewType(position: Int): Int {
        return TimelineView.getTimeLineViewType(position, itemCount)
    }

    inner class HistoryEventViewHolder(itemView: View, viewType: Int) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.timeline.initLine(viewType)
        }

        fun bindView() = with(itemView) {
            val item = items[adapterPosition]
            text_date.text = item.date
            text_title.text = item.title
            text_details.text = item.details

            setOnClickListener {
                onItemClick?.invoke(item)
            }

            item.reddit.takeIf { it.isNotEmpty() }?.also { reddit ->
                list_links.addView(Chip(context).apply {
                    text = "Reddit"
                    setOnClickListener {
                        onLinkClick?.invoke(reddit)
                    }
                })
            }

            item.wikipedia.takeIf { it.isNotEmpty() }?.also { wikipedia ->
                list_links.addView(Chip(context).apply {
                    text = "Wikipedia"
                    setOnClickListener {
                        onLinkClick?.invoke(wikipedia)
                    }
                })
            }

            item.article.takeIf { it.isNotEmpty() }?.also { article ->
                list_links.addView(Chip(context).apply {
                    text = "Article"
                    setOnClickListener {
                        onLinkClick?.invoke(article)
                    }
                })
            }
        }
    }
}