package com.senai.areaazul;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProcessandoPagamento extends AppCompatActivity {

    private  String tempo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_processando_pagamento);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();

            if (bundle != null) {
                tempo = intent.getStringExtra("tempo");
            }
        }

        Glide.with(this)
                .load(R.drawable.loading) // aqui é teu gif
                .asGif()
                .into((ImageView) findViewById(R.id.gifloading));

        ImageView gif = findViewById(R.id.gifaproved);
        gif.setVisibility(View.INVISIBLE);

        ImageView fecharComp = findViewById(R.id.fecharComp);
        fecharComp.setVisibility(View.INVISIBLE);

        ImageView share = findViewById(R.id.share);
        share.setVisibility(View.INVISIBLE);

        ImageView save = findViewById(R.id.save);
        save.setVisibility(View.INVISIBLE);

        ImageView comprovante = findViewById(R.id.comprovante);
        comprovante.setVisibility(View.INVISIBLE);

        TextView txtcomp = findViewById(R.id.txtsaidaconfirmada);
        txtcomp.setVisibility(View.INVISIBLE);


        delayPag();

    }

        public void delayPag(){
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    aprovado();
                }
            }, 5000);
        }

    public void aprovado(){

        TextView txt1 = findViewById(R.id.textView5);
        txt1.setText("Pagamento aprovado, gerando comprovante");
        ImageView gif = findViewById(R.id.gifloading);
        gif.setVisibility(View.INVISIBLE);
        ImageView gif2 = findViewById(R.id.gifaproved);

        Glide.with(this)
                .load(R.drawable.aproved) // aqui é teu gif
                .asGif()
                .into((ImageView) findViewById(R.id.gifaproved));

        gif2.setVisibility(View.VISIBLE);

        delayComprovante();
    }

    public void delayComprovante(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showComprovante();
            }
        }, 2000);
    }







    public void showComprovante(){

        TextView txt1 = findViewById(R.id.textView5);
        TextView txt2 = findViewById(R.id.textView6);
        txt1.setVisibility(View.INVISIBLE);
        txt2.setVisibility(View.INVISIBLE);
        ImageView gif2 = findViewById(R.id.gifaproved);
        gif2.setVisibility(View.INVISIBLE);


        ImageView comprovante = findViewById(R.id.comprovante);
        comprovante.setVisibility(View.VISIBLE);
        ImageView fecharComp = findViewById(R.id.fecharComp);
        fecharComp.setVisibility(View.VISIBLE);
        ImageView share = findViewById(R.id.share);
        share.setVisibility(View.VISIBLE);
        ImageView save = findViewById(R.id.save);
        save.setVisibility(View.VISIBLE);
        TextView txtcomp = findViewById(R.id.txtsaidaconfirmada);
        txtcomp.setVisibility(View.VISIBLE);


    }

    public void contador(View view){

        Intent intent = new Intent(this, contagemRegressiva.class);
        intent.putExtra("tempo", tempo);
        startActivity(intent);
        finish();

    }
}
