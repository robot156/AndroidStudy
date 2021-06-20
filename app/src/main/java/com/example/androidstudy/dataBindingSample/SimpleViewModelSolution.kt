package com.example.androidstudy.dataBindingSample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.androidstudy.dataBindingSample.SimpleViewModelSolution.Popularity.*

class SimpleViewModelSolution : ViewModel() {


    private val _name = MutableLiveData("KIM")
    private val _lastName = MutableLiveData("MIN JIN")
    private val _likes = MutableLiveData(0)

    val name: LiveData<String> = _name
    val lastName: LiveData<String> = _lastName
    val likes: LiveData<Int> = _likes

    val popularity: LiveData<Popularity> = Transformations.map(_likes) {
        when {

            it > 9 -> STAR

            it > 4 -> POPULAR

            else -> NORMAL

        }
    }

    fun onLike() {
        _likes.value = (_likes.value ?: 0) + 1
    }

    enum class Popularity {
        NORMAL,
        POPULAR,
        STAR
    }

}