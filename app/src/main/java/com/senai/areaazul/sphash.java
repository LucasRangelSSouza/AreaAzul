package com.senai.areaazul;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class sphash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sphash);

        delay();
    }

    public void delay(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iniciar();
            }
        }, 3000);
    }

    public void iniciar(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
