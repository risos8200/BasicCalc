package com.example.risos8200.basiccalc;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public TextView editText;
    public String bT = "0", bt;
    int a = 0, d = 0;
    public Button clc;
    public float num1 = 0, num2 = 0, res = 0, dom = 0.1f, m = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_layout);
        editText = (TextView) findViewById(R.id.editxt);
        clc = (Button) findViewById(R.id.buttonDelete);
        editText.setText("0.0");
    }

    public int Onclc(View v) {
        Button b = (Button) v;
        clc.setText("DEL");
        bT = b.getText().toString();
        bT = bT.trim();
        if (bT.equals(".")) {
            Log.d("bT", bT);
            d = 1;
            return (0);
        }
        if (a == 0) {
            if (d == 0) {
                num1 = num1 * 10 + Float.parseFloat(bT);
                editText.setText(String.valueOf(num1));
            } else {
                Log.d("i cam here", "here");
                num1 = num1 + dom * (Float.parseFloat(bT));
                editText.setText(String.valueOf(num1));
            }
        } else if (a == 1) {
            if (d == 0) {
                num2 = num2 * 10 + Float.parseFloat(bT);
                editText.setText(String.valueOf(num2));
            } else {
                num2 = num2 + dom * (Float.parseFloat(bT));
                editText.setText(String.valueOf(num2));
            }
        }
        return (0);
    }

    public void arth(View v) {
        clc.setText("DEL");
        a = 1;
        d = 0;
        Log.d("Num1", String.valueOf(num1));
        Button b = (Button) v;
        bt = b.getText().toString();
        bt = bt.trim();
        Log.d("bt", bt);
    }

    public void equal(View v) {
        if (bt.equals("+")) {
            res = num1 + num2;
            editText.setText(String.valueOf(res));
        } else if (bt.equals("-")) {
            res = num1 - num2;
            editText.setText(String.valueOf(res));
        } else if (bt.equals("*")) {
            res = num1 * num2;
            editText.setText(String.valueOf(res));
        } else if (bt.equals("/")) {
            res = num1 / num2;
            editText.setText(String.valueOf(res));
        }
        num1 = res;
        num2 = 0;
        a = 0;
        clc.setText("C");
    }

    public void clear(View v) {
        m = 0;
        String cr = clc.getText().toString();
        if (cr.equals("DEL")) {
            if (a == 0) {
                m = num1 % 10;
                num1 -= m;
                num1 /= 10;
                editText.setText(String.valueOf(num1));
            } else {
                m = num2 % 10;
                num2 -= m;
                num2 /= 10;
                editText.setText(String.valueOf(num2));
            }
        } else if (cr.equals("C")) {
            editText.setText("0.0");
            num1 = 0;
            num2 = 0;
            clc.setText("DEL");
        }
    }
}