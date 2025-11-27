package com.example.apptienda.ui.reels;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.apptienda.R;
import com.example.apptienda.databinding.FragmentReelsBinding;

public class ReelsFragment extends Fragment {

    private FragmentReelsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ReelsViewModel reelsViewModel =
                new ViewModelProvider(this).get(ReelsViewModel.class);

        binding = FragmentReelsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        // CONFIGURACION PARA EL TEXTVIEW
        final TextView textView = binding.textReels; //TOCA LLAMAR
        reelsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // Configurar videos con sus botones
        setupVideoWithPlayButton(binding.videoView1, binding.btnPlay1, R.raw.video1);
        setupVideoWithPlayButton(binding.videoView2, binding.btnPlay2, R.raw.video2);
        return root;
    }


    //CLASE PARA LAS OCCINES DE LOS BOTNOES Y REPRODUCCION
    private void setupVideoWithPlayButton(VideoView videoView, ImageButton playButton, int rawResId) {

        // Cargar video
        Uri uri = Uri.parse("android.resource://" + requireContext().getPackageName() + "/" + rawResId);
        videoView.setVideoURI(uri);

        // Repetir al terminar
        videoView.setOnCompletionListener(mp -> {
            mp.start();
            playButton.setImageResource(android.R.drawable.ic_media_play); // volver a mostrar play
        });

        // Acción del botón
        playButton.setOnClickListener(v -> {
            if (videoView.isPlaying()) {
                videoView.pause();
                playButton.setImageResource(android.R.drawable.ic_media_play);
            } else {
                videoView.start();
                playButton.setImageResource(android.R.drawable.ic_media_pause);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Detener videos para liberar recursos
        if (binding != null) {
            binding.videoView1.stopPlayback();
            binding.videoView2.stopPlayback();
        }
        binding = null;


    }
}