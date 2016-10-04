package com.mindfactory.calculadoralucas5;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    private EditText _edit;
    private Button _b1;
    private Button _b2;
    private Button _b3;
    private Button _b4;
    private Button _b5;
    private Button _b6;
    private Button _b7;
    private Button _b8;
    private Button _b9;
    private Button _b0;
    private Button _bSoma;
    private Button _bSubtrair;
    private Button _bMultiplicar;
    private Button _bDividir;
    private Button _bIgual;
    private Button _bC;

    private int _valor;
    private int _operacao;

    private boolean _novoValor = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _valor = 0;

        _edit = (EditText)findViewById(R.id.editTextos);
        _b0 = (Button)findViewById(R.id.button0);
        _b1 = (Button)findViewById(R.id.button1);
        _b2 = (Button)findViewById(R.id.button2);
        _b3 = (Button)findViewById(R.id.button3);
        _b4 = (Button)findViewById(R.id.button4);
        _b5 = (Button)findViewById(R.id.button5);
        _b6 = (Button)findViewById(R.id.button6);
        _b7 = (Button)findViewById(R.id.button7);
        _b8 = (Button)findViewById(R.id.button8);
        _b9 = (Button)findViewById(R.id.button9);
        _bSoma = (Button)findViewById(R.id.buttonSoma);
        _bSubtrair = (Button)findViewById(R.id.buttonSubtrair);
        _bMultiplicar = (Button)findViewById(R.id.buttonMultiplicar);
        _bDividir = (Button)findViewById(R.id.buttonDividir);
        _bIgual = (Button)findViewById(R.id.buttonIgual);
        _bC = (Button)findViewById(R.id.buttonC);

        _edit.setText("");

        View.OnClickListener lsBtn = new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                _edit.setTextColor(Color.BLACK);
                //zerarValor();
                _edit.setText(_edit.getText()+((Button)arg0).getText().toString());
            }
        };

        View.OnClickListener lsBtnOperacao = new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent it = new Intent(MainActivity.this, ResultadoActivity.class);

                Bundle params = new Bundle();
                params.putString("calculo", _edit.getText().toString());
                it.putExtras(params);

                startActivity(it);
            }
        };

        _b1.setOnClickListener(lsBtn);
        _b2.setOnClickListener(lsBtn);
        _b3.setOnClickListener(lsBtn);
        _b4.setOnClickListener(lsBtn);
        _b5.setOnClickListener(lsBtn);
        _b6.setOnClickListener(lsBtn);
        _b7.setOnClickListener(lsBtn);
        _b8.setOnClickListener(lsBtn);
        _b9.setOnClickListener(lsBtn);
        _b0.setOnClickListener(lsBtn);

        _bSoma.setOnClickListener(lsBtn);
        _bSubtrair.setOnClickListener(lsBtn);
        _bMultiplicar.setOnClickListener(lsBtn);
        _bDividir.setOnClickListener(lsBtn);
        _bIgual.setOnClickListener(lsBtnOperacao);

        _bC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                _edit.setText("");
                _novoValor = true;
                _operacao = -1;
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        zerarValor();
        Log.i("Teste", getClassName() + "onDestroy()");
    }

    public void onRestart(){
        super.onRestart();
        zerarValor();
        Log.i("Teste", getClassName() + "onDestroy()");
    }

    public void onResume(){
        super.onResume();
        zerarValor();
        Log.i("Teste", getClassName() + "onDestroy()");
    }

    public void onPause(){
        super.onPause();
        zerarValor();
        Log.i("Teste", getClassName() + "onDestroy()");
    }

    public void onStop(){
        super.onStop();
        zerarValor();
        Log.i("Teste", getClassName() + "onDestroy()");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.i("Teste", getClassName() + "onDestroy()");
    }

    private  String getClassName(){
        String s = getClass().getName();
        return s.substring(s.lastIndexOf("."));
    }

    private void zerarValor()
    {
        if (_novoValor == true)
        {
            _edit.setText("");
            _novoValor = false;
        }
    }
}
