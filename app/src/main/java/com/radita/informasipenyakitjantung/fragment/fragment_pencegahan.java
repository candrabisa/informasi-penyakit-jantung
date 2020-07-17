package com.radita.informasipenyakitjantung.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.radita.informasipenyakitjantung.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_pencegahan extends Fragment {

    public fragment_pencegahan() {
        // Required empty public constructor
    }

    MediaPlayer mp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pencegahan, container, false);

        FloatingActionButton fb_SoundBeranda = view.findViewById(R.id.fb_pencegahanJtg);
        mp = MediaPlayer.create(getContext(), R.raw.cara_jantung);
        fb_SoundBeranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp = MediaPlayer.create(getContext(), R.raw.cara_jantung);
                    } else {
                        mp.start();
                    }
                } catch(Exception e) { e.printStackTrace(); }
            }
        });

        return view;
    }
    @Override
    public void onPause() {
        super.onPause();
        mp.pause();
    }
}
