package com.example.apptienda;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.apptienda.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private View header;
    private ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Header
        header = findViewById(R.id.mainHeader);
        imgProfile = header.findViewById(R.id.imgProfile);

        // Click para ir al perfil
        imgProfile.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
            if (navController.getCurrentDestination().getId() != R.id.navigation_profile) {
                navController.navigate(R.id.navigation_profile);
            }
        });

        // Bottom Navigation
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }
}
