package com.example.bagus.lpmproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bagus.lpmproject.pojo.Bidangsatu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button b1;
    private Context context;
    private TextView mTextMessage;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    SessionManager session;


    final String TAG = this.getClass().getName();
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            HashMap<String, String> user = session.getUserDetails();
            final String idUser = user.get(SessionManager.KEY_NAME);
            switch (item.getItemId()) {
                case R.id.navigation_bidang1:
//                    Intent bidang1 = new Intent(MainActivity.this, Bidang1.class);
//                    startActivity(bidang1);
                    LoadDatab1(idUser);
                    return true;
                case R.id.navigation_bidang2:
//                    Intent bidang2 = new Intent(MainActivity.this, Bidang2.class);
//                    startActivity(bidang2);
                    LoadDatab2(idUser);
                    return true;
                case R.id.navigation_bidang3:
//                    Intent bidang3 = new Intent(MainActivity.this, KlasMasjid.class);
//                    startActivity(bidang3);
                    LoadDatab3(idUser);
                    return true;
                case R.id.navigation_bidang4:
//                    Intent bidang4 = new Intent(MainActivity.this, Bidang4.class);
//                    startActivity(bidang4);
                    LoadDatab4(idUser);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManager(getApplicationContext());
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        session.checkLogin();




    }

    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
//        alertDialogBuilder.setTitle("Keluar dari aplikasi?");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Keluar dari aplikasi?")
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        session.logoutUser();
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });


        AlertDialog alertDialog = alertDialogBuilder.create();


        alertDialog.show();
    }
    public void LoadDatab1(final String idUser) {

        JsonArrayRequest strReq = new JsonArrayRequest(Request.Method.GET,
                HostAddress.url + "api/getdatabidang/1234/"+idUser+"/1", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("eee",response.toString());
                for (int i = 0; i < response.length(); i++) {
                    try {

                        JSONObject obj = response.getJSONObject(i);

                        String nama = obj.getString("b1_nama");
                        String alamat = obj.getString("b1_alamat");
                        String imb = obj.getString("b1_imb");
                        String luas = obj.getString("b1_luas");
                        String luaslahan = obj.getString("b1_luas_lahan");
                        String sertifikat = obj.getString("b1_sertifikat");
                        String status1 = obj.getString("b1_status");
                        String surat = obj.getString("b1_surat");
                        String asal = obj.getString("b1_asal");
                        String penduduk1 = obj.getString("b1_penduduk1");
                        String penduduk2 = obj.getString("b1_penduduk2");
                        String penduduk3 = obj.getString("b1_penduduk3");
                        String penduduk4 = obj.getString("b1_penduduk4");
                        String islam1 = obj.getString("b1_islam1");
                        String islam2 = obj.getString("b1_islam2");
                        String islam3 = obj.getString("b1_islam3");
                        String non1 = obj.getString("b1_non1");
                        String non2 = obj.getString("b1_non2");
                        String longitude = obj.getString("b1_longitude");
                        String latitude = obj.getString("b1_latitude");

                        Intent intent = new Intent(MainActivity.this, UpdateData.class);
                        intent.putExtra("b1_nama", nama);
                        intent.putExtra("b1_alamat", alamat);
                        intent.putExtra("b1_luas", luas);
                        intent.putExtra("b1_imb", imb);
                        intent.putExtra("b1_luas_lahan", luaslahan);
                        intent.putExtra("b1_sertifikat", sertifikat);
                        intent.putExtra("b1_status", status1);
                        intent.putExtra("b1_surat", surat);
                        intent.putExtra("b1_asal", asal);
                        intent.putExtra("b1_penduduk1", penduduk1);
                        intent.putExtra("b1_penduduk2", penduduk2);
                        intent.putExtra("b1_penduduk3", penduduk3);
                        intent.putExtra("b1_penduduk4", penduduk4);
                        intent.putExtra("b1_islam1", islam1);
                        intent.putExtra("b1_islam2", islam2);
                        intent.putExtra("b1_islam3", islam3);
                        intent.putExtra("b1_non1", non1);
                        intent.putExtra("b1_non2", non2);
                        intent.putExtra("b1_longitude", longitude);
                        intent.putExtra("b1_latitude", latitude);
                        startActivity(intent);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "The server unreachable", Toast.LENGTH_SHORT).show();
                    }
                });
        Volley.newRequestQueue(MainActivity.this).add(strReq);

    }

    public void LoadDatab2(final String idUser ) {

        JsonArrayRequest strReq = new JsonArrayRequest(Request.Method.GET,
                HostAddress.url + "api/getdatabidang/1234/"+idUser+"/2", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("eee",response.toString());
                for (int i = 0; i < response.length(); i++) {
                    try {

                        JSONObject obj = response.getJSONObject(i);

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
                        String fotodepan = obj.getString("b2_fotodepan");
                        String fotoutama = obj.getString("b2_fotoutama");
                        String fotowudhu = obj.getString("b2_fotowudhu");
                        String fotokamar = obj.getString("b2_fotokamar");
                        String ketua = obj.getString("b2_ketua");
                        String sekretaris = obj.getString("b2_sekretaris");
                        String bendahara = obj.getString("b2_bendahara");
                        String sertifikasi = obj.getString("b2_sertifikasi");
                        String imb = obj.getString("b2_imb");
                        String sholatsubuh = obj.getString("b2_sholatsubuh");
                        String sholatdzuhur = obj.getString("b2_sholatdzuhur");
                        String sholatmaghrib = obj.getString("b2_sholatmaghrib");


                        Intent intent = new Intent(MainActivity.this, UpBidang2.class);
                        intent.putExtra("b2_namapapan", namappan);
                        intent.putExtra("b2_maket", maket);
                        intent.putExtra("b2_simbol", simbol);
                        intent.putExtra("b2_artistik", artistik);
                        intent.putExtra("b2_kemegahan", kemegahan);
                        intent.putExtra("b2_kebersihan", kebersihan);
                        intent.putExtra("b2_parkir", parkir);
                        intent.putExtra("b2_nyaman", nyaman);
                        intent.putExtra("b2_aman", aman);
                        intent.putExtra("b2_artistik2", artistik2);
                        intent.putExtra("b2_najis", najis);
                        intent.putExtra("b2_indah", indah);
                        intent.putExtra("b2_sehat", sehat);
                        intent.putExtra("b2_fotodepan", fotodepan);
                        intent.putExtra("b2_fotoutama", fotoutama);
                        intent.putExtra("b2_fotowudhu", fotowudhu);
                        intent.putExtra("b2_fotokamar", fotokamar);
                        intent.putExtra("b2_ketua", ketua);
                        intent.putExtra("b2_sekretaris", sekretaris);
                        intent.putExtra("b2_bendahara", bendahara);
                        intent.putExtra("b2_sertifikasi", sertifikasi);
                        intent.putExtra("b2_imb", imb);
                        intent.putExtra("b2_sholatsubuh", sholatsubuh);
                        intent.putExtra("b2_sholatdzuhur", sholatdzuhur);
                        intent.putExtra("b2_sholatmaghrib", sholatmaghrib);

                        startActivity(intent);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
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

        JsonArrayRequest strReq = new JsonArrayRequest(Request.Method.GET,
                HostAddress.url + "api/getdatabidang/1234/"+idUser+"/3", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("eee",response.toString());
                for (int i = 0; i < response.length(); i++) {
                    try {

                        JSONObject obj = response.getJSONObject(i);

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


                        Intent intent = new Intent(MainActivity.this, UpBidang3.class);
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

        JsonArrayRequest strReq = new JsonArrayRequest(Request.Method.GET,
                HostAddress.url + "api/getdatabidang/1234/"+idUser+"/4", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("eee",response.toString());
                for (int i = 0; i < response.length(); i++) {
                    try {

                        JSONObject obj = response.getJSONObject(i);

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


                        Intent intent = new Intent(MainActivity.this, UpBidang4.class);
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

//    public void Profil(final String idUser ) {
//
//        JsonArrayRequest strReq = new JsonArrayRequest(Request.Method.GET,
//                HostAddress.url + "api/getdatabidang/1234/"+idUser+"/2", new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                Log.e("eee",response.toString());
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//
//                        JSONObject obj = response.getJSONObject(i);
//
//                        String nama = obj.getString("nama_lengkap");
//                        String password = obj.getString("password");
//
//
//
//                        Intent intent = new Intent(MainActivity.this, Profile.class);
//                        intent.putExtra("nama_lengkap", nama);
//                        intent.putExtra("password", password);
//
//                        startActivity(intent);
//
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//
//            }
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                        Toast.makeText(context, "The server unreachable", Toast.LENGTH_SHORT).show();
//                    }
//                });
//        Volley.newRequestQueue(this).add(strReq);
//
//    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        HashMap<String, String> user = session.getUserDetails();
//        final String idUser = user.get(SessionManager.KEY_NAME);
        switch (item.getItemId()){
            case R.id.logout:
                showDialog();
                break;
//            case R.id.profile:
//                Profil(idUser);
//                break;
//            case R.id.bidang2:
//                LoadDatab2(idUser);
//                break;
//            case R.id.bidang3:
//                LoadDatab3(idUser);
//                break;
//            case R.id.bidang4:
//                LoadDatab4(idUser);
//                break;
        }
        return true;
    }


}
