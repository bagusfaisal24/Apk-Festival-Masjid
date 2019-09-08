package com.example.bagus.lpmproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class KlasMasjid extends AppCompatActivity {
    RadioGroup a,b,c,d,e,f,g,h,i,j,k,l;
    RadioButton a1,b1,c1,d1,e1,f1,g1,h1,i1,j1,k1,l1;
    String tempatwudlu, kamarmandi,air, soundsystem, gudang,soundaudio, lahanparkir, kantortakmir, jaraktempatwudlu, perpus, taman, penginapantamu;
    Button simpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klas_masjid);
        simpan = (Button)findViewById(R.id.simpan);
        a = (RadioGroup)findViewById(R.id.wudlu);
        b = (RadioGroup)findViewById(R.id.toilet);
        c = (RadioGroup)findViewById(R.id.ketersediaanair);
        d = (RadioGroup)findViewById(R.id.Soundsystem);
        e = (RadioGroup)findViewById(R.id.Gudangpenyimpananbarang);
        f = (RadioGroup)findViewById(R.id.SoundsystemdanAudioVisual);
        g = (RadioGroup)findViewById(R.id.lahanparkir);
        h = (RadioGroup)findViewById(R.id.kantor);
        i = (RadioGroup)findViewById(R.id.jaraktempatwudlu);
        j = (RadioGroup)findViewById(R.id.perpus);
        k = (RadioGroup)findViewById(R.id.inap);
        l = (RadioGroup)findViewById(R.id.taman);


        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aa = a.getCheckedRadioButtonId();
                a1 = (RadioButton)findViewById(aa);
                tempatwudlu = a1.getText().toString();

                int bb = b.getCheckedRadioButtonId();
                b1 = (RadioButton)findViewById(bb);
                kamarmandi = b1.getText().toString();

                int cc = c.getCheckedRadioButtonId();
                c1 = (RadioButton)findViewById(cc);
                air = c1.getText().toString();

                int dd = d.getCheckedRadioButtonId();
                d1 = (RadioButton)findViewById(dd);
                soundsystem = d1.getText().toString();

                int ee = e.getCheckedRadioButtonId();
                e1 = (RadioButton)findViewById(ee);
                gudang = e1.getText().toString();

                int ff = f.getCheckedRadioButtonId();
                f1 = (RadioButton)findViewById(ff);
                soundaudio = f1.getText().toString();

                int gg = g.getCheckedRadioButtonId();
                g1 = (RadioButton)findViewById(gg);
                lahanparkir = g1.getText().toString();

                int hh = h.getCheckedRadioButtonId();
                h1 = (RadioButton)findViewById(hh);
                kantortakmir = h1.getText().toString();

                int ii = i.getCheckedRadioButtonId();
                i1 = (RadioButton)findViewById(ii);
                jaraktempatwudlu = i1.getText().toString();

                int jj = j.getCheckedRadioButtonId();
                j1 = (RadioButton)findViewById(jj);
                perpus = j1.getText().toString();

                int kk = k.getCheckedRadioButtonId();
                k1 = (RadioButton)findViewById(kk);
                penginapantamu = k1.getText().toString();

                int ll = l.getCheckedRadioButtonId();
                l1 = (RadioButton)findViewById(ll);
                taman = l1.getText().toString();


            }
        });

    }

//    private void send(){
//
//        StringRequest jArr = new StringRequest(Request.Method.POST,HostAddress.url + "Service/bidangsatu.php",
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
//
//                    }
//                }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.e("E", "data " + error.getMessage());
//                Toast.makeText(Bidang12.this, error.getMessage(), Toast.LENGTH_LONG).show();
//
//            }
//        }) {
//
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> param = new HashMap<>();
//                param.put("nama_masjid", nama_masjid );
//                param.put("alamat", alamat );
//                param.put("luas_bangunan", luas_bangunan );
//                param.put("IMB", IMB );
//                param.put("luas_lahan", luas );
//                param.put("sertifikat", sertifikat );
//                param.put("surat", surat );
//                param.put("status", status );
//                param.put("umurkurang12tahun", umur1 );
//                param.put("umur12sampai17tahun", umur2 );
//                param.put("umur18sampai60tahun", umur3 );
//                param.put("umurlebihdari60tahun", umur4 );
//                param.put("tidaksholat", tidaksholat);
//                param.put("shalat", sholat );
//                param.put("aktif_jamaah", berjamaah );
//                param.put("tidakaktifberibadah", tdkaktifibadah );
//                param.put("aktifketempatibadah", aktifibadah);
//                param.put("data_gps", gpsstring );
//                param.put("asal_jamaah", asaljamaah );
//
//
//                return param;
//            }
//        };
//
//
//        Volley.newRequestQueue(getApplicationContext()).add(jArr);
//    }
}
