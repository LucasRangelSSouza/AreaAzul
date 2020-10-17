package com.senai.areaazul;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class contagemRegressiva extends AppCompatActivity {

    String valor;
    int tempo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_contagem_regressiva);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();

            if (bundle != null) {
                valor = intent.getStringExtra("tempo");
            }
        }
    /*
        Toast.makeText(
                getApplicationContext(),
                tempo,
                Toast.LENGTH_SHORT
        ).show();
*/

        tempo = Integer.parseInt(valor);
        TextView tv = findViewById(R.id.txtViewCronometro);
        //PARA COLOCAR EM HORAS MUDAR A FUNCAO PARA TEMPO*60*1000
        ContadorTempo time = new ContadorTempo(this, tv, tempo * 1000, 1000);
        time.start();
        delay(tempo*1000);
    }

    public void delay(int tempo){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                acabouTempo();
            }
        }, 2000);
    }

    public void acabouTempo(){

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Seu tempo acabou");
        alerta.setMessage("Seu tempo de permanencia acabou por favor retire  o seu carro da vaga ou renove seu tempo!!");
        alerta.setCancelable(false);
        //configurar açoes para sim/nao
        alerta.setPositiveButton("Renovar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Exibir toast padraozao
                renovar();


            }
        });

        alerta.setNegativeButton("Sair da vaga", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Exibir toast padraozao
                sairDaVaga();



            }
        });
        // exibir alert

        AlertDialog alert = alerta.create();
        alert.show();
        TextView textView = (TextView) alert.findViewById(android.R.id.message);
        textView.setTextSize(24);



    }

    public  void  renovar(){

        Intent intent = new Intent(this, DadosEstacionamento.class);
        startActivity(intent);
        finish();

    }

    public void sairDaVaga(){

       Intent intent2 = new Intent(this, aguardandoRetirada.class);
       startActivity(intent2);
        finish();

    }
}
