package com.example.androidstudy.ViewModelStudy_02

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidstudy.databinding.FragmentChattingBinding

class ChattingFragment : Fragment(), View.OnClickListener {


    private var _binding : FragmentChattingBinding? = null

    private val binding : FragmentChattingBinding get() = _binding!!

    private var sharedModel : SharedViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentChattingBinding.inflate(LayoutInflater.from(context), container, false)

        binding.sendButton.setOnClickListener(this@ChattingFragment)

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {


        val preMessage : String = binding.chattingText.text.toString()

        when(view) {

            binding.sendButton -> {
                binding.chattingText.text = "${binding.chattingEdit.text}\n" + preMessage
                sharedModel!!.setLiveData("${binding.chattingEdit.text} \n"+ preMessage )

                binding.chattingEdit.setText("")
            }

        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        sharedModel!!.liveData.observe(viewLifecycleOwner, Observer {
            binding.chattingText.text = it
        })

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}