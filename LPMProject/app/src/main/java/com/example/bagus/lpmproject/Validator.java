package com.example.bagus.lpmproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Validator extends AppCompatActivity {

    EditText namaM,nim;
    String namaMas,nimMas;
    Button simpan, reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validator);


        namaM = (EditText)findViewById(R.id.mhs);
        nim = (EditText)findViewById(R.id.nim);

        simpan = (Button)findViewById(R.id.simpan2);
        reset = (Button)findViewById(R.id.reset2);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                namaM.setText("");
                nim.setText("");

            }
        });

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                namaMas = namaM.getText().toString();
                nimMas = nim.getText().toString();

                if (namaMas.matches("")||nimMas.matches("")){
                    Toast.makeText(Validator.this, "\n" +
                            "data tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else {
                    simpan();
                }
            }
        });
    }

    private void simpan(){
        StringRequest jArr = new StringRequest(Request.Method.POST,HostAddress.url + "LPMUAD/validator.php",
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.e("eee",response.toString());
                        try {
                            JSONObject res = new JSONObject(response);
                            Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("E", error.getMessage());
                Toast.makeText(Validator.this, "cek koneksi anda" , Toast.LENGTH_SHORT).show();

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("nama_mhs",namaMas);
                param.put("nim",nimMas);


                return param;
            }
        };


        Volley.newRequestQueue(getApplicationContext()).add(jArr);
    }
}
