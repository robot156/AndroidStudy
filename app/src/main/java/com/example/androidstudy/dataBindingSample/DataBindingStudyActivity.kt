package com.example.androidstudy.dataBindingSample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidstudy.R
import com.example.androidstudy.databinding.ActivityDataBindingStudyBinding

class DataBindingStudyActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDataBindingStudyBinding
    private lateinit var viewModel : SimpleViewModelSolution

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_study)
        viewModel = ViewModelProvider(this).get(SimpleViewModelSolution::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

    }


}