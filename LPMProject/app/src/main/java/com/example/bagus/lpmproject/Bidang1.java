package com.example.bagus.lpmproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Bidang1 extends AppCompatActivity {

    Button next;
    EditText nmasjid, adres,imb,Luasbangun,luas_lahan,sertifikate,surate, asal_jamaah;
    String namamasjid, alamat, luas, imbb, luaslahan, sertifikat, status, surat, asal;
    RadioButton Status;
    RadioGroup statusgrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bidang1);

        next = (Button)findViewById(R.id.lanjut);
        nmasjid = (EditText) findViewById(R.id.nmasjid);
        adres = (EditText)findViewById(R.id.adres);
        Luasbangun = (EditText)findViewById(R.id.Luasbangun);
        imb = (EditText)findViewById(R.id.imb);
        luas_lahan = (EditText)findViewById(R.id.Luas);
        sertifikate=(EditText)findViewById(R.id.sertifikat);
        surate = (EditText)findViewById(R.id.surat);
        asal_jamaah = (EditText) findViewById(R.id.asaljamaah);
        statusgrop = (RadioGroup) findViewById(R.id.status);



       next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pilih = statusgrop.getCheckedRadioButtonId();
                Status = (RadioButton)findViewById(pilih);

                namamasjid = nmasjid.getText().toString();
                alamat = adres.getText().toString();
                luas= Luasbangun.getText().toString();
                imbb = imb.getText().toString();
                luaslahan = luas_lahan.getText().toString();
                sertifikat = sertifikate.getText().toString();
                surat = surate.getText().toString();
                status = Status.getText().toString();
                asal = asal_jamaah.getText().toString();

                Intent a = new Intent(Bidang1.this, Bidang12.class);
                a.putExtra("b1_nama", namamasjid);
                a.putExtra("b1_alamat", alamat);
                a.putExtra("b1_luas", luas);
                a.putExtra("b1_imb", imbb);
                a.putExtra("b1_luas_lahan", luaslahan);
                a.putExtra("b1_sertifikat", sertifikat);
                a.putExtra("b1_surat", surat);
                a.putExtra("b1_status",status);
                a.putExtra("b1_asal",asal);
                startActivity(a);
            }
        });
    }



}
