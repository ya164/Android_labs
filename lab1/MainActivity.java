package com.example.lab1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etInput;
    private RadioGroup rgFontSize;
    private TextView tvResult;
    private Button btnOk, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.etInput);
        rgFontSize = findViewById(R.id.rgFontSize);
        tvResult = findViewById(R.id.tvResult);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(v -> {
            String text = etInput.getText().toString().trim();
            int checkedId = rgFontSize.getCheckedRadioButtonId();

            if (text.isEmpty() || checkedId == -1) {
                Toast.makeText(this, "Завершіть введення всіх даних", Toast.LENGTH_SHORT).show();
                return;
            }

            float sizeSp;
            if (checkedId == R.id.rbSmall) sizeSp = 14f;
            else if (checkedId == R.id.rbMedium) sizeSp = 18f;
            else sizeSp = 24f;

            tvResult.setText(text);
            tvResult.setTextSize(sizeSp);
        });

        btnCancel.setOnClickListener(v -> {
            etInput.setText("");
            rgFontSize.clearCheck();
            tvResult.setText("Результат буде тут");
            tvResult.setTextSize(16f);
        });
    }
}