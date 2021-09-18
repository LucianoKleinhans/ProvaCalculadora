package com.example.calculadora.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculadora.R;

import androidx.appcompat.app.AppCompatActivity;

public class Segunda extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda);
    }
    TextView visao;
    String Numero1 = null;
    String Numero2 = null;
    String Num = null;
    Float result;
    public void numero(View view) {
        Button b = (Button) view;
        Num = (String) b.getText();
    }

    public void operadorMenos(View view) {
        if (Numero1 == null){
            Numero1 = Num;
            Num = null;
        }else{
            Numero2 = Num;
            result = Float.parseFloat(Numero1) - Float.parseFloat(Numero2);
            visao.setText(result.toString());
        }

    }

    public void operadorIgual(View view) {
    }

    public void operadorMais(View view) {
    }
}
