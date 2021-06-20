package com.example.androidstudy.TabLayoutStudy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidstudy.R
import com.example.androidstudy.databinding.FragmentTabOneBinding


class TabOneFragment : Fragment() {

    companion object {
        var friendCount : Int = 0
    }

    private var _binding: FragmentTabOneBinding? = null
    private val binding: FragmentTabOneBinding get() = _binding!!

    private lateinit var friendModel : FriendViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTabOneBinding.inflate(LayoutInflater.from(context), container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        friendModel = ViewModelProvider(requireActivity()).get(FriendViewModel::class.java)

        friendModel.friendData.observe(viewLifecycleOwner, Observer {
            friendCount = it
        })

        binding.frinedAddBtn.setOnClickListener {

            friendModel.setFriendData(input = ++friendCount)

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}