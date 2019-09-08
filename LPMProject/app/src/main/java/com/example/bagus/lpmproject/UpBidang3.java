package com.example.bagus.lpmproject;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class UpBidang3 extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    SessionManager session;

    RadioGroup wudlu,kmandi,air,sound,gudang,parkir,kantor,jarak,perpus,audio,projector,inap,taman,sarana,petugas,takmir,surat,kualitas,
                visi,remas,yayasan;
    RadioButton wudlu1,wudlu2,toilet1,toilet2,air1,air2,sound1,sound2,gudang1,gudang2,parkir1,parkir2,kantor1,kantor2,jarak1,jarak2,
                perpus1,perpus2,audio1,audio2,projector1,projector2,inap1,inap2,taman1,taman2,sarana1,sarana2,petugas1,petugas2,
                takmir1,takmir2,surat1,surat2,kualitas1,kualitas2,visi1,visi2,remas1,remas2,yayasan1,yayasan2;
    RadioButton Wudlu, Toilet,Air,Sound,Gudang,Parkir,Kantor,Jarak,Perpus,Audio,Projector,Inap,Taman,Sarana,Petugas,Takmir,
                Surat,Kualitas,Visi,Remas,Yayasan;
    String Swudhu,Skmandi,Sair,Ssound,Sgudang,Sparkir,Skantor,Sjarak,Sperpus,Saudio,Sprojector,Sinap,Staman,Ssarana,Spetugas,
            Stakmir, Ssurat,Skualitas,Svisi,Sremas,Syayasan;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_bidang3);

        session = new SessionManager(getApplicationContext());

        HashMap<String, String> data = session.getUserDetails();
        final String idUser= data.get(SessionManager.KEY_NAME);

        wudlu = (RadioGroup)findViewById(R.id.wudlu);
        air = (RadioGroup)findViewById(R.id.ketersediaanair);
        sound = (RadioGroup)findViewById(R.id.Soundsystem);
        gudang = (RadioGroup)findViewById(R.id.Gudangpenyimpananbarang);
        parkir = (RadioGroup)findViewById(R.id.lahanparkir);
        kantor = (RadioGroup)findViewById(R.id.kantor);
        jarak = (RadioGroup)findViewById(R.id.jaraktempatwudlu);
        perpus = (RadioGroup)findViewById(R.id.perpus);
        kmandi = (RadioGroup)findViewById(R.id.toilet);
        audio = (RadioGroup)findViewById(R.id.audio);
        projector = (RadioGroup)findViewById(R.id.projector);
        inap = (RadioGroup)findViewById(R.id.inap);
        taman = (RadioGroup)findViewById(R.id.taman);
        sarana = (RadioGroup)findViewById(R.id.sarana);
        petugas = (RadioGroup)findViewById(R.id.petugas);
        takmir = (RadioGroup)findViewById(R.id.takmir);
        surat = (RadioGroup)findViewById(R.id.surat);
        kualitas = (RadioGroup)findViewById(R.id.kualitas);
        visi = (RadioGroup)findViewById(R.id.visi);
        remas = (RadioGroup)findViewById(R.id.remas);
        yayasan = (RadioGroup)findViewById(R.id.yayasan);

        wudlu1 = (RadioButton)findViewById(R.id.wudlu1);
        wudlu2 = (RadioButton)findViewById(R.id.wudlu2);
        toilet1 = (RadioButton)findViewById(R.id.toilet1);
        toilet2 = (RadioButton)findViewById(R.id.toilet2);
        air1 = (RadioButton)findViewById(R.id.air1);
        air2 = (RadioButton)findViewById(R.id.air2);
        sound1 = (RadioButton)findViewById(R.id.sound1);
        sound2 = (RadioButton)findViewById(R.id.sound2);
        gudang1 = (RadioButton)findViewById(R.id.gudang1);
        gudang2 = (RadioButton)findViewById(R.id.gudang2);
        parkir1 = (RadioButton)findViewById(R.id.parkir1);
        parkir2 = (RadioButton)findViewById(R.id.parkir2);
        kantor1 = (RadioButton)findViewById(R.id.kantor1);
        kantor2 = (RadioButton)findViewById(R.id.kantor2);
        jarak1 = (RadioButton)findViewById(R.id.jarak1);
        jarak2 = (RadioButton)findViewById(R.id.jarak2);
        perpus1 = (RadioButton)findViewById(R.id.perpus1);
        perpus2 = (RadioButton)findViewById(R.id.perpus2);
        audio1 = (RadioButton)findViewById(R.id.audio1);
        audio2 = (RadioButton)findViewById(R.id.audio2);
        projector1 = (RadioButton)findViewById(R.id.projector1);
        projector2 = (RadioButton)findViewById(R.id.projector2);
        inap1 = (RadioButton)findViewById(R.id.inap1);
        inap2 = (RadioButton)findViewById(R.id.inap2);
        taman1 = (RadioButton)findViewById(R.id.taman1);
        taman2 = (RadioButton)findViewById(R.id.taman2);
        sarana1 = (RadioButton)findViewById(R.id.sarana1);
        sarana2 = (RadioButton)findViewById(R.id.sarana2);
        petugas1 = (RadioButton)findViewById(R.id.petugas1);
        petugas2 = (RadioButton)findViewById(R.id.petugas2);
        takmir1 = (RadioButton)findViewById(R.id.takmir1);
        takmir2 = (RadioButton)findViewById(R.id.takmir2);
        surat1 = (RadioButton)findViewById(R.id.surat1);
        surat2 = (RadioButton)findViewById(R.id.surat2);
        kualitas1 = (RadioButton)findViewById(R.id.kualitas1);
        kualitas2 = (RadioButton)findViewById(R.id.kualitas2);
        visi1 = (RadioButton)findViewById(R.id.visi1);
        visi2 = (RadioButton)findViewById(R.id.visi2);
        remas1 = (RadioButton)findViewById(R.id.remas1);
        remas2 = (RadioButton)findViewById(R.id.remas2);
        yayasan1 = (RadioButton)findViewById(R.id.yayasan1);
        yayasan2 = (RadioButton)findViewById(R.id.yayasan2);
        update = (Button)findViewById(R.id.simpan);


         //getIntent from Tampildataall.java
        Bundle bundle;
        bundle = getIntent().getExtras();

        Swudhu = bundle.getString("b3_wudhu");
        Skmandi = bundle.getString("b3_kamar");
        Sair = bundle.getString("b3_air");
        Ssound = bundle.getString("b3_sound");
        Sgudang = bundle.getString("b3_gudang");
        Sparkir = bundle.getString("b3_lahan");
        Skantor = bundle.getString("b3_kantor");
        Sjarak = bundle.getString("b3_jarak");
        Sperpus = bundle.getString("b3_perpustakaan");
        Saudio = bundle.getString("b3_audio");
        Sprojector = bundle.getString("b3_projector");
        Sinap = bundle.getString("b3_penginapan");
        Staman = bundle.getString("b3_taman");
        Ssarana = bundle.getString("b3_lainnya");
        Spetugas = bundle.getString("b3_petugas");
        Stakmir = bundle.getString("b3_pengurus");
        Ssurat = bundle.getString("b3_surat");
        Skualitas = bundle.getString("b3_kualitassurat");
        Svisi = bundle.getString("b3_visimisi");
        Sremas = bundle.getString("b3_remaja");
        Syayasan = bundle.getString("b3_yayasan");

        if(Swudhu.equals("ada")){
            wudlu1.setChecked(true);
            wudlu2.setChecked(false);
        }else if(Swudhu.equals("tidak")){
            wudlu1.setChecked(false);
            wudlu2.setChecked(true);
        }
        if(Skmandi.equals("ada")){
            toilet1.setChecked(true);
            toilet2.setChecked(false);
        }else if(Skmandi.equals("tidak")){
            toilet1.setChecked(false);
            toilet2.setChecked(true);
        }
        if(Sair.equals("ada")){
            air1.setChecked(true);
            air2.setChecked(false);
        }else if(Sair.equals("tidak")){
            air1.setChecked(false);
            air2.setChecked(true);
        }
        if(Ssound.equals("ada")){
            sound1.setChecked(true);
            sound2.setChecked(false);
        }else if(Ssound.equals("tidak")){
            sound1.setChecked(false);
            sound2.setChecked(true);
        }
        if(Sgudang.equals("ada")){
            gudang1.setChecked(true);
            gudang2.setChecked(false);
        }else if(Sgudang.equals("tidak")){
            gudang1.setChecked(false);
            gudang2.setChecked(true);
        }
        if(Sparkir.equals("ada")){
            parkir1.setChecked(true);
            parkir2.setChecked(false);
        }else if(Sparkir.equals("tidak")){
            parkir1.setChecked(false);
            parkir2.setChecked(true);
        }
        if(Skantor.equals("ada")){
            kantor1.setChecked(true);
            kantor2.setChecked(false);
        }else if(Skantor.equals("tidak")){
            kantor1.setChecked(false);
            kantor2.setChecked(true);
        }
        if(Sjarak.equals("ada")){
            jarak1.setChecked(true);
            jarak2.setChecked(false);
        }else if(Sjarak.equals("tidak")){
            jarak1.setChecked(false);
            jarak2.setChecked(true);
        }

        if(Sperpus.equals("ada")){
            perpus1.setChecked(true);
            perpus2.setChecked(false);
        }else if(Sperpus.equals("tidak")){
            perpus1.setChecked(false);
            perpus2.setChecked(true);
        }

        if(Saudio.equals("ada")){
            audio1.setChecked(true);
            audio2.setChecked(false);
        }else if(Saudio.equals("tidak")){
            audio1.setChecked(false);
            audio2.setChecked(true);
        }
        if(Sprojector.equals("ada")){
            projector1.setChecked(true);
            projector2.setChecked(false);
        }else if(Sprojector.equals("tidak")){
            projector1.setChecked(false);
            projector2.setChecked(true);
        }
        if(Sinap.equals("ada")){
            inap1.setChecked(true);
            inap2.setChecked(false);
        }else if(Sinap.equals("tidak")){
            inap1.setChecked(false);
            inap2.setChecked(true);
        }
        if(Staman.equals("ada")){
            taman1.setChecked(true);
            taman2.setChecked(false);
        }else if(Staman.equals("tidak")){
            taman1.setChecked(false);
            taman2.setChecked(true);
        }
        if(Ssarana.equals("ada")){
            sarana1.setChecked(true);
            sarana2.setChecked(false);
        }else if(Ssarana.equals("tidak")){
            sarana1.setChecked(false);
            sarana2.setChecked(true);
        }
        if(Spetugas.equals("ada")){
            petugas1.setChecked(true);
            petugas2.setChecked(false);
        }else if(Spetugas.equals("tidak")){
            petugas1.setChecked(false);
            petugas2.setChecked(true);
        }
        if(Stakmir.equals("ada")){
            takmir1.setChecked(true);
            takmir2.setChecked(false);
        }else if(Stakmir.equals("tidak")){
            takmir1.setChecked(false);
            takmir2.setChecked(true);
        }
        if(Ssurat.equals("ada")){
            surat1.setChecked(true);
            surat2.setChecked(false);
        }else if(Ssurat.equals("tidak")){
            surat1.setChecked(false);
            surat2.setChecked(true);
        }
        if(Skualitas.equals("ada")){
            kualitas1.setChecked(true);
            kualitas2.setChecked(false);
        }else if(Skualitas.equals("tidak")){
            kualitas1.setChecked(false);
            kualitas2.setChecked(true);
        }
        if(Svisi.equals("ada")){
            visi1.setChecked(true);
            visi2.setChecked(false);
        }else if(Svisi.equals("tidak")){
            visi1.setChecked(false);
            visi2.setChecked(true);
        }
        if(Sremas.equals("ada")){
            remas1.setChecked(true);
            remas2.setChecked(false);
        }else if(Sremas.equals("tidak")){
            remas1.setChecked(false);
            remas2.setChecked(true);
        }
        if(Syayasan.equals("ada")){
            yayasan1.setChecked(true);
            yayasan2.setChecked(false);
        }else if(Syayasan.equals("tidak")){
            yayasan1.setChecked(false);
            yayasan2.setChecked(true);
        }

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(idUser);
            }
        });
    }

    private void update(final String idUser){
        int wudhu3 = wudlu.getCheckedRadioButtonId();
        Wudlu = (RadioButton)findViewById(wudhu3);
        int kmandi3 = kmandi.getCheckedRadioButtonId();
        Toilet = (RadioButton)findViewById(kmandi3);
        int air3 = air.getCheckedRadioButtonId();
        Air = (RadioButton)findViewById(air3);
        int sound3 = sound.getCheckedRadioButtonId();
        Sound = (RadioButton)findViewById(sound3);
        int gudang3 = gudang.getCheckedRadioButtonId();
        Gudang = (RadioButton)findViewById(gudang3);
        int parkir3 = parkir.getCheckedRadioButtonId();
        Parkir = (RadioButton)findViewById(parkir3);
        int kantor3 = kantor.getCheckedRadioButtonId();
        Kantor = (RadioButton)findViewById(kantor3);
        int jarak3 = jarak.getCheckedRadioButtonId();
        Jarak = (RadioButton)findViewById(jarak3);
        int perpus3 = perpus.getCheckedRadioButtonId();
        Perpus = (RadioButton)findViewById(perpus3);
        int audio3 = audio.getCheckedRadioButtonId();
        Audio = (RadioButton)findViewById(audio3);
        int projector3 = projector.getCheckedRadioButtonId();
        Projector = (RadioButton)findViewById(projector3);
        int inap3 = inap.getCheckedRadioButtonId();
        Inap = (RadioButton)findViewById(inap3);
        int taman3 = taman.getCheckedRadioButtonId();
        Taman = (RadioButton)findViewById(taman3);
        int sarana3 = sarana.getCheckedRadioButtonId();
        Sarana = (RadioButton)findViewById(sarana3);
        int petugas3 = petugas.getCheckedRadioButtonId();
        Petugas = (RadioButton)findViewById(petugas3);
        int takmir3 = takmir.getCheckedRadioButtonId();
        Takmir = (RadioButton)findViewById(takmir3);
        int surat3 = surat.getCheckedRadioButtonId();
        Surat = (RadioButton)findViewById(surat3);
        int kualitas3 = kualitas.getCheckedRadioButtonId();
        Kualitas = (RadioButton)findViewById(kualitas3);
        int visi3 = visi.getCheckedRadioButtonId();
        Visi = (RadioButton)findViewById(visi3);
        int remas3 = remas.getCheckedRadioButtonId();
        Remas = (RadioButton)findViewById(remas3);
        int yayasan3 = yayasan.getCheckedRadioButtonId();
        Yayasan = (RadioButton)findViewById(yayasan3);

        Swudhu = Wudlu.getText().toString();
        Sair = Air.getText().toString();
        Skmandi = Toilet.getText().toString();
        Ssound = Sound.getText().toString();
        Sgudang = Gudang.getText().toString();
        Sparkir = Parkir.getText().toString();
        Skantor = Kantor.getText().toString();
        Sjarak = Jarak.getText().toString();
        Sperpus = Perpus.getText().toString();
        Saudio = Audio.getText().toString();
        Sprojector = Projector.getText().toString();
        Sinap = Inap.getText().toString();
        Staman = Taman.getText().toString();
        Ssarana = Sarana.getText().toString();
        Spetugas = Petugas.getText().toString();
        Stakmir = Takmir.getText().toString();
        Ssurat = Surat.getText().toString();
        Skualitas = Kualitas.getText().toString();
        Svisi = Visi.getText().toString();
        Sremas = Remas.getText().toString();
        Syayasan = Yayasan.getText().toString();
       

        
        StringRequest jArr = new StringRequest(Request.Method.POST,HostAddress.url + "api/updateb3/1234/"+ idUser,
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
                Toast.makeText(UpBidang3.this, "cek koneksi anda" , Toast.LENGTH_SHORT).show();

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("b3_wudhu", Swudhu);
                param.put("b3_kamar", Skmandi);
                param.put("b3_air", Sair);
                param.put("b3_sound", Ssound);
                param.put("b3_gudang", Sgudang);
                param.put("b3_lahan", Sparkir);
                param.put("b3_kantor", Skantor);
                param.put("b3_jarak", Sjarak);
                param.put("b3_perpustakaan", Sperpus);
                param.put("b3_audio", Saudio);
                param.put("b3_projector", Sprojector);
                param.put("b3_penginapan", Sinap);
                param.put("b3_taman", Staman);
                param.put("b3_lainnya", Ssarana);
                param.put("b3_petugas", Spetugas);
                param.put("b3_pengurus", Stakmir);
                param.put("b3_surat", Ssurat);
                param.put("b3_kualitassurat", Skualitas);
                param.put("b3_visimisi", Svisi);
                param.put("b3_remaja", Sremas);
                param.put("b3_yayasan", Syayasan);

                return param;
            }
        };


        Volley.newRequestQueue(getApplicationContext()).add(jArr);
    }
}
