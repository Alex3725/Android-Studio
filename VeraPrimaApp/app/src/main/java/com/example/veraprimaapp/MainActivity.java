package com.example.veraprimaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText email, username, password;
    Button btn;
    TextView result;

    ArrayList<Utente> utenti = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        email = findViewById(R.id.editTextEmail);
        username = findViewById(R.id.editTextUserName);
        password = findViewById(R.id.editTextPassword);
        btn = findViewById(R.id.btnLogin);
        result = findViewById(R.id.textResult);

        // 👇 UTENTE DI TEST
        utenti.add(new Utente("test@mail.com", "test", "123456"));

        btn.setOnClickListener(v -> loginUtente());
    }

    private void loginUtente() {

        String mail = email.getText().toString().trim();
        String user = username.getText().toString().trim();
        String pass = password.getText().toString().trim();

        email.setError(null);
        username.setError(null);
        password.setError(null);

        if (mail.isEmpty() || user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Compila tutti i campi", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean trovato = false;

        for (Utente u : utenti) {
            if (u.getEmail().equals(mail)
                    && u.getUsername().equals(user)
                    && u.getPassword().equals(pass)) {
                trovato = true;
                break;
            }
        }

        if (trovato) {

            Toast.makeText(this, "Login OK", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, MainCalc.class);
            startActivity(intent);
            finish();

        } else {
            result.setText("Credenziali errate");
        }
    }
}