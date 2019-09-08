package com.example.bagus.lpmproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UpdateData extends AppCompatActivity {
    final String TAG = this.getClass().getName();
    private ProgressDialog pDialog;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    SessionManager session;
    private Context context;
    EditText nmasjid, adres,imb,Luasbangun,luas_lahan,sertifikate,surate, asal_jamaah;
    EditText umursatu,umurdua,umurtiga,umurempat, tidakshalat, shalat,berjamaah1, aktif,tidakaktif,longi, lati, ketua1;

    String namamasjid, alamat, luas, imbb, luaslahan, sertifikat, status, surat, asal;
    String penduduk1, penduduk2, penduduk3, penduduk4, islam1, islam2, islam3, non1,non2, longitude, latitude;
    RadioGroup statusgrop;
    RadioButton keluarga, wakaf, yayasan, Status;

    Button upd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_update_data);
        session = new SessionManager(getApplicationContext());

        HashMap<String, String> data = session.getUserDetails();
        final String idUser= data.get(SessionManager.KEY_NAME);

        nmasjid= (EditText) findViewById(R.id.nmasjid);
        adres= (EditText) findViewById(R.id.adres);
        Luasbangun= (EditText) findViewById(R.id.Luasbangun);
        imb = (EditText) findViewById(R.id.imb);
        luas_lahan= (EditText) findViewById(R.id.Luas);
        sertifikate= (EditText) findViewById(R.id.sertifikat);
        surate = (EditText) findViewById(R.id.surat);
        asal_jamaah = (EditText) findViewById(R.id.asaljamaah);
        upd = (Button)findViewById(R.id.update);

        ketua1=(EditText)findViewById(R.id.ketua);
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
        statusgrop = (RadioGroup)findViewById(R.id.status);
        wakaf = (RadioButton)findViewById(R.id.wakaf);
        keluarga = (RadioButton)findViewById(R.id.keluarga);
        yayasan = (RadioButton)findViewById(R.id.yayasan);

        Bundle bundle;
        bundle = getIntent().getExtras();

        nmasjid.setText(bundle.getString("b1_nama"));
        adres.setText(bundle.getString("b1_alamat"));
        Luasbangun.setText(bundle.getString("b1_luas"));
        imb.setText(bundle.getString("b1_imb"));
        luas_lahan.setText(bundle.getString("b1_luas_lahan"));
        sertifikate.setText(bundle.getString("b1_sertifikat"));
        status = bundle.getString("b1_status");
        surate.setText(bundle.getString("b1_surat"));
        asal_jamaah.setText(bundle.getString("b1_asal"));

        umursatu.setText(bundle.getString("b1_penduduk1"));
        umurdua.setText(bundle.getString("b1_penduduk2"));
        umurtiga.setText(bundle.getString("b1_penduduk3"));
        umurempat.setText(bundle.getString("b1_penduduk4"));
        tidakshalat.setText(bundle.getString("b1_islam1"));
        shalat.setText(bundle.getString("b1_islam2"));
        berjamaah1.setText(bundle.getString("b1_islam3"));
        aktif.setText(bundle.getString("b1_non1"));
        tidakaktif.setText(bundle.getString("b1_non2"));
        longi.setText(bundle.getString("b1_longitude"));
        lati.setText(bundle.getString("b1_latitude"));

        if (status.equals("Wakaf")){
            wakaf.setChecked(true);
            yayasan.setChecked(false);
            keluarga.setChecked(false);
        }else if(status.equals("Yayasan")){
            wakaf.setChecked(false);
            yayasan.setChecked(true);
            keluarga.setChecked(false);
        }else if(status.equals("Keluarga")){
            wakaf.setChecked(false);
            yayasan.setChecked(false);
            keluarga.setChecked(true);
        }

            upd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    update(idUser);
                }
            });
    }

    private void update(final String idUser){
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

        StringRequest jArr = new StringRequest(Request.Method.POST,HostAddress.url + "api/updateb1/1234/"+ idUser,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.e("eee",response.toString());
                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("E", error.getMessage());
                Toast.makeText(UpdateData.this, "cek koneksi anda" , Toast.LENGTH_SHORT).show();

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
