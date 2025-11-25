package com.example.apptienda.ui.detallecompra;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.apptienda.databinding.FragmentDetalleCompraBinding;

public class DetalleCompraFragment extends Fragment {

    private FragmentDetalleCompraBinding binding;
    private int cantidad = 1;
    private double precio = 14.99;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetalleCompraBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Mostramos cantidad inicial
        binding.txtCantidad.setText(String.valueOf(cantidad));

        // Mostramos total inicial
        actualizarTotal();

        // -------- BOTÓN SUMAR --------
        binding.btnSumar.setOnClickListener(v -> {
            cantidad++;
            binding.txtCantidad.setText(String.valueOf(cantidad));
            actualizarTotal();
        });

        // -------- BOTÓN RESTAR --------
        binding.btnRestar.setOnClickListener(v -> {
            if (cantidad > 1) { // Evita que baje a cero o negativo
                cantidad--;
                binding.txtCantidad.setText(String.valueOf(cantidad));
                actualizarTotal();
            }
        });

        // Botón regresar
        binding.btnBack.setOnClickListener(v -> {
            NavHostFragment.findNavController(DetalleCompraFragment.this).popBackStack();
        });

        binding.btnComprar.setOnClickListener(v -> {
            new AlertDialog.Builder(getContext())
                    .setTitle("Confirmación")
                    .setMessage("¿Estás seguro que deseas comprar este producto?")
                    .setPositiveButton("Sí", (dialog, which) -> {
                        // Aquí va la acción real de comprar
                        Toast.makeText(getContext(), "Compra realizada", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
        });

        binding.btnEliminar.setOnClickListener(v -> {
            new AlertDialog.Builder(getContext())
                    .setTitle("Advertencia")
                    .setMessage("¿Estás seguro que deseas eliminar este producto?")
                    .setPositiveButton("Eliminar", (dialog, which) -> {
                        // Acción de eliminar
                        Toast.makeText(getContext(), "Producto eliminado", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void actualizarTotal() {
        double total = precio * cantidad;
        binding.txtTotal.setText(String.format("$ %.2f", total));
    }

}
