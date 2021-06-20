package com.example.androidstudy.swipeList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.androidstudy.R
import com.example.androidstudy.databinding.ActivitySwipeBinding

class SwipeActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySwipeBinding
    private val textList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for(i in 0..40) {
            textList.add(i.toString())
        }

        binding.swipeList.adapter = ListAdapter(textList)
        binding.swipeList.layoutManager = LinearLayoutManager(this)

        binding.swipeLayout.setOnRefreshListener {
            Log.d("로그","swipe refresh")
        }

        binding.swipeLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light)


    }
}