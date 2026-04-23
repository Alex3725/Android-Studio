package com.example.veraprimaapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.btn = findViewById(R.id.btn1);
        this.text1 = findViewById(R.id.textView1);
        final boolean[] isClick = {false};
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text1.setText(isClick[0] ? "ho spento" : "Ho cliccato");
                text1.setBackgroundColor(getColor(isClick[0] ? R.color.blue : R.color.red));

                isClick[0] = !isClick[0];
            }
        });
    }
}