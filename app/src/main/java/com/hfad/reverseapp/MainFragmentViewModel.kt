package com.hfad.reverseapp

import androidx.lifecycle.ViewModel

class MainFragmentViewModel():ViewModel() {





    fun reverseText(textToReverse:String,filter:String):String{
     val splittedText=textToReverse.split(" ")
        val reversedText = splittedText.map{ reverseWord(it,filter)}

        val result=reversedText.joinToString(" ")

        return result




    }


    fun reverseWord( word:String, filter: String): String{
        val filterList=filter.split("")
        var resultWord:String=""
        word.split("").mapIndexed { index, it->
            if (filterList.contains(it)) {
                resultWord+=it
            }
            else{
                resultWord+=word[word.length-(index)]
            }
        }
        return resultWord
    }

}