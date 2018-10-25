package com.example.aldino.kriptografi.PerSubs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aldino.kriptografi.R;

import java.util.regex.Pattern;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {



        TextView hasil2;
        Button encrypt2, decrypt2;
        EditText input2, key2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);

            hasil2 = (TextView) findViewById(R.id.hasil2);
            encrypt2 = (Button) findViewById(R.id.encrypt2);
            decrypt2 = (Button) findViewById(R.id.decrypt2);
            input2 = (EditText) findViewById(R.id.input2);
            key2 = (EditText) findViewById(R.id.key2);

            encrypt2.setOnClickListener(this);
            decrypt2.setOnClickListener(this);
        }

        public boolean check(){
//        plaintext
            if (input2.getText().toString().equals("") || key2.getText().toString().equals("")){
                Toast.makeText(this, "tidak boleh kosong", Toast.LENGTH_SHORT).show();
                return false;
            }

//        key
            boolean cek = true;
            for (int i = 0; i < key2.getText().toString().length(); i++) {
                String str = key2.getText().toString();
                if (!Pattern.matches("[0-9]", String.valueOf(str.charAt(i)))){
                    cek = false;
                    break;
                }
            }

            if (!cek){
                Toast.makeText(this, "key harus angka", Toast.LENGTH_SHORT).show();
                return false;
            }

            return true;
        }


        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.encrypt2:
                    if (check()){
                        Toast.makeText(this, "kepencet",Toast.LENGTH_SHORT).show();
                        PerSubs en = new PerSubs();
                        hasil2.setText(en.encrypt2(input2.getText().toString(), Integer.valueOf(key2.getText().toString())));
                    }
                    break;
                case R.id.decrypt2:
                    if (check()){
                        Toast.makeText(this, "kepencet",Toast.LENGTH_SHORT).show();
                        PerSubs ed = new PerSubs();
                        hasil2.setText(ed.decrypt2(input2.getText().toString(), Integer.valueOf(key2.getText().toString())));
                    }
                    break;
                default:
                    break;
            }
        }
    }
