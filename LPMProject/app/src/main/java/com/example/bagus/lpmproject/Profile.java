package com.example.bagus.lpmproject;

import android.content.SharedPreferences;
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

import java.util.HashMap;
import java.util.Map;

public class Profile extends AppCompatActivity {
    EditText namalengkap, pass;
    String nama, password;
    Button simpan;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        session = new SessionManager(getApplicationContext());

        HashMap<String, String> data = session.getUserDetails();
        final String idUser= data.get(SessionManager.KEY_NAME);

        namalengkap = (EditText)findViewById(R.id.nama);
        pass = (EditText)findViewById(R.id.passwordprofile);
        simpan = (Button)findViewById(R.id.simpan);
        Bundle bundle;
        bundle = getIntent().getExtras();
        namalengkap.setText(bundle.getString("nama_lengkap"));
        pass.setText(bundle.getString("password"));

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(idUser);
            }
        });
    }


    private void update(final String idUser){
        nama = namalengkap.getText().toString();
        password = pass.getText().toString();


        StringRequest jArr = new StringRequest(Request.Method.POST,HostAddress.url + "api/updateb1/1234/"+ idUser,
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
                Toast.makeText(Profile.this, "cek koneksi anda" , Toast.LENGTH_SHORT).show();

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("nama_lengkap",nama);
                param.put("password",password);;

                return param;
            }
        };


        Volley.newRequestQueue(getApplicationContext()).add(jArr);
    }
}
