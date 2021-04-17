package com.example.androidstudy.DiffUtil

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class PersonAdapterModel(val adapter: RecyclerView.Adapter<RecyclerviewAdapter.PersonViewHolder>) {


    private var personArray = ArrayList<PersonModel>()


    init {

        personArray.clear()

        for(i in 0..15) {
            personArray.add(PersonModel(i,"test$i","N"))
        }

    }

    private fun updatePersonListItems(personArray : ArrayList<PersonModel>) {

        val diffCallback : PersonDiffUtil = PersonDiffUtil(this.personArray, personArray)
        val diffResult : DiffUtil.DiffResult = DiffUtil.calculateDiff(diffCallback)

        diffResult.dispatchUpdatesTo(adapter)

    }

    private fun setNewArray(newPersonArray : ArrayList<PersonModel>) {

        personArray.clear()
        personArray.addAll(newPersonArray)

    }

    fun size() : Int = personArray.size

    fun get(position : Int) : PersonModel = personArray[position]

    fun addItem() {

        Log.d("로그","updateList - call")


        val newPersonArray = ArrayList<PersonModel>()
        newPersonArray.addAll(personArray)
        newPersonArray.add(PersonModel((newPersonArray.size-1)+1,"Test","T"))

        updatePersonListItems(newPersonArray)
        setNewArray(newPersonArray)

    }

    fun deleteItem() {

        val newPersonArray = ArrayList<PersonModel>()
        newPersonArray.addAll(personArray)
        newPersonArray.removeAt(newPersonArray.size-1)

        updatePersonListItems(newPersonArray)
        setNewArray(newPersonArray)

    }





}