package com.example.bin.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bin.databinding.ItemHistoryBinding

class HistoryRecyclerViewAdapter : RecyclerView.Adapter<HistoryRecyclerViewAdapter.ViewHolder>() {

    val datalist = mutableListOf<String>()
    lateinit var listener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(value: String)
    }

    fun updateData(data: String) {
        datalist.add(data)
        this.notifyItemInserted(datalist.lastIndex)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    inner class ViewHolder(
        private val binding: ItemHistoryBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            binding.historyText.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        println(position)
        holder.bind(datalist.getOrElse(position) { "" })
    }

    override fun getItemCount() = datalist.size
}