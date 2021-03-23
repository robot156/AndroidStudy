package com.example.androidstudy.ViewModelStudy_02

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _liveData : MutableLiveData<String> = MutableLiveData()

    val liveData : LiveData<String> get() = _liveData

    fun setLiveData(str: String) {

        _liveData.value = str

    }

}