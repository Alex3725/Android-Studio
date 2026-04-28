package com.example.veraprimaapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



    @SuppressLint("MissingInflatedId")
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


        Button btn = findViewById(R.id.btn1);
        TextView text1 = findViewById(R.id.textView1);
        EditText email = findViewById(R.id.editTextEmail);
        EditText password = findViewById(R.id.editTextPassword);



        final String[] account = {"alex@gmail.com", "1234"};
        boolean[] isLogged = {false};
        btn.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String em = email.getText().toString().trim();
                String psw = password.getText().toString().trim();

                if (em.isEmpty()) {
                    email.setError("Email obbligatoria");
                    return;
                }

                if (psw.isEmpty()) {
                    password.setError("Password obbligatoria");
                    return;
                }


                if (em == account[0] && psw == account[1]){
                    text1.setText(getString(R.string.error_login));
                    isLogged[0] = true;
                }
                    // OK login

                    text1.setBackgroundColor(
                            ContextCompat.getColor(MainActivity.this, (isLogged[0] ? R.color.blue : R.color.red))
                    );
                    text1.setTextColor(
                            Color.WHITE
                    );
                    text1.setText(getString((isLogged[0] ? R.string.succesfull_login : R.string.error_login)));
                    Toast.makeText(v.getContext(), ("Login: "+(isLogged[0]? "OK" : "Bad")), Toast.LENGTH_SHORT).show();
            }
        });



    }
}