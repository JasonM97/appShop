package com.example.apptienda.ui.contact;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.apptienda.R;
import com.example.apptienda.databinding.FragmentContactBinding;

public class ContactFragment extends Fragment {

    private FragmentContactBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ContactViewModel contactViewModel =
                new ViewModelProvider(this).get(ContactViewModel.class);

        binding = FragmentContactBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // CONFIGURACION PARA EL TEXTVIEW
        final TextView textView = binding.textContacto;
        contactViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // CONFIGURACION PARA EL MAPA DE LA UBIACION DE LA TIENDA
        ImageView imgMapa = root.findViewById(R.id.imgMapa); //ENRUTO EL ID de la imagne del mapa
        // 🔹 Agregar hipervínculo al mapa
        imgMapa.setOnClickListener(v -> {
            // Coordenadas de ejemplo Quito
            String geoUri = "geo:0,0?q=Universidad+Nacional+de+Chimborazo+Riobamba";

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        });


         // FUNCIONALIDADDES DE DE LOS BOTONES DE CONTACTO

        //Para Whatsapp
        ImageButton btnWhatsapp = root.findViewById(R.id.btnWash);

        btnWhatsapp.setOnClickListener(v -> {
            String numero = "+593958699390"; // AQUI CAMBIMOS EL NUMERO DE TELEFONO
            String url = "https://wa.me/" + numero;

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });

        //Para Whatsapp
        ImageButton btnTelefono = root.findViewById(R.id.btnTelf);

        btnTelefono.setOnClickListener(v -> {
            String numeroTel = "0958699390"; // AQUI CAMBIMOS EL NUMERO DE TELEFONO
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + numeroTel));
            startActivity(intent);
        });

        //Para Mail
        ImageButton btnCorreo = root.findViewById(R.id.btnMail);

        btnCorreo.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:samantha.trujillo@unach.edu.ec ")); // tu correo
            intent.putExtra(Intent.EXTRA_SUBJECT, "Consulta sobre la tienda");
            intent.putExtra(Intent.EXTRA_TEXT, "Hola, tengo una consulta sobre...");
            startActivity(intent);
        });




        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}