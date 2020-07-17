package com.radita.informasipenyakitjantung.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.radita.informasipenyakitjantung.R;

public class activity_hasil_kuis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_kuis);

//        TextView your_name = (TextView) findViewById(R.id.lastd);
        TextView hasilnilai = (TextView) findViewById(R.id.tv_hasil);
        Intent mint = getIntent();
        String value =  mint.getStringExtra("total");
//        String s = mint.getStringExtra("user_name");
//        your_name.setText(s);
        hasilnilai.setText(value);
        //Log.d("last",s);
    }
}
