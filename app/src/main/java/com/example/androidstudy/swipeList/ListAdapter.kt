package com.example.androidstudy.swipeList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidstudy.databinding.SwipeListItemBinding

class ListAdapter(private val itemList: ArrayList<String>) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layout = LayoutInflater.from(parent.context)
        val view = SwipeListItemBinding.inflate(layout, parent, false)

        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    inner class ListViewHolder(view: SwipeListItemBinding) : RecyclerView.ViewHolder(view.root) {

        val binding = view

        fun bind(tv: String) {

            binding.textView.text = tv

        }

    }

}