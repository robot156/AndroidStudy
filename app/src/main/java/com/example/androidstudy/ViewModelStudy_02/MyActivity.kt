package com.example.androidstudy.ViewModelStudy_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidstudy.R
import com.example.androidstudy.databinding.ActivityMyBinding

class MyActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMyBinding

    private var chattingFragment = ChattingFragment()

    private var monitoringFragment = MonitoringFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMyBinding.inflate(layoutInflater)

        setContentView(binding.root)

        chattingFragment = supportFragmentManager.findFragmentById(R.id.fragment_chatting) as ChattingFragment
        monitoringFragment = supportFragmentManager.findFragmentById(R.id.fragment_monitoring) as MonitoringFragment

    }


}