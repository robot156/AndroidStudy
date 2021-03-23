package com.example.androidstudy.TabLayoutStudy

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa)  {


    override fun createFragment(position: Int): Fragment {

        return when(position) {

            0 -> TabOneFragment()

            1 -> TabTwoFragment()

            else -> TabThreeFragment()

        }

    }

    override fun getItemCount(): Int {

        return 3

    }


}