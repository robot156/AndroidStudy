package com.example.androidstudy.ViewModelStudy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidstudy.ViewModelStudy.NumberActionType.*

enum class NumberActionType {
    PLUS, MINUS
}

class NumberViewModel : ViewModel() {

    var value : Int = 0

    private val _currentValue = MutableLiveData<Int>()

    val currentValue : LiveData<Int>
            get() = _currentValue

    init {
        _currentValue.value = 0
    }

    fun updateValue(actionType: NumberActionType, input : Int) {

        when(actionType) {

            PLUS -> _currentValue.value = _currentValue.value?.plus(input)

            MINUS -> _currentValue.value = _currentValue.value?.minus(input)

        }

    }


}