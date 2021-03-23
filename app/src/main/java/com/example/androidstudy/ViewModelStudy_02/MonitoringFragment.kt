package com.example.androidstudy.ViewModelStudy_02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidstudy.databinding.FragmentMonitoringBinding

class MonitoringFragment : Fragment() {


    private var _binding : FragmentMonitoringBinding? = null
    private val binding : FragmentMonitoringBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMonitoringBinding.inflate(LayoutInflater.from(context), container, false)



        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        sharedModel.liveData.observe(viewLifecycleOwner, Observer<String> {

            binding.monitoringText.text = it
        })

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


}