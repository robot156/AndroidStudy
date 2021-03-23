package com.example.androidstudy.ViewModelStudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidstudy.databinding.ActivityNumberBinding

class NumberActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityNumberBinding

    private lateinit var myNumberViewModel: NumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNumberBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // numberViewModel 연결하기
        myNumberViewModel = ViewModelProvider(this).get(NumberViewModel::class.java)

        myNumberViewModel.currentValue.observe(this, Observer {

            binding.numberTv.text = it.toString()

        } )

        binding.apply {

            plusBtn.setOnClickListener(this@NumberActivity)
            minusBtn.setOnClickListener(this@NumberActivity)

        }

    }

    override fun onClick(view: View?) {

        var userInput = 0

        if(binding.numberEdit.length() > 0) {
            userInput = binding.numberEdit.text.toString().toInt()
        }

        when(view) {

            binding.plusBtn -> {
                myNumberViewModel.updateValue(actionType = NumberActionType.PLUS, input = userInput)
            }

            binding.minusBtn -> {
                myNumberViewModel.updateValue(actionType = NumberActionType.MINUS, input = userInput)
            }

        }


    }


}