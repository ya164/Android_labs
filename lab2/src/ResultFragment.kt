package com.example.lab2

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class ResultFragment : Fragment(R.layout.fragment_result) {

    private val vm: UiViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tv = view.findViewById<TextView>(R.id.tvResult)
        val btnCancel = view.findViewById<Button>(R.id.btnCancel)

        vm.text.observe(viewLifecycleOwner) { tv.text = it }
        vm.fontSp.observe(viewLifecycleOwner) { sp ->
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp)
        }

        btnCancel.setOnClickListener {
            vm.clear()
            (activity as? MainActivity)?.hideResultFragment()
        }
    }
}