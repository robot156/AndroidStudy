package com.example.androidstudy.ViewModelStudy_03

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NavViewModel : ViewModel() {


    private val _friendData : MutableLiveData<Int> = MutableLiveData()

    val friendData : LiveData<Int> get() =  _friendData

    fun setFriendData(input : Int) {

        _friendData.value = input

    }


}