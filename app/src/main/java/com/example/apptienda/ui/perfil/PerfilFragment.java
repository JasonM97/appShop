package com.example.apptienda.ui.perfil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.apptienda.LoginActivity;
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
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
        });

        return binding.getRoot();
    }
}
