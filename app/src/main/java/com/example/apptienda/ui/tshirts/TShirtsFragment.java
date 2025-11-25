package com.example.apptienda.ui.tshirts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.apptienda.R;
import com.example.apptienda.databinding.FragmentTshirtsBinding;

public class TShirtsFragment extends Fragment {

    private FragmentTshirtsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentTshirtsBinding.inflate(inflater, container, false);

        binding.btnBack.setOnClickListener(v -> {
            NavHostFragment.findNavController(TShirtsFragment.this).navigateUp();
        });

        binding.cardItem1.setOnClickListener(v -> {
            NavHostFragment.findNavController(TShirtsFragment.this)
                    .navigate(R.id.action_camisetas_to_detalle);
        });


        return binding.getRoot();
    }
}
