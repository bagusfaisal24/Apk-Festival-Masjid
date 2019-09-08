package com.example.bagus.lpmproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class TampilDataALL extends AppCompatActivity {
    Button b1,b2,b3,b4;
    private Context context;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    SessionManager session;
    TextView dataUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data_all);
        session = new SessionManager(getApplicationContext());
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);

        HashMap<String, String> data = session.getUserDetails();
        final String idUser= data.get(SessionManager.KEY_NAME);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadDatab1(idUser);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadDatab2(idUser);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadDatab3(idUser);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadDatab4(idUser);
            }
        });
    }
    public void LoadDatab1(final String idUser ) {

        StringRequest strReq = new StringRequest(Request.Method.POST,
                HostAddress.url + "LPMUAD/get.php?id=" + idUser, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("eee",response.toString());
                try {

                    JSONObject obj = new JSONObject(response);

                        String nama = obj.getString("b1_nama");
                        String alamat = obj.getString("b1_alamat");
                        String luas = obj.getString("b1_luas");
                        String imb = obj.getString("b1_imb");
                        String luaslahan = obj.getString("b1_luas_lahan");
                        String sertifikat = obj.getString("b1_sertifikat");
                        String status1 = obj.getString("b1_status");
                        String surat = obj.getString("b1_surat");
                        String asal = obj.getString("b1_asal");

                        String penduduk1 = obj.getString("b1_penduduk1");
                        String penduduk2 = obj.getString("b1_penduduk2");
                        String penduduk3 = obj.getString("b1_penduduk3");
                        String penduduk4 = obj.getString("b1_penduduk4");
                        String islam1= obj.getString("b1_islam1");
                        String islam2 = obj.getString("b1_islam2");
                        String islam3 = obj.getString("b1_islam3");
                        String non1 = obj.getString("b1_non1");
                        String non2= obj.getString("b1_non2");
                        String longitude = obj.getString("b1_longitude");
                        String latitude = obj.getString("b1_latitude");

                        Intent intent = new Intent(TampilDataALL.this, UpdateData.class);
                        intent.putExtra("b1_nama", nama);
                        intent.putExtra("b1_alamat", alamat);
                        intent.putExtra("b1_luas", luas);
                        intent.putExtra("b1_imb", imb);
                        intent.putExtra("b1_luas_lahan",luaslahan);
                        intent.putExtra("b1_sertifikat",sertifikat);
                        intent.putExtra("b1_status",status1);
                        intent.putExtra("b1_surat", surat);
                        intent.putExtra("b1_asal", asal);


                    intent.putExtra("b1_penduduk1",penduduk1);
                        intent.putExtra("b1_penduduk2",penduduk2);
                        intent.putExtra("b1_penduduk3",penduduk3);
                        intent.putExtra("b1_penduduk4",penduduk4);
                        intent.putExtra("b1_islam1",islam1);
                        intent.putExtra("b1_islam2",islam2);
                        intent.putExtra("b1_islam3",islam3);
                        intent.putExtra("b1_non1",non1);
                        intent.putExtra("b1_non2",non2);
                        intent.putExtra("b1_longitude",longitude);
                        intent.putExtra("b1_latitude", latitude);
                        startActivity(intent);


                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(context, "The server unreachable", Toast.LENGTH_SHORT).show();
                    }
                });
        Volley.newRequestQueue(this).add(strReq);

    }

    public void LoadDatab2(final String idUser ) {

        StringRequest strReq = new StringRequest(Request.Method.POST,
                HostAddress.url + "LPMUAD/get.php?id=" + idUser, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("eee",response.toString());
                try {

                    JSONObject obj = new JSONObject(response);

                    String namappan = obj.getString("b2_namapapan");
                    String maket = obj.getString("b2_maket");
                    String simbol = obj.getString("b2_simbol");
                    String artistik = obj.getString("b2_artistik");
                    String kemegahan = obj.getString("b2_kemegahan");
                    String kebersihan = obj.getString("b2_kebersihan");
                    String parkir = obj.getString("b2_parkir");
                    String nyaman = obj.getString("b2_nyaman");
                    String aman = obj.getString("b2_aman");

                    String artistik2 = obj.getString("b2_artistik2");
                    String najis = obj.getString("b2_najis");
                    String indah = obj.getString("b2_indah");
                    String sehat = obj.getString("b2_sehat");
                    String ketua= obj.getString("b2_ketua");
                    String sekretaris = obj.getString("b2_sekretaris");
                    String bendahara = obj.getString("b2_bendahara");
                    String sholatsubuh = obj.getString("b2_sholatsubuh");
                    String sholatdzuhur= obj.getString("b2_sholatdzuhur");
                    String sholatmaghrib = obj.getString("b2_sholatmaghrib");


                    Intent intent = new Intent(TampilDataALL.this, UpBidang2.class);
                    intent.putExtra("b2_namapapan", namappan);
                    intent.putExtra("b2_maket", maket);
                    intent.putExtra("b2_simbol", simbol);
                    intent.putExtra("b2_artistik", artistik);
                    intent.putExtra("b2_kemegahan",kemegahan);
                    intent.putExtra("b2_kebersihan",kebersihan);
                    intent.putExtra("b2_parkir",parkir);
                    intent.putExtra("b2_nyaman",nyaman);
                    intent.putExtra("b2_aman",aman);

                    intent.putExtra("b2_artistik2",artistik2);
                    intent.putExtra("b2_najis",najis);
                    intent.putExtra("b2_indah",indah);
                    intent.putExtra("b2_sehat",sehat);
                    intent.putExtra("b2_ketua",ketua);
                    intent.putExtra("b2_sekretaris",sekretaris);
                    intent.putExtra("b2_bendahara",bendahara);
                    intent.putExtra("b2_sholatsubuh",sholatsubuh);
                    intent.putExtra("b2_sholatdzuhur",sholatdzuhur);
                    intent.putExtra("b2_sholatmaghrib",sholatmaghrib);
                    startActivity(intent);


                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(context, "The server unreachable", Toast.LENGTH_SHORT).show();
                    }
                });
        Volley.newRequestQueue(this).add(strReq);

    }
    public void LoadDatab3(final String idUser ) {

        StringRequest strReq = new StringRequest(Request.Method.POST,
                HostAddress.url + "LPMUAD/get.php?id=" + idUser, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("eee",response.toString());
                try {

                    JSONObject obj = new JSONObject(response);

                    String wudhu = obj.getString("b3_wudhu");
                    String kamar = obj.getString("b3_kamar");
                    String air = obj.getString("b3_air");
                    String sound = obj.getString("b3_sound");
                    String gudang = obj.getString("b3_gudang");
                    String parkir = obj.getString("b3_lahan");
                    String kantor = obj.getString("b3_kantor");
                    String jarak = obj.getString("b3_jarak");
                    String perpus = obj.getString("b3_perpustakaan");
                    String audio = obj.getString("b3_audio");
                    String projector = obj.getString("b3_projector");
                    String inap = obj.getString("b3_penginapan");
                    String taman = obj.getString("b3_taman");
                    String lainnya = obj.getString("b3_lainnya");
                    String petugas = obj.getString("b3_petugas");
                    String pengurus = obj.getString("b3_pengurus");
                    String surat = obj.getString("b3_surat");
                    String kualitas = obj.getString("b3_kualitassurat");
                    String visi = obj.getString("b3_visimisi");
                    String remas = obj.getString("b3_remaja");
                    String yayasan = obj.getString("b3_yayasan");




                    Intent intent = new Intent(TampilDataALL.this, UpBidang3.class);
                    intent.putExtra("b3_wudhu", wudhu);
                    intent.putExtra("b3_kamar", kamar);
                    intent.putExtra("b3_air", air);
                    intent.putExtra("b3_sound", sound);
                    intent.putExtra("b3_gudang", gudang);
                    intent.putExtra("b3_lahan", parkir);
                    intent.putExtra("b3_kantor", kantor);
                    intent.putExtra("b3_jarak", jarak);
                    intent.putExtra("b3_perpustakaan", perpus);
                    intent.putExtra("b3_audio", audio);
                    intent.putExtra("b3_projector", projector);
                    intent.putExtra("b3_penginapan", inap);
                    intent.putExtra("b3_taman", taman);
                    intent.putExtra("b3_lainnya", lainnya);
                    intent.putExtra("b3_petugas", petugas);
                    intent.putExtra("b3_pengurus", pengurus);
                    intent.putExtra("b3_surat", surat);
                    intent.putExtra("b3_kualitassurat", kualitas);
                    intent.putExtra("b3_visimisi", visi);
                    intent.putExtra("b3_remaja", remas);
                    intent.putExtra("b3_yayasan", yayasan);

                    startActivity(intent);


                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(context, "The server unreachable", Toast.LENGTH_SHORT).show();
                    }
                });
        Volley.newRequestQueue(this).add(strReq);

    }
    public void LoadDatab4(final String idUser ) {

        StringRequest strReq = new StringRequest(Request.Method.POST,
                HostAddress.url + "LPMUAD/get.php?id=" + idUser, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("eee",response.toString());
                try {

                    JSONObject obj = new JSONObject(response);


                    String Stpa = obj.getString("b4_tpa");
                    String Sanak = obj.getString("b4_anak");
                    String Sseni = obj.getString("b4_seni");
                    String Sphbi = obj.getString("b4_haribesar");
                    String Spengajian = obj.getString("b4_pengajian");
                    String Solahraga = obj.getString("b4_olahraga");
                    String Stadarus = obj.getString("b4_tadarus");
                    String Skajian = obj.getString("b4_keagamaan");
                    String Sgender = obj.getString("b4_gender");
                    String Smsy = obj.getString("b4_pemberdayaan");
                    String Spendidikan = obj.getString("b4_pendidikan");
                    String Spentas = obj.getString("b4_pentas");
                    String Stafsir = obj.getString("b4_tafsir");
                    String Smadrasah = obj.getString("b4_madrasah");
                    String Stk = obj.getString("b4_tk");
                    String Ssd = obj.getString("b4_sd");
                    String Ssmp = obj.getString("b4_sltp");
                    String Ssma = obj.getString("b4_slta");
                    String Sklinik = obj.getString("b4_klinik");
                    String Stahfiz = obj.getString("b4_tahfiz");


                    Intent intent = new Intent(TampilDataALL.this, UpBidang4.class);
                    intent.putExtra("b4_tpa", Stpa);
                    intent.putExtra("b4_anak", Sanak);
                    intent.putExtra("b4_seni", Sseni);
                    intent.putExtra("b4_haribesar", Sphbi);
                    intent.putExtra("b4_pengajian", Spengajian);
                    intent.putExtra("b4_olahraga", Solahraga);
                    intent.putExtra("b4_tadarus", Stadarus);
                    intent.putExtra("b4_keagamaan", Skajian);
                    intent.putExtra("b4_gender", Sgender);
                    intent.putExtra("b4_pemberdayaan", Smsy);
                    intent.putExtra("b4_pendidikan", Spendidikan);
                    intent.putExtra("b4_pentas", Spentas);
                    intent.putExtra("b4_tafsir", Stafsir);
                    intent.putExtra("b4_madrasah", Smadrasah);
                    intent.putExtra("b4_tk", Stk);
                    intent.putExtra("b4_sd", Ssd);
                    intent.putExtra("b4_sltp", Ssmp);
                    intent.putExtra("b4_slta", Ssma);
                    intent.putExtra("b4_klinik", Sklinik);
                    intent.putExtra("b4_tahfiz", Stahfiz);
                    startActivity(intent);


                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(context, "The server unreachable", Toast.LENGTH_SHORT).show();
                    }
                });
        Volley.newRequestQueue(this).add(strReq);

    }

}
