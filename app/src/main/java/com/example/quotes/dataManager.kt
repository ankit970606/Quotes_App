package com.example.quotes

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotes.model.quote
import com.google.gson.Gson

object dataManager {

    var currentQuote : quote? = null

    var data = emptyArray<quote>()
    var currentPages = mutableStateOf(Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<quote>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quote: quote?){
        if (currentPages.value == Pages.LISTING){
            currentPages.value = Pages.DETAIL
        }else{
            currentPages.value = Pages.LISTING
        }

    }
}