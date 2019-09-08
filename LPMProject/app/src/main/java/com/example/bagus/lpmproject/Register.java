package com.example.bagus.lpmproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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

public class Register extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    Button simpan,reset;
    String nama,alamat,cp,email,username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ed1 = (EditText)findViewById(R.id.nama);
//        ed2 = (EditText)findViewById(R.id.alamat);
//        ed3 = (EditText)findViewById(R.id.cp);
//        ed4 = (EditText)findViewById(R.id.email);
        ed5 = (EditText)findViewById(R.id.username);
        ed6 = (EditText)findViewById(R.id.password);
        simpan = (Button)findViewById(R.id.simpan);
        reset = (Button)findViewById(R.id.reset);



        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText("");
                ed5.setText("");
                ed6.setText("");

            }
        });



        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpan();
            }
        });


    }
    private void simpan(){
        nama = ed1.getText().toString();
        username = ed5.getText().toString();
        password = ed6.getText().toString();
        if (nama.matches("")||username.matches("")||password.matches("")){
            Toast.makeText(Register.this, "\n" +
                    "data tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }else {
            StringRequest jArr = new StringRequest(Request.Method.POST,HostAddress.url + "api/adduser",
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
                    Toast.makeText(Register.this, "cek koneksi anda" , Toast.LENGTH_SHORT).show();

                }
            }) {

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> param = new HashMap<>();
                    param.put("nama_lengkap",nama);
                    param.put("username",username);
                    param.put("password",password);


                    return param;
                }
            };


            Volley.newRequestQueue(getApplicationContext()).add(jArr);
        }
    }

}
