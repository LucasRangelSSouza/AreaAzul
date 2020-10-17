package com.senai.areaazul;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ContadorTempo extends CountDownTimer {

    private Context context;
    private TextView tv;
    private long tempoFuturo;
    private long intervalo;

    public ContadorTempo(Context context, TextView tv, long tempoFuturo, long intervalo){
        super(tempoFuturo, intervalo);
        this.context = context;
        this.tv = tv;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        tempoFuturo = millisUntilFinished;
        tv.setText(getCorrectTime(true, millisUntilFinished)+":"+
                getCorrectTime(false, millisUntilFinished));
    }

    @Override
    public void onFinish() {
//        tempoFuturo -= 1000;
        tv.setText(getCorrectTime(true, tempoFuturo)+":"+getCorrectTime(false, tempoFuturo));

        Toast.makeText(context, "FINISH!", Toast.LENGTH_SHORT).show();
    }

    private String getCorrectTime(boolean isMinute, long millisUntilFinished){
        String aux;
        int constCalendar = isMinute ? Calendar.MINUTE : Calendar.SECOND;
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millisUntilFinished);

        aux = c.get(constCalendar) < 10 ? "0"+c.get(constCalendar) : ""+c.get(constCalendar);
        return aux;
    }


}
