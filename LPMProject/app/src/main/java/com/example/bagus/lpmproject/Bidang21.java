package com.example.bagus.lpmproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Bidang21 extends AppCompatActivity {
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
    String npapan, nmaket, nsimbol, narstistik, nmegah, nbersih, nparkir, nyamann, naman, nartistik2, nnajis, nindah, nsehat, ketua,sekretaris,bendahara,
            sholatsubuh,sholatdzuhur,sholatmaghrib;
    EditText ketua1,sekretaris2,bendahara3, sholat1,sholat2,sholat3;
    Button simpan;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidang21);
        session = new SessionManager(getApplicationContext());

        HashMap<String, String> data = session.getUserDetails();
        final String idUser= data.get(SessionManager.KEY_NAME);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        ketua1 = (EditText)findViewById(R.id.ketua);
        sekretaris2 = (EditText)findViewById(R.id.sekretaris);
        bendahara3 = (EditText)findViewById(R.id.bendahara);
        sholat1 = (EditText)findViewById(R.id.subuh);
        sholat2 = (EditText)findViewById(R.id.ashar);
        sholat3 = (EditText)findViewById(R.id.maghrib);
        simpan = (Button)findViewById(R.id.smpn2);
        
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

        
        Intent bundle = getIntent();
        npapan = bundle.getStringExtra("b2_namapapan");
        nmaket = bundle.getStringExtra("b2_maket");
        nsimbol = bundle.getStringExtra("b2_simbol");
        narstistik = bundle.getStringExtra("b2_artistik");
        nmegah = bundle.getStringExtra("b2_kemegahan");
        nbersih = bundle.getStringExtra("b2_kebersihan");
        nparkir = bundle.getStringExtra("b2_parkir");
        nyamann = bundle.getStringExtra("b2_nyaman");
        naman = bundle.getStringExtra("b2_aman");
        nartistik2 = bundle.getStringExtra("b2_artistik2");
        nnajis = bundle.getStringExtra("b2_najis");
        nindah = bundle.getStringExtra("b2_indah");
        nsehat = bundle.getStringExtra("b2_sehat");

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                send(idUser);
            }
        });
    }

    public void send(final String idUser){
        ketua = ketua1.getText().toString();
        sekretaris = sekretaris2.getText().toString();
        bendahara = bendahara3.getText().toString();
        sholatsubuh = sholat1.getText().toString();
        sholatdzuhur = sholat2.getText().toString();
        sholatmaghrib = sholat3.getText().toString();

        StringRequest jArr = new StringRequest(Request.Method.POST,HostAddress.url + "backup/LPMUAD/bidangdua.php",
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
                Toast.makeText(Bidang21.this, "cek koneksi anda" , Toast.LENGTH_LONG).show();

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
                param.put("b2_ketua",ketua);
                param.put("b2_sekretaris",sekretaris);
                param.put("b2_bendahara",bendahara);
                param.put("b2_sholatsubuh",sholatsubuh);
                param.put("b2_sholatdzuhur",sholatdzuhur);
                param.put("b2_sholatmaghrib",sholatmaghrib);
                param.put("b2_fotodepan", getStringImage1(bitmap1));
                param.put("b2_fotoutama", getStringImage2(bitmap2));
                param.put("b2_fotowudhu", getStringImage3(bitmap3));
                param.put("b2_fotokamar", getStringImage4(bitmap4));
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
