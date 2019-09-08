package com.example.bagus.lpmproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UpBidang2 extends AppCompatActivity {
    private Context context;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    SessionManager session;
    int PICK_IMAGE_REQUEST1 = 1;
    int PICK_IMAGE_REQUEST2 = 2;
    int PICK_IMAGE_REQUEST3 = 3;
    int PICK_IMAGE_REQUEST4 = 4;
    int bitmap_size = 60; // range 1 - 100
    Bitmap bitmap1, bitmap2, bitmap3, bitmap4, decoded;
    Button button1, button2, button3,button4;
    RadioGroup papan,maket,simbol,artistik,megah,bersih,parkir,nyaman,aman,artistik2,najis,indah,sehat;
    RadioButton papan1,papan2,maket1,maket2,simbol1,simbol2,ars1,ars2,megah1,megah2,bersih1,bersih2,parkir1,parkir2, nyaman1,
            nyaman2,aman1,aman2,a0,a2,najis1,najis2,indah0,indah1,sehat1,sehat2,
    Papan, Maket, Simbol, Artistik, Megah,Bersih,Parkir,Nyaman,Aman,Artitistik,Najis,Indah,Sehat;
    EditText ketua1,sekretaris2,bendahara3, sholat1,sholat2,sholat3,sertfikasi,imb;
    String npapan, nmaket, nsimbol, narstistik, nmegah, nbersih, nparkir, nyamann, naman, nartistik2, nnajis, nindah, nsehat, ketua,sekretaris,bendahara,
    sholatsubuh,sholatdzuhur,sholatmaghrib,Ssertifikasi,Simb;
    Button up2;
    ImageView img;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_bidang2);

        session = new SessionManager(getApplicationContext());

        HashMap<String, String> data = session.getUserDetails();
        final String idUser= data.get(SessionManager.KEY_NAME);

        up2 = (Button)findViewById(R.id.smpn2);
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

        papan1 = (RadioButton)findViewById(R.id.papan1);
        papan2 = (RadioButton)findViewById(R.id.papan2);
        maket1 = (RadioButton)findViewById(R.id.maket1);
        maket2 = (RadioButton)findViewById(R.id.maket2);
        simbol1 = (RadioButton)findViewById(R.id.simbol1);
        simbol2 = (RadioButton)findViewById(R.id.simbol2);
        ars1 = (RadioButton)findViewById(R.id.ars1);
        ars2 = (RadioButton)findViewById(R.id.ars2);
        megah1 = (RadioButton)findViewById(R.id.megah1);
        megah2 = (RadioButton)findViewById(R.id.megah2);
        bersih1 = (RadioButton)findViewById(R.id.bersih1);
        bersih2 = (RadioButton)findViewById(R.id.bersih2);
        parkir1 = (RadioButton)findViewById(R.id.parkir1);
        parkir2 = (RadioButton)findViewById(R.id.parkir2);
        nyaman1 =(RadioButton)findViewById(R.id.nyaman1);
        nyaman2 =(RadioButton)findViewById(R.id.nyaman2);
        aman1=(RadioButton)findViewById(R.id.aman1);
        aman2=(RadioButton)findViewById(R.id.aman2);
        a0 = (RadioButton)findViewById(R.id.a0);
        a2=(RadioButton)findViewById(R.id.a2);
        najis1=(RadioButton)findViewById(R.id.najis1);
        najis2=(RadioButton)findViewById(R.id.najis2);
        indah0 = (RadioButton)findViewById(R.id.indah0);
        indah1 = (RadioButton)findViewById(R.id.indah1);
        sehat1 = (RadioButton)findViewById(R.id.sehat1);
        sehat2 = (RadioButton)findViewById(R.id.sehat2);

        ketua1 = (EditText)findViewById(R.id.ketua);
        sekretaris2 = (EditText)findViewById(R.id.sekretaris);
        bendahara3 = (EditText)findViewById(R.id.bendahara);
        sholat1 = (EditText)findViewById(R.id.subuh);
        sholat2 = (EditText)findViewById(R.id.ashar);
        sholat3 = (EditText)findViewById(R.id.maghrib);
        sertfikasi = (EditText)findViewById(R.id.sertifikasi);
        imb = (EditText)findViewById(R.id.imb);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        img = (ImageView)findViewById(R.id.img);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser1();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser2();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser3();
            }
        });

        Bundle bundle;
        bundle = getIntent().getExtras();

        npapan = bundle.getString("b2_namapapan");
        nmaket = bundle.getString("b2_maket");
        nsimbol = bundle.getString("b2_simbol");
        narstistik = bundle.getString("b2_artistik");
        nmegah = bundle.getString("b2_kemegahan");
        nbersih = bundle.getString("b2_kebersihan");
        nparkir = bundle.getString("b2_parkir");
        nyamann = bundle.getString("b2_nyaman");
        naman = bundle.getString("b2_aman");
        nartistik2 = bundle.getString("b2_artistik2");
        nnajis = bundle.getString("b2_najis");
        nindah = bundle.getString("b2_indah");
        nsehat = bundle.getString("b2_sehat");

        ketua1.setText(bundle.getString("b2_ketua"));
        sekretaris2.setText(bundle.getString("b2_sekretaris"));
        bendahara3.setText(bundle.getString("b2_bendahara"));
        sholat1.setText(bundle.getString("b2_sholatsubuh"));
        sholat2.setText(bundle.getString("b2_sholatdzuhur"));
        sholat3.setText(bundle.getString("b2_sholatmaghrib"));
        sertfikasi.setText(bundle.getString("b2_sertifikasi"));
        imb.setText(bundle.getString("b2_imb"));
        button1.setText(bundle.getString("b2_fotodepan"));
        button2.setText(bundle.getString("b2_fotoutama"));
        button3.setText(bundle.getString("b2_fotowudhu"));
        button4.setText(bundle.getString("b2_fotokamar"));

        if(npapan.equals("ada")){
            papan1.setChecked(true);
            papan2.setChecked(false);
        }else if(npapan.equals("tidak")){
            papan1.setChecked(false);
            papan2.setChecked(true);
        }
        if(nmaket.equals("ya")){
            maket1.setChecked(true);
            maket2.setChecked(false);
        }
        else if(nmaket.equals("tidak")){
            maket1.setChecked(false);
            maket2.setChecked(true);
        }
        if(nsimbol.equals("ya")){
            simbol1.setChecked(true);
            simbol2.setChecked(false);
        }
        else if(nsimbol.equals("tidak")){
            simbol1.setChecked(false);
            simbol2.setChecked(true);
        }
        if(narstistik.equals("ya")){
            ars1.setChecked(true);
            ars2.setChecked(false);
        }
        else if(narstistik.equals("tidak")){
            ars1.setChecked(false);
            ars2.setChecked(true);
        }
        if(nmegah.equals("ya")){
           megah1.setChecked(true);
            megah2.setChecked(false);
        }
        else if(nmegah.equals("tidak")){
            megah1.setChecked(false);
            megah2.setChecked(true);
        }
        if(nbersih.equals("ya")){
            bersih1.setChecked(true);
            bersih2.setChecked(false);
        }
        else if(nbersih.equals("tidak")){
            bersih1.setChecked(false);
            bersih2.setChecked(true);
        }
        if(nparkir.equals("ya")){
            parkir1.setChecked(true);
            parkir2.setChecked(false);
        }
        else if(nparkir.equals("tidak")){
           parkir1.setChecked(false);
            parkir2.setChecked(true);
        }
        if(nyamann.equals("ya")){
            nyaman1.setChecked(true);
            nyaman2.setChecked(false);
        }
        else if(nyaman1.equals("tidak")){
            nyaman1.setChecked(false);
            nyaman2.setChecked(true);
        }
        if(naman.equals("ya")){
            aman1.setChecked(true);
            aman2.setChecked(false);
        }
        else if(naman.equals("tidak")){
            aman1.setChecked(false);
            aman2.setChecked(true);
        }
        if(nartistik2.equals("ya")){
            a0.setChecked(true);
            a2.setChecked(false);
        }
        else if(nartistik2.equals("tidak")){
            a0.setChecked(false);
           ars2.setChecked(true);
        }
        if(nnajis.equals("ya")){
            najis1.setChecked(true);
            najis2.setChecked(false);
        }
        else if(nnajis.equals("tidak")){
            najis1.setChecked(false);
            najis2.setChecked(true);
        }
        if(nindah.equals("ya")){
            indah0.setChecked(true);
            indah1.setChecked(false);
        }
        else if(nindah.equals("tidak")){
            indah0.setChecked(false);
            indah1.setChecked(true);
        }
        if(nsehat.equals("ya")){
            sehat1.setChecked(true);
            sehat2.setChecked(false);
        }
        else if(nsehat.equals("tidak")){
           sehat1.setChecked(false);
            sehat2.setChecked(true);
        }

        
        up2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(idUser);
            }
        });

    }
    private void update(final String idUser){
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
        int najis2 = najis.getCheckedRadioButtonId();
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
        nbersih = Bersih.getText().toString();
        nparkir = Parkir.getText().toString();
        nyamann = Nyaman.getText().toString();
        naman = Aman.getText().toString();
        nartistik2 = Artitistik.getText().toString();
        nnajis = Najis.getText().toString();
        nindah = Indah.getText().toString();
        nsehat = Sehat.getText().toString();
        ketua = ketua1.getText().toString();
        sekretaris = sekretaris2.getText().toString();
        bendahara = bendahara3.getText().toString();
        sholatsubuh = sholat1.getText().toString();
        sholatdzuhur = sholat2.getText().toString();
        sholatmaghrib = sholat3.getText().toString();
        Ssertifikasi = sertfikasi.getText().toString();
        Simb = imb.getText().toString();




        StringRequest jArr = new StringRequest(Request.Method.POST,HostAddress.url + "api/updateb2/1234/"+ idUser,
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
                Toast.makeText(UpBidang2.this, "cek koneksi anda" , Toast.LENGTH_SHORT).show();

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("b2_namapapan", npapan);
                param.put("b2_maket", nmaket);
                param.put("b2_simbol", nsimbol);
                param.put("b2_artistik", narstistik);
                param.put("b2_kemegahan",nmegah);
                param.put("b2_kebersihan",nbersih);
                param.put("b2_parkir",nparkir);
                param.put("b2_nyaman",nyamann);
                param.put("b2_aman",naman);
                param.put("b2_artistik2",nartistik2);
                param.put("b2_najis",nnajis);
                param.put("b2_indah",nindah);
                param.put("b2_sehat",nsehat);
//                param.put("b2_fotodepan", getStringImage1(bitmap1));
//                param.put("b2_fotoutama", getStringImage2(bitmap2));
//                param.put("b2_fotowudhu", getStringImage3(bitmap3));
//                param.put("b2_fotokamar", getStringImage4(bitmap4));
                param.put("b2_ketua",ketua);
                param.put("b2_sekretaris",sekretaris);
                param.put("b2_bendahara",bendahara);
                param.put("b2_sertifikasi",Ssertifikasi);
                param.put("b2_imb",Simb);
                param.put("b2_sholatsubuh",sholatsubuh);
                param.put("b2_sholatdzuhur",sholatdzuhur);
                param.put("b2_sholatmaghrib",sholatmaghrib);


                return param;
            }
        };


        Volley.newRequestQueue(getApplicationContext()).add(jArr);
    }

    public String getStringImage1(Bitmap bmp) {
        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, bitmap_size, baos1);
        byte[] imageBytes = baos1.toByteArray();
        String encodedImage1 = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage1;
    }

    public String getStringImage2(Bitmap bmp) {
        ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, bitmap_size, baos2);
        byte[] imageBytes = baos2.toByteArray();
        String encodedImage2 = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage2;
    }

    public String getStringImage3(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, bitmap_size, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage3 = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage3;
    }

    public String getStringImage4(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, bitmap_size, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage4 = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage4;
    }
    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST1);
    }

    private void showFileChooser1() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST2);
    }
    private void showFileChooser2() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST3);
    }
    private void showFileChooser3() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST4);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //mengambil fambar dari Gallery
                bitmap1 = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                // 512 adalah resolusi tertinggi setelah image di resize, bisa di ganti.
                setToImageView(getResizedBitmap(bitmap1, 512));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (requestCode == PICK_IMAGE_REQUEST2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //mengambil fambar dari Gallery
                bitmap2 = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                // 512 adalah resolusi tertinggi setelah image di resize, bisa di ganti.
                setToImageView(getResizedBitmap(bitmap2, 512));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (requestCode == PICK_IMAGE_REQUEST3 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //mengambil fambar dari Gallery
                bitmap3 = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                // 512 adalah resolusi tertinggi setelah image di resize, bisa di ganti.
                setToImageView(getResizedBitmap(bitmap3, 512));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (requestCode == PICK_IMAGE_REQUEST4 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //mengambil fambar dari Gallery
                bitmap4 = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                // 512 adalah resolusi tertinggi setelah image di resize, bisa di ganti.
                setToImageView(getResizedBitmap(bitmap4, 512));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }
    private void setToImageView(Bitmap bmp) {
        //compress image
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, bitmap_size, bytes);
        decoded = BitmapFactory.decodeStream(new ByteArrayInputStream(bytes.toByteArray()));

        //menampilkan gambar yang dipilih dari camera/gallery ke ImageView
//        imageView.setImageBitmap(decoded);
    }
}
