package com.example.apptienda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.apptienda.databinding.LoginBinding;

public class LoginActivity extends AppCompatActivity {

    private LoginBinding binding;


    //DECLARACION DE LAS VARAIBLES PARA AUTENTIFICACION
    private EditText usuario;
    private EditText contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getSupportActionBar().hide(); // OCULTA LA BARRA SUPERIOR
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //ENLAZAMIENTO CON LA INTERFAZ Login - lOGINaCTIVITY

            //Se guarda lo que esta en la caja de la interfaz , en la variable declarada de manera privada
            usuario = findViewById(R.id.txtUsuario);
            contraseña = findViewById(R.id.txtPassword);

        //DIRECCIONAR A AL MENU DEL NAVIGATION BUTTON (Main Activity )

            //conecta el botón del layout con el código, para poder controlarlo.
            Button btnIniciar = findViewById(R.id.btnLogin);
            btnIniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String usuarioInput = usuario.getText().toString().trim();
                    String contraseñaInput = contraseña.getText().toString().trim();

                    Toast.makeText(LoginActivity.this, "¡Login correcto!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    // Validación por defecto
//                    if(usuarioInput.equals("admin") && contraseñaInput.equals("1234")) {
//                        Toast.makeText(LoginActivity.this, "¡Login correcto!", Toast.LENGTH_SHORT).show();
//
//                        // Aquí nos dirige a la interfaz MainActivity
//                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                    } else {
//                        Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
//                    }

                }
            });

    }
}
