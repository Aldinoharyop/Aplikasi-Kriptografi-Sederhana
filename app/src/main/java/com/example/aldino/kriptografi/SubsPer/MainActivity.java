package com.example.aldino.kriptografi.SubsPer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aldino.kriptografi.R;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView hasil;
    Button encrypt, decrypt;
    EditText input, key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hasil = (TextView) findViewById(R.id.hasil);
        encrypt = (Button) findViewById(R.id.encrypt);
        decrypt = (Button) findViewById(R.id.decrypt);
        input = (EditText) findViewById(R.id.input);
        key = (EditText) findViewById(R.id.key);

        encrypt.setOnClickListener(this);
        decrypt.setOnClickListener(this);
    }

    public boolean check(){
//        plaintext
        if (input.getText().toString().equals("") || key.getText().toString().equals("")){
            Toast.makeText(this, "tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return false;
        }

//        key
        boolean cek = true;
        for (int i = 0; i < key.getText().toString().length(); i++) {
            String str = key.getText().toString();
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
            case R.id.encrypt:
                if (check()){
                    SubsPer en = new SubsPer();
                    hasil.setText(en.encrypt(input.getText().toString(), Integer.valueOf(key.getText().toString())));
                }
                break;
            case R.id.decrypt:
                if (check()){
                    SubsPer ed = new SubsPer();
                    hasil.setText(ed.decrypt(input.getText().toString(), Integer.valueOf(key.getText().toString())));
                }
                break;
                default:
                    break;
        }
    }
}
