package com.example.androidstudy.ViewModelStudy_03.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidstudy.R
import com.example.androidstudy.ViewModelStudy_03.NavViewModel
import com.example.androidstudy.databinding.FragmentFriendBinding


class FriendFragment : Fragment() {

    private var _binding : FragmentFriendBinding? = null
    private val binding : FragmentFriendBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFriendBinding.inflate(LayoutInflater.from(context), container, false)

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val friendData = ViewModelProvider(requireActivity()).get(NavViewModel::class.java)

        friendData.friendData.observe(viewLifecycleOwner, Observer {
            binding.friendCountTv.text = "현재 친구 수 : ${it}명"
        })

    }

    override fun onDestroyView() {

        super.onDestroyView()
        Log.d("로그","FriendFragment / onDestroyView - call")
        _binding = null

    }
}