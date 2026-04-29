package com.example.veraprimaapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
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
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editTextEmail);
        username = findViewById(R.id.editTextUserName);
        password = findViewById(R.id.editTextPassword);
        btn = findViewById(R.id.btnLogin);
        result = findViewById(R.id.textResult);

        btn.setOnClickListener(v -> registraUtente());
    }

    @SuppressLint("ResourceAsColor")
    private void registraUtente() {

        String mail = email.getText().toString().trim();
        String user = username.getText().toString().trim();
        String pass = password.getText().toString().trim();

        boolean valid = true;

        // reset errori
        email.setError(null);
        username.setError(null);
        password.setError(null);


        if(mail.isEmpty()){
            email.setError("Inserisci email");
            valid = false;
        }

        if(user.isEmpty()){
            username.setError("Inserisci username");
            valid = false;
        }

        if(pass.isEmpty()){
            password.setError("Inserisci password");
            valid = false;
        }

        if(valid && !android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            email.setError("Formato email non valido");
            valid = false;
        }


        if(valid && pass.length() < 6){
            password.setError("Minimo 6 caratteri");
            valid = false;
        }

        if(!valid) return;


        for(Utente u : utenti){
            if(u.getEmail().equals(mail) || u.getUsername().equals(user)){
                result.setVisibility(View.VISIBLE);
                result.setTextColor(getColor(R.color.red));
                result.setText("Utente già registrato");
                return;
            }
        }


        utenti.add(new Utente(mail, user, pass));

        result.setVisibility(View.VISIBLE);
        result.setTextColor(getColor(R.color.green));
        result.setText("Registrazione completata con successo");


        email.setText("");
        username.setText("");
        password.setText("");


        Toast.makeText(this, "Utenti registrati: " + utenti.size(), Toast.LENGTH_SHORT).show();
    }
}
