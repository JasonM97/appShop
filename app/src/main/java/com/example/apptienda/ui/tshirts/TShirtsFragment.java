package com.example.apptienda.ui.tshirts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.apptienda.databinding.FragmentTshirtsBinding;

public class TShirtsFragment extends Fragment {

    private FragmentTshirtsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentTshirtsBinding.inflate(inflater, container, false);

        // Aquí luego pondrás la lógica para mostrar los productos
        return binding.getRoot();
    }
}
