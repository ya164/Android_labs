package com.example.lab2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UiViewModel : ViewModel() {

    private val _text = MutableLiveData("")
    val text: LiveData<String> = _text

    private val _fontSp = MutableLiveData(18f)
    val fontSp: LiveData<Float> = _fontSp

    fun setData(text: String, fontSp: Float) {
        _text.value = text
        _fontSp.value = fontSp
    }

    fun clear() {
        _text.value = ""
        _fontSp.value = 18f
    }
}

