package com.hfad.reverseapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.findNavController
import com.hfad.reverseapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding?=null
    private val binding get() = _binding!!

    lateinit var viewModel: MainFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding
            .inflate(inflater,container,false)
        val view=binding.root
        var textToReverse=""
        var filter=""
        viewModel=ViewModelProvider(this).get(MainFragmentViewModel::class.java)


        binding.reverseButton.setOnClickListener(){

            textToReverse=binding.textToReverse.text.toString()
            filter=binding.filter.text.toString()
            val reversedText=viewModel.reverseText(textToReverse,filter)
            binding.reversed.setText(reversedText)

        }


        return view
    }


}