package com.hfad.reverseapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hfad.reverseapp.databinding.FragmentMainBinding
class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: MainFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding
            .inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        binding.textToReverse.addTextChangedListener(Watcher(binding.textToReverse,binding.filter,binding.reversed))
        binding.filter.addTextChangedListener(Watcher(binding.textToReverse,binding.filter,binding.reversed))
//        var textToReverse = ""
//        var filter = ""
//        class Watcher : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//            override fun onTextChanged(
//                s: CharSequence, start: Int,
//                before: Int, count: Int
//            ) {
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                textToReverse = binding.textToReverse.text.toString()
//                filter = binding.filter.text.toString()
//                binding.reversed.text = viewModel.reverseText(textToReverse, filter)
//            }
//        }
//        binding.textToReverse.addTextChangedListener(Watcher())
//        binding.filter.addTextChangedListener(Watcher())
        return view
    }
}