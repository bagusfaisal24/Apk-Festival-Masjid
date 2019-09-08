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

import java.util.HashMap;
import java.util.Map;

public class UpBidang4 extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    SessionManager session;

    RadioGroup tpa,anak,seni,phbi,pengajian,olahraga,tadarus,kajian,gender,msy,pendidikan,pentas,tafsir,madrasah,
                tk,sd,smp,sma,klinik,tahfiz;
    RadioButton tpa1,tpa2,anak1,anak2,seni1,seni2,phbi1,phbi2,pengajian1,pengajian2,olahraga1,olahraga2,
                tadarus1,tadarus2,kajian1,kajian2,gender1,gender2,msy1,msy2,pendidikan1,pendidikan2,pentas1,pentas2,
                tafsir1,tafsir2,madrasah1,madrasah2,tk1,tk2,sd1,sd2,smp1,smp2,sma1,sma2,klinik1,klinik2,tahfiz1,tahfiz2;
    RadioButton Tpa, Anak, Seni, Phbi,Pengajian,Olahraga,Tadarus,Kajian,Gender,Msy,Pendidikan,Pentas,Tafsir,Madrasah,
                Tk,Sd,Smp,Sma,Klinik,Tahfiz;
    String Stpa,Sanak,Sseni,Sphbi,Spengajian,Solahraga,Stadarus,Skajian,Sgender,Smsy,Spendidikan,Spentas,Stafsir,Smadrasah,
            Stk,Ssd,Ssmp,Ssma,Sklinik,Stahfiz;
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_bidang4);
        session = new SessionManager(getApplicationContext());

        HashMap<String, String> data = session.getUserDetails();
        final String idUser= data.get(SessionManager.KEY_NAME);

        update = (Button)findViewById(R.id.smpn);
        tpa = (RadioGroup)findViewById(R.id.tpa);
        anak = (RadioGroup)findViewById(R.id.anak);
        seni = (RadioGroup)findViewById(R.id.seni);
        phbi = (RadioGroup)findViewById(R.id.phbi);
        pengajian = (RadioGroup)findViewById(R.id.pengajian);
        olahraga = (RadioGroup)findViewById(R.id.olahraga);
        tadarus = (RadioGroup)findViewById(R.id.tadarus);
        kajian = (RadioGroup)findViewById(R.id.kajian);
        gender = (RadioGroup)findViewById(R.id.gender);
        msy = (RadioGroup)findViewById(R.id.msy);
        pendidikan = (RadioGroup)findViewById(R.id.pendidikan);
        pentas = (RadioGroup)findViewById(R.id.pentas);
        tafsir = (RadioGroup)findViewById(R.id.tafsir);
        madrasah = (RadioGroup)findViewById(R.id.madrasah);
        tk = (RadioGroup)findViewById(R.id.tk);
        sd = (RadioGroup)findViewById(R.id.sd);
        smp = (RadioGroup)findViewById(R.id.smp);
        sma = (RadioGroup)findViewById(R.id.sma);
        klinik = (RadioGroup)findViewById(R.id.klinik);
        tahfiz = (RadioGroup)findViewById(R.id.tahfiz);

        tpa1 = (RadioButton)findViewById(R.id.tpa1);
        tpa2 = (RadioButton)findViewById(R.id.tpa2);
        anak1 = (RadioButton)findViewById(R.id.anak1);
        anak2 = (RadioButton)findViewById(R.id.anak2);
        seni1 = (RadioButton)findViewById(R.id.seni1);
        seni2 = (RadioButton)findViewById(R.id.seni2);
        phbi1 = (RadioButton)findViewById(R.id.phbi1);
        phbi2 = (RadioButton)findViewById(R.id.phbi2);
        pengajian1 = (RadioButton)findViewById(R.id.pengajian1);
        pengajian2 = (RadioButton)findViewById(R.id.pengajian2);
        olahraga1 = (RadioButton)findViewById(R.id.olahraga1);
        olahraga2 = (RadioButton)findViewById(R.id.olahraga2);
        tadarus1 = (RadioButton)findViewById(R.id.tadarus1);
        tadarus2 = (RadioButton)findViewById(R.id.tadarus2);
        kajian1 = (RadioButton)findViewById(R.id.kajian1);
        kajian2 = (RadioButton)findViewById(R.id.kajian2);
        gender1 = (RadioButton)findViewById(R.id.gender1);
        gender2 = (RadioButton)findViewById(R.id.gender2);
        msy1 = (RadioButton)findViewById(R.id.msy1);
        msy2 = (RadioButton)findViewById(R.id.msy2);
        pendidikan1 = (RadioButton)findViewById(R.id.pendidikan1);
        pendidikan2 = (RadioButton)findViewById(R.id.pendidikan2);
        pentas1 = (RadioButton)findViewById(R.id.pentas1);
        pentas2 = (RadioButton)findViewById(R.id.pentas2);
        tafsir1 = (RadioButton)findViewById(R.id.tafsir1);
        tafsir2 = (RadioButton)findViewById(R.id.tafsir2);
        madrasah1 = (RadioButton)findViewById(R.id.madrasah1);
        madrasah2 = (RadioButton)findViewById(R.id.madrasah2);
        tk1 = (RadioButton)findViewById(R.id.tk1);
        tk2 = (RadioButton)findViewById(R.id.tk2);
        sd1 = (RadioButton)findViewById(R.id.sd1);
        sd2 = (RadioButton)findViewById(R.id.sd2);
        smp1 = (RadioButton)findViewById(R.id.smp1);
        smp2 = (RadioButton)findViewById(R.id.smp2);
        sma1 = (RadioButton)findViewById(R.id.sma1);
        sma2 = (RadioButton)findViewById(R.id.sma2);
        klinik1 = (RadioButton)findViewById(R.id.klinik1);
        klinik2 = (RadioButton)findViewById(R.id.klinik2);
        tahfiz1 = (RadioButton)findViewById(R.id.tahfiz1);
        tahfiz2 = (RadioButton)findViewById(R.id.tahfiz2);

        Bundle bundle;
        bundle = getIntent().getExtras();

        Stpa = bundle.getString("b4_tpa");
        Sanak = bundle.getString("b4_anak");
        Sseni = bundle.getString("b4_seni");
        Sphbi = bundle.getString("b4_haribesar");
        Spengajian = bundle.getString("b4_pengajian");
        Solahraga = bundle.getString("b4_olahraga");
        Stadarus = bundle.getString("b4_tadarus");
        Skajian = bundle.getString("b4_keagamaan");
        Sgender = bundle.getString("b4_gender");
        Smsy = bundle.getString("b4_pemberdayaan");
        Spendidikan = bundle.getString("b4_pendidikan");
        Spentas = bundle.getString("b4_pentas");
        Stafsir = bundle.getString("b4_tafsir");
        Smadrasah = bundle.getString("b4_madrasah");
        Stk = bundle.getString("b4_tk");
        Ssd = bundle.getString("b4_sd");
        Ssmp = bundle.getString("b4_sltp");
        Ssma = bundle.getString("b4_slta");
        Sklinik = bundle.getString("b4_klinik");
        Stahfiz = bundle.getString("b4_tahfiz");

        if(Stpa.equals("ada")){
            tpa1.setChecked(true);
            tpa2.setChecked(false);
        }else if(Stpa.equals("tidak")){
            tpa1.setChecked(false);
            tpa2.setChecked(true);
        }
        if(Sanak.equals("ada")){
            anak1.setChecked(true);
            anak2.setChecked(false);
        }else if(Sanak.equals("tidak")){
            anak1.setChecked(false);
            anak2.setChecked(true);
        }
        if(Sseni.equals("ada")){
            seni1.setChecked(true);
            seni2.setChecked(false);
        }else if(Sseni.equals("tidak")){
            seni1.setChecked(false);
            seni2.setChecked(true);
        }
        if(Sphbi.equals("ada")){
            phbi1.setChecked(true);
            phbi2.setChecked(false);
        }else if(Sphbi.equals("tidak")){
            phbi1.setChecked(false);
            phbi2.setChecked(true);
        }
        if(Spengajian.equals("ada")){
            pengajian1.setChecked(true);
            pengajian2.setChecked(false);
        }else if(Spengajian.equals("tidak")){
            pengajian1.setChecked(false);
            pengajian2.setChecked(true);
        }
        if(Solahraga.equals("ada")){
            olahraga1.setChecked(true);
            olahraga2.setChecked(false);
        }else if(Solahraga.equals("tidak")){
            olahraga1.setChecked(false);
            olahraga2.setChecked(true);
        }
        if(Stadarus.equals("ada")){
            tadarus1.setChecked(true);
            tadarus2.setChecked(false);
        }else if(Stadarus.equals("tidak")){
            tadarus1.setChecked(false);
            tadarus2.setChecked(true);
        }
        if(Skajian.equals("ada")){
            kajian1.setChecked(true);
            kajian2.setChecked(false);
        }else if(Skajian.equals("tidak")){
            kajian1.setChecked(false);
            kajian2.setChecked(true);
        }
        if(Sgender.equals("ada")){
            gender1.setChecked(true);
            gender2.setChecked(false);
        }else if(Sgender.equals("tidak")){
            gender1.setChecked(false);
            gender2.setChecked(true);
        }
        if(Smsy.equals("ada")){
            msy1.setChecked(true);
            msy2.setChecked(false);
        }else if(Smsy.equals("tidak")){
            msy1.setChecked(false);
            msy2.setChecked(true);
        }
        if(Spendidikan.equals("ada")){
            pendidikan1.setChecked(true);
            pendidikan2.setChecked(false);
        }else if(Spendidikan.equals("tidak")){
            pendidikan1.setChecked(false);
            pendidikan2.setChecked(true);
        }
        if(Spentas.equals("ada")){
            pentas1.setChecked(true);
            pentas2.setChecked(false);
        }else if(Spentas.equals("tidak")){
            pentas1.setChecked(false);
            pentas2.setChecked(true);
        }
        if(Stafsir.equals("ada")){
            tafsir1.setChecked(true);
            tafsir2.setChecked(false);
        }else if(Stafsir.equals("tidak")){
            tafsir1.setChecked(false);
            tafsir2.setChecked(true);
        }
        if(Smadrasah.equals("ada")){
            madrasah1.setChecked(true);
            madrasah2.setChecked(false);
        }else if(Smadrasah.equals("tidak")){
            madrasah1.setChecked(false);
            madrasah2.setChecked(true);
        }
        if(Stk.equals("ada")){
            tk1.setChecked(true);
            tk2.setChecked(false);
        }else if(Stk.equals("tidak")){
            tk1.setChecked(false);
            tk2.setChecked(true);
        }
        if(Ssd.equals("ada")){
            sd1.setChecked(true);
            sd2.setChecked(false);
        }else if(Ssd.equals("tidak")){
            sd1.setChecked(false);
            sd2.setChecked(true);
        }
        if(Ssmp.equals("ada")){
            smp1.setChecked(true);
            smp2.setChecked(false);
        }else if(Ssmp.equals("tidak")){
            smp1.setChecked(false);
            smp2.setChecked(true);
        }
        if(Ssma.equals("ada")){
            sma1.setChecked(true);
            sma2.setChecked(false);
        }else if(Ssma.equals("tidak")){
            sma1.setChecked(false);
            sma2.setChecked(true);
        }
        if(Sklinik.equals("ada")){
            klinik1.setChecked(true);
            klinik2.setChecked(false);
        }else if(Sklinik.equals("tidak")){
            klinik1.setChecked(false);
            klinik2.setChecked(true);
        }
        if(Stahfiz.equals("ada")){
            tahfiz1.setChecked(true);
            tahfiz2.setChecked(false);
        }else if(Stahfiz.equals("tidak")){
            tahfiz1.setChecked(false);
            tahfiz2.setChecked(true);
        }
    update.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            update(idUser);
        }
    });

    }
    private void update(final String idUser){
        int tpa4 = tpa.getCheckedRadioButtonId();
        Tpa = (RadioButton)findViewById(tpa4);
        int anak4 = anak.getCheckedRadioButtonId();
        Anak = (RadioButton)findViewById(anak4);
        int seni4 = seni.getCheckedRadioButtonId();
        Seni = (RadioButton)findViewById(seni4);
        int phbi4 = phbi.getCheckedRadioButtonId();
        Phbi = (RadioButton)findViewById(phbi4);
        int pengajian4 = pengajian.getCheckedRadioButtonId();
        Pengajian = (RadioButton)findViewById(pengajian4);
        int olahraga4= olahraga.getCheckedRadioButtonId();
        Olahraga= (RadioButton)findViewById(olahraga4);
        int tadarus4 = tadarus.getCheckedRadioButtonId();
        Tadarus = (RadioButton)findViewById(tadarus4);
        int kajian4 = kajian.getCheckedRadioButtonId();
        Kajian = (RadioButton)findViewById(kajian4);
        int gender5 = gender.getCheckedRadioButtonId();
        Gender = (RadioButton)findViewById(gender5);
        int msy4 = msy.getCheckedRadioButtonId();
        Msy = (RadioButton)findViewById(msy4);
        int pend4 = pendidikan.getCheckedRadioButtonId();
        Pendidikan = (RadioButton)findViewById(pend4);
        int pentas4 = pentas.getCheckedRadioButtonId();
        Pentas = (RadioButton)findViewById(pentas4);
        int tafsir4 = tafsir.getCheckedRadioButtonId();
        Tafsir = (RadioButton)findViewById(tafsir4);
        int madrasah4 = madrasah.getCheckedRadioButtonId();
        Madrasah = (RadioButton)findViewById(madrasah4);
        int tk4 = tk.getCheckedRadioButtonId();
        Tk = (RadioButton)findViewById(tk4);
        int sd4 = sd.getCheckedRadioButtonId();
        Sd = (RadioButton)findViewById(sd4);
        int smp4 = smp.getCheckedRadioButtonId();
        Smp = (RadioButton)findViewById(smp4);
        int sma4 = sma.getCheckedRadioButtonId();
        Sma = (RadioButton)findViewById(smp4);
        int klinik4 = klinik.getCheckedRadioButtonId();
        Klinik = (RadioButton)findViewById(klinik4);
        int tahfiz4 = tahfiz.getCheckedRadioButtonId();
        Tahfiz = (RadioButton)findViewById(tahfiz4);


        Stpa = Tpa.getText().toString();
        Sanak = Anak.getText().toString();
        Sseni = Seni.getText().toString();
        Sphbi = Phbi.getText().toString();
        Spengajian = Pengajian.getText().toString();
        Solahraga = Olahraga.getText().toString();
        Stadarus = Tadarus.getText().toString();
        Skajian = Kajian.getText().toString();
        Sgender = Gender.getText().toString();
        Smsy = Msy.getText().toString();
        Spendidikan = Pendidikan.getText().toString();
        Spentas = Pentas.getText().toString();
        Stafsir = Tafsir.getText().toString();
        Smadrasah = Madrasah.getText().toString();
        Stk = Tk.getText().toString();
        Ssd = Sd.getText().toString();
        Ssmp = Smp.getText().toString();
        Ssma = Sma.getText().toString();
        Sklinik = Klinik.getText().toString();
        Stahfiz = Tahfiz.getText().toString();


        StringRequest jArr = new StringRequest(Request.Method.POST,HostAddress.url + "api/updateb4/1234/"+ idUser,
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
                Toast.makeText(UpBidang4.this, error.getMessage() , Toast.LENGTH_SHORT).show();

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();

                param.put("b4_tpa", Stpa);
                param.put("b4_anak", Sanak);
                param.put("b4_seni", Sseni);
                param.put("b4_haribesar", Sphbi);
                param.put("b4_pengajian", Spengajian);
                param.put("b4_olahraga", Solahraga);
                param.put("b4_tadarus", Stadarus);
                param.put("b4_keagamaan", Skajian);
                param.put("b4_gender", Sgender);
                param.put("b4_pemberdayaan", Smsy);
                param.put("b4_pendidikan", Spendidikan);
                param.put("b4_pentas", Spentas);
                param.put("b4_tafsir", Stafsir);
                param.put("b4_madrasah", Smadrasah);
                param.put("b4_tk", Stk);
                param.put("b4_sd", Ssd);
                param.put("b4_sltp", Ssmp);
                param.put("b4_slta", Ssma);
                param.put("b4_klinik", Sklinik);
                param.put("b4_tahfiz", Stahfiz);

                return param;
            }
        };


        Volley.newRequestQueue(getApplicationContext()).add(jArr);
    }
}
