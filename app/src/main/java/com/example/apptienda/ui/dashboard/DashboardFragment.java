package com.example.apptienda.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.apptienda.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        // Llamamos al tipo de elemento que se ecuentra primero ( text , griLayoput o  etc )
        final TextView txtTienda = binding.txtTienda;

        // ACCIONES DE LOS COTONES DEL MENU
         //   binding.btn1.setOnClickListener(v -> {
                // Acción para botón 1
          //  });
         //   binding.btn2.setOnClickListener(v -> {
                // Acción para botón 2
          //  });

       return root;
    }


}