package com.senai.areaazul;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class aguardandoRetirada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_aguardando_retirada);
        delay();
    }

    public void delay(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                saidaConfirmada();
            }
        }, 4000);
    }

    public void saidaConfirmada(){

        TextView textoTitulo = findViewById(R.id.txtsaidaconfirmada);
        textoTitulo.setText("Saida confirmada");

        TextView textocima = findViewById(R.id.textocima);
        textocima.setText("A retirada da vaga foi confirmada com sucesso");

        TextView textobaixo = findViewById(R.id.textobaixo);
        textobaixo.setText("Obrigado por utilizar nossos serviços");

        ImageView img = findViewById(R.id.imagem);
        img.setImageResource(R.drawable.like);

        delaySair();
    }


    public void delaySair(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sair();
            }
        }, 3000);
    }

    public void sair(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}
