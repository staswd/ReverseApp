package com.hfad.reverseapp

import androidx.lifecycle.ViewModel

class MainFragmentViewModel():ViewModel() {
    fun reverseText(textToReverse:String,filter:String):String{
     val splittedText=textToReverse.split(" ")
        var reversedText: List<String>
        if(filter==""){
            reversedText= splittedText.map{ reverseWord(it)}
        }else{
            reversedText= splittedText.map{ reverseWordWithFilter(it,filter)}
        }
        val result=reversedText.joinToString(" ")
        return result
    }
    fun reverseWord(word:String):String{
        val indexes= mutableListOf<Int>()
        val symbols= mutableListOf<Char>()
        val resultWord= word.toCharArray().toMutableList()
        resultWord.forEachIndexed{index, it->
            if(it.code !in 97..122&&it.code !in 65..90){
                indexes.add(index)
                symbols.add(it)
            }
        }
        if(indexes.size>0) {
            indexes.reversed().forEach { resultWord.removeAt(it) }
        }
        resultWord.reverse()
        if(indexes.size>0) {
            for((j, i) in indexes.withIndex()){
                resultWord.add(i, symbols[j])
            }
        }
                return resultWord.joinToString ( "" )
    }
    fun reverseWordWithFilter( word:String, filter: String): String{
        val indexes= mutableListOf<Int>()
        val symbols= mutableListOf<Char>()
        val filterList=filter.toCharArray().toMutableList()
        var resultWord=word.toCharArray().toMutableList()
        resultWord.mapIndexed { index, it->
            if (filterList.contains(it)) {
                indexes.add(index)
                symbols.add(it)
            }
        }
        if(indexes.size>0) {
            indexes.reversed().forEach { resultWord.removeAt(it) }
        }
        resultWord.reverse()
        if(indexes.size>0) {
            for((j, i) in indexes.withIndex()){
                resultWord.add(i, symbols[j])
            }
        }
        return resultWord.joinToString ( "" )
    }
}