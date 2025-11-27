package com.example.apptienda.ui.compras;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.apptienda.R;
import com.example.apptienda.databinding.FragmentComprasBinding;

// ****************************************** ITEM DE COMPRAS

public class ComprasFragment extends Fragment {

    private FragmentComprasBinding binding; //Declaracion del layout itemen menu compraS
    private MediaPlayer sonidoBtn;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //BIDING , PARA LLAMADO ALOS COMPONENTES DE LA PANTALLA BIENVEIDA a la tienda
        binding = FragmentComprasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        sonidoBtn = MediaPlayer.create(requireContext(), R.raw.click4);

        super.onViewCreated(view, savedInstanceState);

        // ACCION DEL BOTON 1 ( T.SHIRTS )
        binding.btn1.setOnClickListener(v -> {
            sonidoBtn.start(); // sonido de navegacion
            NavHostFragment.findNavController(ComprasFragment.this)
                    .navigate(R.id.action_compras_to_camisetas); // NAVEGACION PANTALLA CAMISETAS ( VAR DECLARADA DESDE MOBLIE NAVIGATION)
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
