package com.radita.informasipenyakitjantung.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.radita.informasipenyakitjantung.R;
import com.radita.informasipenyakitjantung.fragment.fragment_beranda;
import com.radita.informasipenyakitjantung.fragment.fragment_ciripenyakit;
import com.radita.informasipenyakitjantung.fragment.fragment_pencegahan;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            fragment_beranda fragmentBeranda = new fragment_beranda();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, fragmentBeranda)
                    .commit();
        }
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        MediaPlayer mp;

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment_beranda fragmentBeranda = new fragment_beranda();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, fragmentBeranda)
                            .commit();
                    return true;

                case R.id.navigation_carapencegahan:
                    fragment_pencegahan fragmentPencegahan = new fragment_pencegahan();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, fragmentPencegahan)
                            .commit();
                    return true;

                case R.id.navigation_ciripenyakitjantung:
                    fragment_ciripenyakit fragmentCiripenyakit = new fragment_ciripenyakit();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, fragmentCiripenyakit)
                            .commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MulaiKuis:
                Intent intentKuis = new Intent(this, activity_mulai_kuis.class);
                startActivity(intentKuis);
                break;
            case R.id.menuTentang:
                Intent intentTentang = new Intent(this, activity_tentang.class);
                startActivity(intentTentang);
                break;
            case R.id.keluarMenu:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(false);
                builder.setMessage("Apa kamu yakin ingin keluar?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
