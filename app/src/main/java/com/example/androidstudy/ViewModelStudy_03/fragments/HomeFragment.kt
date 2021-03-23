package com.example.androidstudy.ViewModelStudy_03.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidstudy.ViewModelStudy_03.NavViewModel
import com.example.androidstudy.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    private var _binding : FragmentHomeBinding? = null

    private val binding : FragmentHomeBinding get() = _binding!!

    private var friendModel : NavViewModel? = null

    companion object {

        private var btnCount = 0

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(LayoutInflater.from(context), container, false)

        binding.friendAddBtn.setOnClickListener {

            btnCount++
            friendModel!!.setFriendData(input = btnCount)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        friendModel = ViewModelProvider(requireActivity()).get(NavViewModel::class.java)

        friendModel!!.friendData.observe(viewLifecycleOwner, Observer {
            Log.d("로그","btn count $it")
        })

    }

    override fun onDestroyView() {

        super.onDestroyView()
        Log.d("로그","FriendFragment / onDestroyView - call")
        _binding = null

    }
}