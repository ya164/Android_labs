package com.example.lab2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.input_container, InputFragment())
            }
        }
    }

    fun showResultFragment() {
        val existing = supportFragmentManager.findFragmentById(R.id.result_container)
        if (existing == null) {
            supportFragmentManager.commit {
                replace(R.id.result_container, ResultFragment())
            }
        }
    }

    fun hideResultFragment() {
        val existing = supportFragmentManager.findFragmentById(R.id.result_container)
        if (existing != null) {
            supportFragmentManager.commit {
                remove(existing)
            }
        }
    }
}