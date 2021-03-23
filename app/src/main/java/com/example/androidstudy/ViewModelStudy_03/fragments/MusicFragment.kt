package com.example.androidstudy.ViewModelStudy_03.fragments

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
import com.example.androidstudy.databinding.FragmentMusicBinding

class MusicFragment : Fragment() {

    private var _binding: FragmentMusicBinding? = null
    private val binding: FragmentMusicBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMusicBinding.inflate(LayoutInflater.from(context), container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val friendData = ViewModelProvider(requireActivity()).get(NavViewModel::class.java)

        friendData.friendData.observe(viewLifecycleOwner, Observer {
            binding.musicEnjoyTv.text = "${it}명의 친구와 음악을 즐겨요"
        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("로그","MusicFragment / onDestroyView - call")
        _binding = null
    }
}