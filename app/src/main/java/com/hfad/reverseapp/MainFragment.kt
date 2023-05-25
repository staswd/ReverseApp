package com.hfad.reverseapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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

        binding.textToReverse.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                textToReverse=binding.textToReverse.text.toString()
            filter=binding.filter.text.toString()
                binding.reversed.text=viewModel.reverseText(textToReverse,filter)
            }
        })
        binding.filter.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                textToReverse=binding.textToReverse.text.toString()
                filter=binding.filter.text.toString()
                binding.reversed.text=viewModel.reverseText(textToReverse,filter)
            }
        })

//        binding.reverseButton.setOnClickListener(){
//
//            textToReverse=binding.textToReverse.text.toString()
//            filter=binding.filter.text.toString()
//            val reversedText=viewModel.reverseText(textToReverse,filter)
//            binding.reversed.setText(reversedText)
//
//        }


        return view
    }


}