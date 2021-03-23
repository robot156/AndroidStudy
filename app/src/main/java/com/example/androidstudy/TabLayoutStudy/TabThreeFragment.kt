package com.example.androidstudy.TabLayoutStudy

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidstudy.databinding.FragmentTabThreeBinding


class TabThreeFragment : Fragment() {

    private var _binding : FragmentTabThreeBinding? = null
    private val binding : FragmentTabThreeBinding get() = _binding!!
    private lateinit var friendModel : FriendViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTabThreeBinding.inflate(LayoutInflater.from(context),container,false)

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        friendModel = ViewModelProvider(requireActivity()).get(FriendViewModel::class.java)

        friendModel.friendData.observe(viewLifecycleOwner, Observer {
            binding.friendTv.text = "My Friend Count : ${it}"
        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}