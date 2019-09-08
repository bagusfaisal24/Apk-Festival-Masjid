package com.example.bagus.lpmproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Bidang12 extends AppCompatActivity {
    String namamasjid, alamat, luas, imbb, luaslahan, sertifikat, status, surat, asal;
    String penduduk1, penduduk2, penduduk3, penduduk4, islam1, islam2, islam3, non1,non2, longitude, latitude;
    EditText umursatu,umurdua,umurtiga,umurempat, tidakshalat, shalat,berjamaah1, aktif,tidakaktif,longi, lati;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidang12);
        save = (Button)findViewById(R.id.simpan);

        umursatu = (EditText) findViewById(R.id.umur1);
        umurdua = (EditText) findViewById(R.id.umur2);
        umurtiga = (EditText)findViewById(R.id.umur3);
        umurempat = (EditText)findViewById(R.id.umur4);
        tidakshalat = (EditText)findViewById(R.id.tdksholat);
        shalat = (EditText)findViewById(R.id.sholat);
        berjamaah1 = (EditText)findViewById(R.id.berjamaah);
        aktif=(EditText)findViewById(R.id.aktfibadah);
        tidakaktif = (EditText)findViewById(R.id.tdkibadah);
        longi = (EditText) findViewById(R.id.longi);
        lati = (EditText) findViewById(R.id.lati);




        Intent a = getIntent();
        namamasjid = a.getStringExtra("b1_nama");
        alamat = a.getStringExtra("b1_alamat");
        luas =a.getStringExtra("b1_luas");
        imbb = a.getStringExtra("b1_imb");
        luaslahan = a.getStringExtra("b1_luas_lahan");
        sertifikat = a.getStringExtra("b1_sertifikat");
        surat =a.getStringExtra("b1_surat");
        status = a.getStringExtra("b1_status");
        asal = a.getStringExtra("b1_asal");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                penduduk1 = umursatu.getText().toString();
                penduduk2 = umurdua.getText().toString();
                penduduk3 = umurtiga.getText().toString();
                penduduk4 = umurempat.getText().toString();
                islam2 = tidakshalat.getText().toString();
                islam1 = shalat.getText().toString();
                islam3 = berjamaah1.getText().toString();
                non1 = aktif.getText().toString();
                non2 = tidakaktif.getText().toString();
                longitude = longi.getText().toString();
                latitude = lati.getText().toString();

                send();
            }
        });
    }

    private void send(){

        StringRequest jArr = new StringRequest(Request.Method.POST,HostAddress.url + "LPMUAD/bidangsatu.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("E", error.getMessage());
                Toast.makeText(Bidang12.this, "cek koneksi anda" , Toast.LENGTH_LONG).show();

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("b1_nama",namamasjid);
                param.put("b1_alamat",alamat);
                param.put("b1_imb",imbb);
                param.put("b1_luas",luas);
                param.put("b1_luas_lahan",luaslahan);
                param.put("b1_sertifikat",sertifikat);
                param.put("b1_status",status);
                param.put("b1_surat",surat );
                param.put("b1_asal",asal );
                param.put("b1_penduduk1",penduduk1);
                param.put("b1_penduduk2",penduduk2);
                param.put("b1_penduduk3",penduduk3);
                param.put("b1_penduduk4",penduduk4);
                param.put("b1_islam1",islam1);
                param.put("b1_islam2",islam2);
                param.put("b1_islam3",islam3);
                param.put("b1_non1",non1);
                param.put("b1_non2",non2);
                param.put("b1_longitude",longitude);
                param.put("b1_latitude",latitude);

                return param;
            }
        };


        Volley.newRequestQueue(getApplicationContext()).add(jArr);
    }
}
