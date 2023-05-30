package com.hfad.reverseapp

import androidx.lifecycle.ViewModel
 class MainFragmentViewModel() : ViewModel() {
    fun reverseText(textToReverse: String, filter: String): String {
        val splittedTextList = textToReverse.split(" ")
        val reversedTextList = splittedTextList.map { reverseWord(it, filter) }
        return reversedTextList.joinToString(" ")
    }

    fun reverseWord(word: String, filter: String): String {
        val filterList = filter.toCharArray().toMutableList()
        val wordList = word.toCharArray().toMutableList()
        val fixedSymbolsMap = sortedMapOf<Int, Char>()

        if (filter == "") {
            wordList.forEachIndexed { index, it ->
                if (it.code !in 97..122 && it.code !in 65..90) {
                    fixedSymbolsMap[index] = it
                }
            }
        } else {
            wordList.mapIndexed { index, it ->
                if (filterList.contains(it)) {
                    fixedSymbolsMap[index] = it
                }
            }
        }
        fixedSymbolsMap.forEach { entry ->
            wordList.remove(entry.value)
        }
        wordList.reverse()
        fixedSymbolsMap.forEach { entry ->
            wordList.add(entry.key, entry.value)
        }
        return wordList.joinToString("")
    }
}