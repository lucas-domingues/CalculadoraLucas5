package com.mindfactory.calculadoralucas5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        Intent it = getIntent();
        Bundle params = it.getExtras();
        String res = params.getString("calculo");

        String operacao = "";

        for (char i : res.toCharArray()) {
            if (i == '*' || i == '/' || i == '+' || i == '-') {
                operacao = String.valueOf(i);
            }
        };
        String val1 = res.substring(0, res.indexOf(operacao));
        String val2 = res.substring(res.indexOf(operacao) + 1);

        Integer resultado = 0;

        if (operacao.equals("+"))
            resultado = Integer.parseInt(val1) + Integer.parseInt(val2);
        if (operacao.equals("*"))
            resultado = Integer.parseInt(val1) * Integer.parseInt(val2);
        if (operacao.equals("/"))
            resultado = Integer.parseInt(val1) / Integer.parseInt(val2);
        if (operacao.equals("-"))
            resultado = Integer.parseInt(val1) - Integer.parseInt(val2);

        TextView tRes = (TextView)findViewById(R.id.res);

        tRes.setText(resultado.toString());


    }
}
