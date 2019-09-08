package com.example.bagus.lpmproject;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText etUser;
    private EditText etPassword;
    private Button Login;
    private ProgressDialog pDialog;
    private Context context;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    SessionManager session;
    TextView daftar;
    final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = LoginActivity.this;

        pDialog = new ProgressDialog(context);
        // Get Reference to variables
        etUser = (EditText) findViewById(R.id.username);
        etPassword = (EditText) findViewById(R.id.password);
        Login = (Button)findViewById(R.id.btn_sign);
        session = new SessionManager(getApplicationContext());
        daftar = (TextView)findViewById(R.id.daftar);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        daftar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go = (new Intent(LoginActivity.this, Register.class));
                startActivity(go);
            }
        });

        Login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                checkLogin();
            }
        });
    }

    // Triggers when LOGIN Button clicked
    public void checkLogin() {

         final String user = etUser.getText().toString();
         final String pass = etPassword.getText().toString();


        pDialog.setMessage("Login Process...");
        showDialog();


        StringRequest strReq = new StringRequest(Request.Method.POST,
                HostAddress.url + "api/auth", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("eee",response);
                for (int i = 0; i < response.length(); i++) {

                        try {

                            JSONObject obj = new JSONObject(response);
                            String user = obj.getString("id_pengguna");
                            session.createLoginSession(user);



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    if (response.contains(HostAddress.login)) {
                        Success();
                    } else {
                        hideDialog();
                        Toast.makeText(context, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        hideDialog();
                        Toast.makeText(context, "The server unreachable", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", user);
                params.put("password", pass);

                return params;
            }
        };
        Volley.newRequestQueue(this).add(strReq);

    }

    private void Success() {
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);
        finish();

    }

        private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}


