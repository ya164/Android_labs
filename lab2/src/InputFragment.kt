package com.example.lab2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class InputFragment : Fragment(R.layout.fragment_input) {

    private val vm: UiViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rg = view.findViewById<RadioGroup>(R.id.rgFontSize)
        val et = view.findViewById<EditText>(R.id.etInput)
        val btnOk = view.findViewById<Button>(R.id.btnOk)

        vm.text.observe(viewLifecycleOwner) { et.setText(it) }

        btnOk.setOnClickListener {
            val input = et.text?.toString()?.trim().orEmpty()
            if (input.isEmpty()) {
                Toast.makeText(requireContext(), "Введіть текст", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val fontSp = when (rg.checkedRadioButtonId) {
                R.id.rbSmall -> 14f
                R.id.rbMedium -> 18f
                R.id.rbLarge -> 24f
                else -> 18f
            }

            vm.setData(input, fontSp)
            (activity as? MainActivity)?.showResultFragment()
        }
    }
}