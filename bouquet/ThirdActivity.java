package com.example.jualan;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    private TextView nama, alamat, telepon, catatan, mShowCount, metode, NmItem, spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        nama = findViewById(R.id.nama);
        alamat = findViewById(R.id.alamat);
        telepon = findViewById(R.id.telepon);
        catatan = findViewById(R.id.catatan);
        mShowCount = findViewById(R.id.jumlah);
        metode = findViewById(R.id.metode);
        NmItem = findViewById(R.id.textView11);
        spinner = findViewById(R.id.spiner);


        String usernama = getIntent().getStringExtra("keynama");
        String useralamat = getIntent().getStringExtra("keyalamat");
        String usertelepon = getIntent().getStringExtra("keytelepon");
        String usercatatan = getIntent().getStringExtra("keycatatan");
        String userjumlah = getIntent().getStringExtra("keyjumlah");
        String usermetode = getIntent().getStringExtra("keymetode");
        String useritem = getIntent().getStringExtra("keyNmItem");
        String userukuran = getIntent().getStringExtra("keyukuran");


        nama.setText(": "+usernama);
        alamat.setText(": "+useralamat);
        telepon.setText(": "+usertelepon);
        catatan.setText(": "+usercatatan);
        mShowCount.setText(": "+userjumlah);
        metode.setText(": "+usermetode);
        spinner.setText("Ukuran "+userukuran);
        NmItem.setText(useritem);


    }
}