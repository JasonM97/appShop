package com.example.apptienda;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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



        //****************************DIRECCIONAR A AL MENU DEL NAVIGATION BUTTON (Main Activity )
            //ENLAZAMIENTO CON LA INTERFAZ Login - LoginActivity ( Para los txt )
            //Se guarda lo que esta en la caja de la interfaz , en la variable declarada de manera privada
            usuario = findViewById(R.id.txtUsuario);
            contraseña = findViewById(R.id.txtPassword);

            //conecta el botón del layout con el código, para poder controlarlo.
            Button btnIniciar = findViewById(R.id.btnLogin);

            MediaPlayer sonido = MediaPlayer.create(this, R.raw.click1); // Uso del sonido de llado del Id del sonido ( click)

            //Uso del botonInicira al dar click
            btnIniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // Reproducir sonido cuando se presiona el botón
                    sonido.start();

                    // Obtiene el tetxto de los TEXT , para luego validarlos con el usuario y contraseña  que tenemos por defecto
                    String usuarioInput = usuario.getText().toString().trim();
                    String contraseñaInput = contraseña.getText().toString().trim();

                    // Validación por defecto
                    if(usuarioInput.equals("admin") && contraseñaInput.equals("admin")) {
                       Toast.makeText(LoginActivity.this, "¡Login correcto!", Toast.LENGTH_SHORT).show();

                        // Aquí nos dirige a la interfaz MainActivity
                       startActivity(new Intent(LoginActivity.this, MainActivity.class));
                   } else {
                        Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        //************************ENLAZAMIENTO CON LA INTERFAZ Login - LoginActivity ( Para los ImgButton )
        ImageButton btnFacebook = findViewById(R.id.btnFacebook);
        ImageButton btnIntagram = findViewById(R.id.btnInstagram);
        ImageButton btnTwitter = findViewById(R.id.btnTwiter);

        MediaPlayer sonidoBtn = MediaPlayer.create(this, R.raw.click4);

        //ACCIONES DE CLICK PARA CADA BOTON
        btnFacebook.setOnClickListener(v -> {
            sonidoBtn.start();
            String url = "https://www.facebook.com/tu_pagina";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });

        btnIntagram.setOnClickListener(v -> {
            sonidoBtn.start();
            String url = "https://www.instagram.com/";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });

        btnTwitter.setOnClickListener(v -> {
            sonidoBtn.start();
            String url = "https://x.com/?lang=es";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });


    }


}
