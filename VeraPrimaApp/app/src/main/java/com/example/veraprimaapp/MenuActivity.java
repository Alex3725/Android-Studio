package com.example.veraprimaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends AppCompatActivity {

    Button ese,info,cont, calc;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu);

        try {
            ese = findViewById(R.id.btnEs);
            info = findViewById(R.id.btnInfo);
            cont = findViewById(R.id.btnCont);
            calc = findViewById(R.id.btnGoCalc);


            if (ese == null || info == null || cont == null) {
                Log.e("DEBUG", "UNO O PIU' VIEW È NULL (ID SBAGLIATI)");
                return;
            }
        } catch (Exception e) {
        Log.e("DEBUG", "CRASH ON CREATE", e);
    }

        ese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MenuActivity.this, EseActivity.class);
                startActivity(intent);
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MenuActivity.this, InformatioActivity.class);
                startActivity(intent);
            }
        });
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MenuActivity.this, ContatActivity.class);
                startActivity(intent);
            }
        });
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MenuActivity.this, MainCalc.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
