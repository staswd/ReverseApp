package com.hfad.reverseapp

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
class Watcher(var textToReverse: TextView, var filter:TextView,var textView:TextView) : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence, start: Int,before: Int, count: Int) {}
    override fun afterTextChanged(s: Editable?) {
        textView.text = MainFragmentViewModel().reverseText(textToReverse.text.toString(), filter.text.toString())
    }
}