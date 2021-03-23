package com.example.androidstudy.TabLayoutStudy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FriendViewModel : ViewModel() {

    private val _friendData : MutableLiveData<Int> = MutableLiveData()

    val friendData : LiveData<Int> get() = _friendData

    fun setFriendData(input : Int) {

        _friendData.value = input

    }


}