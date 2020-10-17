package com.senai.areaazul;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DadosEstacionamento extends AppCompatActivity {


    private String tempo;
    private String valor;

    String [] country = {"01:00","02:00","03:00","04:00"};

    private Spinner spinner;
    private TextView txtValor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dados_estacionamento);

        spinner = findViewById(R.id.spinner);
        txtValor = findViewById(R.id.txtValor);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, country
                );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        EditText placa = findViewById(R.id.edtplaca);
        placa.addTextChangedListener(MaskUtil.mask(placa, MaskUtil.FORMAT_PLACA));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int posicao, long id) {

                ((TextView) parent.getChildAt(0)).setTextSize(24);

                switch (posicao) {
                    case 0:
                        txtValor.setText("1,50");
                        valor = "1,50";
                        tempo = "1";
//                        Toast.makeText(parent.getContext(), "Spinner 1: "+posicao, Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        txtValor.setText("2,50");
                        tempo = "2";
                        valor = "2,50";
//                        Toast.makeText(parent.getContext(), "Spinner 2: "+posicao, Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        txtValor.setText("4,50");
                        tempo = "3";
                        valor = "4,50";
//                        Toast.makeText(parent.getContext(), "Spinner 3: "+posicao, Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        txtValor.setText("6,00");
                        tempo = "4";
                        valor ="6,00";
//                        Toast.makeText(parent.getContext(), "Spinner 4: "+tempo, Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        txtValor.setText("");
                        tempo = "0";
                        valor = "0,00";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void continuar(View view) {

        Intent intent = new Intent(this, DadosCartao.class);
        intent.putExtra("tempo", tempo);
        intent.putExtra("valor", valor);
        startActivity(intent);
        finish();
    }
}
