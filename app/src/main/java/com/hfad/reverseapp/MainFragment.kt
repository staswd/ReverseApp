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
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: MainFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        binding.textToReverse.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) =
                if (binding.textToReverse.text.toString() != "") {
                    binding.reverseButton.visibility = View.VISIBLE
//                    binding.reverseButton.background =
//                        getResources().getDrawable(R.drawable.button_bg)
                } else {
                    binding.reverseButton.visibility = View.GONE
                }
            override fun afterTextChanged(s: Editable?) {}
        })
//        binding.filter.addTextChangedListener(
//            Watcher(
//                binding.textToReverse,
//                binding.filter,
//                binding.anagram
//            )
//        )

        binding.textToReverse.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.textHint.visibility = View.VISIBLE
                binding.textToReverse.hint = ""
            } else {
                binding.textHint.visibility = View.GONE
                binding.textToReverse.hint = "Enter text for anagram"
            }
        }

        binding.reverseButton.setOnClickListener() {
            val textToReverse = binding.textToReverse.text.toString()
            val filter = binding.filter.text.toString()
            val reversedText = viewModel.reverseText(textToReverse, filter)
            binding.anagram.setText(reversedText)
            binding.anagram.textSize = 24f
            binding.anagram.setTextColor(getResources().getColor(R.color.my_light_primary))
        }

        return view
    }
}