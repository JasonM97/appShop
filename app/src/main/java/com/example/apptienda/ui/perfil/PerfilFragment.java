package com.example.apptienda.ui.perfil;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.apptienda.LoginActivity;
import com.example.apptienda.R;
import com.example.apptienda.databinding.FragmentProfileBinding;

public class PerfilFragment extends Fragment {

    private FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);

        // Botón regresar
        binding.btnBack.setOnClickListener(v -> {
            requireActivity().onBackPressed();
        });

        // Botón cerrar sesión
        binding.btnLogout.setOnClickListener(v -> {

            new AlertDialog.Builder(requireContext())
                    .setTitle("Cerrar sesión")
                    .setMessage("¿Seguro que deseas cerrar sesión?")
                    .setPositiveButton("Sí", (dialog, which) -> {

                        // Limpia datos si usas preferencias
                        SharedPreferences prefs = requireActivity()
                                .getSharedPreferences("USER_DATA", Context.MODE_PRIVATE);
                        prefs.edit().clear().apply();

                        // Ir al LoginActivity limpiando el back stack
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);

                    })
                    .setNegativeButton("Cancelar", (dialog, which) -> {
                        dialog.dismiss();
                    })
                    .show();
        });

        return binding.getRoot();
    }
    @Override
    public void onResume() {
        super.onResume();
        requireActivity().findViewById(R.id.mainHeader).setVisibility(View.GONE);
        requireActivity().findViewById(R.id.nav_view).setVisibility(View.GONE);
    }

    // 🟩 MOSTRAR HEADER NUEVAMENTE CUANDO SALES DEL FRAGMENTO
    @Override
    public void onStop() {
        super.onStop();
        requireActivity().findViewById(R.id.mainHeader).setVisibility(View.VISIBLE);
        requireActivity().findViewById(R.id.nav_view).setVisibility(View.VISIBLE);
    }



}
