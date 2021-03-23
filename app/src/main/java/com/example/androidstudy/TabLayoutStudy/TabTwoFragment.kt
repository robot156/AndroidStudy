package com.example.androidstudy.TabLayoutStudy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidstudy.databinding.FragmentTabTwoBinding

class TabTwoFragment : Fragment() {

    private var _binding: FragmentTabTwoBinding? = null

    private val binding: FragmentTabTwoBinding get() = _binding!!

    private lateinit var friendModel : FriendViewModel

    private var friendNum : Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTabTwoBinding.inflate(LayoutInflater.from(context), container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        friendModel = ViewModelProvider(requireActivity()).get(FriendViewModel::class.java)

        friendModel.friendData.observe(viewLifecycleOwner, Observer {
            friendNum = it
        })

        binding.friendRemoveBtn.setOnClickListener {

            friendModel.setFriendData(input = --friendNum)

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}