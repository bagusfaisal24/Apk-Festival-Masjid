package com.example.bagus.lpmproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Bidang2 extends AppCompatActivity {
    RadioGroup papan,maket,simbol,artistik,megah,bersih,parkir,nyaman,aman,artistik2,najis,indah,sehat;
    RadioButton papan1,papan2,maket1,maket2,simbol1,simbol2,ars1,ars2,megah1,megah2,bersih1,bersih2,parkir1,parkir2, nyaman1,
            nyaman2,aman1,aman2,a0,a2,najis1,najis2,indah0,indah1,sehat1,sehat2,
            Papan, Maket, Simbol, Artistik, Megah,Bersih,Parkir,Nyaman,Aman,Artitistik,Najis,Indah,Sehat;
    String npapan, nmaket, nsimbol, narstistik, nmegah, nbersih, nparkir, nyamann, naman, nartistik2, nnajis, nindah, nsehat;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidang2);
        next = (Button)findViewById(R.id.smpn);
        papan = (RadioGroup)findViewById(R.id.papan);
        maket = (RadioGroup)findViewById(R.id.maket);
        simbol = (RadioGroup)findViewById(R.id.simbol);
        artistik = (RadioGroup)findViewById(R.id.artistik);
        megah = (RadioGroup)findViewById(R.id.megah);
        bersih = (RadioGroup)findViewById(R.id.bersih);
        parkir = (RadioGroup)findViewById(R.id.parkir);
        nyaman = (RadioGroup)findViewById(R.id.nyaman);
        aman = (RadioGroup)findViewById(R.id.aman);
        artistik2 = (RadioGroup)findViewById(R.id.artistik2);
        najis = (RadioGroup)findViewById(R.id.najis);
        indah = (RadioGroup)findViewById(R.id.indah);
        sehat = (RadioGroup)findViewById(R.id.sehat);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
            }
        });
    }
    public void send(){
        int papan2 = papan.getCheckedRadioButtonId();
        Papan = (RadioButton)findViewById(papan2);
        int maket2 = maket.getCheckedRadioButtonId();
        Maket = (RadioButton)findViewById(maket2);
        int simbol2 = simbol.getCheckedRadioButtonId();
        Simbol = (RadioButton)findViewById(simbol2);
        int artistik12 = artistik.getCheckedRadioButtonId();
        Artistik = (RadioButton)findViewById(artistik12);
        int megah2 = megah.getCheckedRadioButtonId();
        Megah = (RadioButton)findViewById(megah2);
        int bersih2 = bersih.getCheckedRadioButtonId();
        Bersih = (RadioButton)findViewById(bersih2);
        int parkir2 = parkir.getCheckedRadioButtonId();
        Parkir = (RadioButton)findViewById(parkir2);
        int nyaman2 = nyaman.getCheckedRadioButtonId();
        Nyaman = (RadioButton)findViewById(nyaman2);
        int aman2 = aman.getCheckedRadioButtonId();
        Aman = (RadioButton)findViewById(aman2);
        int artistik22 = artistik2.getCheckedRadioButtonId();
        Artitistik = (RadioButton)findViewById(artistik22);
        int najis2 = papan.getCheckedRadioButtonId();
        Najis = (RadioButton)findViewById(najis2);
        int sehat2 = sehat.getCheckedRadioButtonId();
        Sehat = (RadioButton)findViewById(sehat2);
        int indah2 = indah.getCheckedRadioButtonId();
        Indah = (RadioButton)findViewById(indah2);

        npapan = Papan.getText().toString();
        nsimbol = Simbol.getText().toString();
        nmaket = Maket.getText().toString();
        narstistik = Artistik.getText().toString();
        nmegah = Megah.getText().toString();
        nparkir = Parkir.getText().toString();
        nbersih = Bersih.getText().toString();
        nyamann = Nyaman.getText().toString();
        naman = Aman.getText().toString();
        nartistik2 = Artitistik.getText().toString();
        nnajis = Najis.getText().toString();
        nindah = Indah.getText().toString();
        nsehat = Sehat.getText().toString();

        Intent intent = new Intent(Bidang2.this, Bidang21.class);
        intent.putExtra("b2_namapapan", npapan);
        intent.putExtra("b2_maket", nmaket);
        intent.putExtra("b2_simbol", nsimbol);
        intent.putExtra("b2_artistik", narstistik);
        intent.putExtra("b2_kemegahan",nmegah);
        intent.putExtra("b2_kebersihan",nbersih);
        intent.putExtra("b2_parkir",nparkir);
        intent.putExtra("b2_nyaman",nyamann);
        intent.putExtra("b2_aman",naman);
        intent.putExtra("b2_artistik2",nartistik2);
        intent.putExtra("b2_najis",nnajis);
        intent.putExtra("b2_indah",nindah);
        intent.putExtra("b2_sehat",nsehat);
        startActivity(intent);
    }
}
