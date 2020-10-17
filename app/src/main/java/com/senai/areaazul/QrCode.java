package com.senai.areaazul;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QrCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_qr_code);

    }

    public void lerQR(View view) {
        final Activity activity = this;
        IntentIntegrator integrator = new IntentIntegrator(activity);

        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Leia o QR Code presente na vaga");
        integrator.setCameraId(0);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if(result!=null){
            if(result.getContents()!=null){

                ImageView tipovaga = findViewById(R.id.tipoVaga);

                TextView txtViewLeitura  =  findViewById(R.id.txtViewLeitura);
                String vaga = result.getContents(); //result.getContents retorna a string do qrcode String
                txtViewLeitura.setText(vaga);

                if(vaga.equals("001")){
                    txtViewLeitura.setText("Av Goiás - ST. Central - Goiânia GO\nVaga 001");
                    tipovaga.setImageResource(R.drawable.parking);

                }
                if(vaga.equals("002")){
                    txtViewLeitura.setText("Av Goiás - ST. Central - Goiânia GO\nVaga 002\nEstá é uma vaga reservada para Idosos\n Por favor deixe seu cartao em um local visivel dentro do seu carro");
                    tipovaga.setImageResource(R.drawable.elderly);

                }
                if(vaga.equals("003")){
                    txtViewLeitura.setText("Av Goiás - ST. Central - Goiânia GO\nVaga 003\nEstá é uma vaga reservada para pessoas portadoras de necessidades especiais\n Por favor deixe seu cartao em um local visivel dentro do seu carro");
                    tipovaga.setImageResource(R.drawable.wheelchair);


                }else{
                    Toast.makeText(
                            getApplicationContext(),
                            "Nao reconheci esta vaga, por favor tente novamente",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }

    public void continuar(View view){
        Intent intent = new Intent(this, DadosEstacionamento.class);
        startActivity(intent);
        finish();
    }
}