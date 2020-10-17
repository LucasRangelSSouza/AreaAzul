package com.senai.areaazul;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MyCountDownTime extends CountDownTimer {

    private Context context;
    private TextView tv;
    private long timeInFuture;
    private long interval;

    public MyCountDownTime(Context context, TextView tv, long timeInFuture, long interval){
        super(timeInFuture, interval);
        this.context = context;
        this.tv = tv;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        timeInFuture = millisUntilFinished;
        tv.setText(getCorrectTime(true, millisUntilFinished)+":"+
                getCorrectTime(false, millisUntilFinished));
    }

    @Override
    public void onFinish() {
        timeInFuture = 1000;
        tv.setText(getCorrectTime(true, timeInFuture)+":"+getCorrectTime(false, timeInFuture));

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
