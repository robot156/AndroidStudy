package com.example.androidstudy.DiffUtil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidstudy.databinding.LayoutPersonItemBinding

class RecyclerviewAdapter : RecyclerView.Adapter<RecyclerviewAdapter.PersonViewHolder>() {

    private val personModelAdapter = PersonAdapterModel(this)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {

        val view = LayoutPersonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return  PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {

        holder.bind(personModelAdapter.get(position))

    }

    override fun getItemCount(): Int = personModelAdapter.size()


    fun addList() {
        personModelAdapter.addItem()
    }

    fun deleteList(){
        personModelAdapter.deleteItem()
    }

    inner class PersonViewHolder(itemView : LayoutPersonItemBinding) : RecyclerView.ViewHolder(itemView.root) {

        val binding = itemView

        fun bind(person : PersonModel){

            binding.idTv.text = person.id.toString()
            binding.nameTv.text = person.name
            binding.roleTv.text = person.role

        }

    }

}