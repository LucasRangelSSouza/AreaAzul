package com.senai.areaazul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DadosCartao extends AppCompatActivity {

    private ContadorTempo time;
    private int tempo;
    private String valor;
    private String preco;
    private EditText edtNumCartao;
    private EditText edtDtVencimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_dados_cartao);

        edtNumCartao = findViewById(R.id.edtNumCartao);
        edtNumCartao.addTextChangedListener(MaskUtil.mask(edtNumCartao, MaskUtil.FORMAT_NUMERO));

        edtDtVencimento = findViewById(R.id.edtDtVencimento);
        edtDtVencimento.addTextChangedListener(MaskUtil.mask(edtDtVencimento, MaskUtil.FORMAT_VENCIMENTO));

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();

            if (bundle != null) {
                valor = intent.getStringExtra("tempo");
                preco = intent.getStringExtra("valor");
            }
        }
        // VALIDAR SE ESTA PASSANDO O PARAMETRO
//        Toast.makeText(this, "Valor :"+valor, Toast.LENGTH_SHORT).show();

        TextView valortotal = findViewById(R.id.txtValor);
        valortotal.setText(preco);
    }

    public void finalizar(View view) {

        Intent intent = new Intent(this, ProcessandoPagamento.class);
        intent.putExtra("tempo", valor);
        startActivity(intent);
        finish();
        /*tempo = Integer.parseInt(valor);
        TextView tv = findViewById(R.id.txtViewCronometro);
        //PARA COLOCAR EM HORAS MUDAR A FUNCAO PARA TEMPO*60*1000
        time = new ContadorTempo(this, tv, tempo*1000,1000);
        time.start();
    */
    }

}
