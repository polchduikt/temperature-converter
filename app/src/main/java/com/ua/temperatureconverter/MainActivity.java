package com.ua.temperatureconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etTemperature;
    RadioGroup radioGroup;
    Button convertorButtun;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTemperature   = findViewById(R.id.etTemperature);
        radioGroup      = findViewById(R.id.radioGroup);
        convertorButtun = findViewById(R.id.convertorButtun);
        tvResult        = findViewById(R.id.tvResult);

        convertorButtun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etTemperature.getText().toString();
                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Enter temperature",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                double temperature = Double.parseDouble(input);
                double result;
                String resultText;
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == R.id.rbCelsiusToFahrenheit) {
                    result = temperature * 9.0 / 5.0 + 32;
                    resultText = temperature + " °C = " + String.format("%.2f", result) + " °F";
                } else {
                    result = (temperature - 32) * 5.0 / 9.0;
                    resultText = temperature + " °F = " + String.format("%.2f", result) + " °C";
                }
                tvResult.setText(resultText);
            }
        });
    }
}