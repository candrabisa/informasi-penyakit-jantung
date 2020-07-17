package com.radita.informasipenyakitjantung.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.radita.informasipenyakitjantung.R;


public class activity_tentang extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(R.string.tentang);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Button btnIG = findViewById(R.id.btn_instagram);
        btnIG.setOnClickListener(this);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View view){
        if (view.getId() == R.id.btn_instagram){
            String url = "https://www.instagram.com/raditafebriani11/?hl=id";
            Uri parseUrl = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, parseUrl);
            startActivity(intent);
        }
    }

}
