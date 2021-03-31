package com.example.testroom

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val context: Context, private var data: List<Todo>) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: AppCompatTextView = itemView.findViewById(R.id.tv_title)
        val content: AppCompatTextView = itemView.findViewById(R.id.tv_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_mian_item, parent, false)
        val viewHolder = MainViewHolder(view)
        viewHolder.title.setOnClickListener {
            val itemData = data[viewHolder.adapterPosition]
            Toast.makeText(context, itemData.title, Toast.LENGTH_SHORT).show()
        }
        viewHolder.content.setOnClickListener {
            val itemData = data[viewHolder.adapterPosition]
            Toast.makeText(context, itemData.title, Toast.LENGTH_SHORT).show()
        }
        return viewHolder
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.content.text = data[position].content
    }

    fun notifyData(items: List<Todo>) {
        data = items
        notifyDataSetChanged()
    }
}