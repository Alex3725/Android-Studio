package com.example.veraprimaapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainCalc extends AppCompatActivity {

    EditText num1, num2;
    TextView res;
    Button btnCalc, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_main);

        try {
            num1 = findViewById(R.id.editTextCalcImp1);
            num2 = findViewById(R.id.editTextCalcImp2);
            res = findViewById(R.id.textResultCalc);
            btnCalc = findViewById(R.id.btnCalc);
            btnBack = findViewById(R.id.btnBack);

            if (num1 == null || num2 == null || res == null || btnCalc == null) {
                Log.e("DEBUG", "UNO O PIU' VIEW È NULL (ID SBAGLIATI)");
                return;
            }

            btnCalc.setOnClickListener(v -> outputSomma());

        } catch (Exception e) {
            Log.e("DEBUG", "CRASH ON CREATE", e);
        }

    }

    private void outputSomma() {

        try {
            String s1 = num1.getText().toString().trim();
            String s2 = num2.getText().toString().trim();

            if (s1.isEmpty() || s2.isEmpty()) {
                res.setText("Inserisci numeri");
                return;
            }

            double n1 = Double.parseDouble(s1);
            double n2 = Double.parseDouble(s2);

            res.setText(String.valueOf(n1 + n2));

        } catch (Exception e) {
            res.setText("Errore input");
        }
    }
}