package com.example.androidstudy.TabLayoutStudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidstudy.R
import com.example.androidstudy.databinding.ActivityTabLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTabLayoutBinding

    private val arrayIcon = arrayListOf(R.drawable.ic_home_24, R.drawable.ic_friend_24, R.drawable.ic_music_24)
    private val arrayText = arrayListOf("HOME", "FRIEND", "MUSIC")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTabLayoutBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.tabView.adapter = TabViewPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.tabView) {

            tab,position ->

            tab.setIcon(arrayIcon[position])

            tab.text = arrayText[position]

        }.attach()

    }




}