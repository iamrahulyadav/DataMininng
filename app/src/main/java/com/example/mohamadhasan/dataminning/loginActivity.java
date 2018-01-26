package com.example.mohamadhasan.dataminning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mohamadhasan.dataminning.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class loginActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtPass;
    private Button btnRegister;
    private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        helper = new DatabaseHelper(getApplicationContext());

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertToDb db = new insertToDb();
                db.execute();
            }
        });
    }

    private void initView() {
        edtName = (EditText) findViewById(R.id.edtName);
        edtPass = (EditText) findViewById(R.id.edtPass);
        btnRegister = (Button) findViewById(R.id.btnRegister);
    }

    private class insertToDb extends AsyncTask<Object, Void, Void> {

        List<String> s;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            List<String> s = new ArrayList<>();
        }

        @Override
        protected Void doInBackground(Object... params) {

            s = helper.selecUser(edtName.getText().toString(), edtPass.getText().toString());
            if (s.isEmpty()) {
                helper.insertNewUser(edtName.getText().toString(), edtPass.getText().toString());
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (s.isEmpty()) {

                SharedPreferences prefs = getSharedPreferences("MYPREFS", 0);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("USERNAME", edtName.getText().toString());
                editor.putString("PASS", edtPass.getText().toString());
                editor.apply();

                Intent intent = new Intent(loginActivity.this, favoriteActivity.class);
                startActivity(intent);
                finish();
            }
            else{
                Toast.makeText(getApplicationContext(), "کاربر تکراری می باشد", Toast.LENGTH_LONG).show();
            }
        }
    }

}
