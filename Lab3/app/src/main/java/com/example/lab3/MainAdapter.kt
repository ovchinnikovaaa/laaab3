package com.example.lab3

import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val items: List<String>, private val listener: (String) -> Unit) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>(), ListAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_main_item, parent, false) as TextView

        return MainViewHolder(v)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = item
        holder.textView.setOnClickListener { listener(item) }
    }

    override fun getItemCount(): Int = items.size

    class MainViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView) {

    }

    override fun registerDataSetObserver(p0: DataSetObserver?) {
        TODO("Not yet implemented")
    }
}