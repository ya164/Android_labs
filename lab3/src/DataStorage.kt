package com.example.lab3

import android.content.Context
import java.io.File

object DataStorage {

    private const val FILE_NAME = "data.txt"

    fun save(context: Context, text: String) {
        val file = File(context.filesDir, FILE_NAME)
        file.appendText(text + "\n")
    }

    fun read(context: Context): String {
        val file = File(context.filesDir, FILE_NAME)
        if (!file.exists()) return ""
        return file.readText()
    }
}