package com.example.calculadora.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculadora.R;

import androidx.appcompat.app.AppCompatActivity;

public class Segunda extends AppCompatActivity {
    private TextView visao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda);
        visao= findViewById(R.id.textView);
        visao.setText("");
    }
    String Numero1 = "";
    String Numero2 = "";
    String Num = "";
    Float result;
    Integer caso = 0;
    public void numero(View view) {
        Button b = (Button) view;
        Num = (String) b.getText();
        visao.setText(visao.getText()+Num);
    }

    public void operadorMenos(View view) {
        if (Numero1.equals("")) {
            visao.setText(visao.getText()+" - ");
            Numero1 = Num;
            Num = "";
            caso = 2;
        }
    }

    public void operadorMais(View view) {
        if (Numero1.equals("")) {
            visao.setText(visao.getText()+" + ");
            Numero1 = Num;
            Num = "";
            caso = 1;
        }
    }

    public void operadorDivisao(View view) {
        if (Numero1.equals("")) {
            visao.setText(visao.getText()+" / ");
            Numero1 = Num;
            Num = "";
            caso = 3;
        }
    }

    public void operadorMulti(View view) {
        if (Numero1.equals("")) {
            visao.setText(visao.getText()+" * ");
            Numero1 = Num;
            Num = "";
            caso = 4;
        }
    }

    public void ac(View view) {
        Numero1 = "";
        Numero2 = "";
        Num = "";
        visao.setText("");
    }

    public void operadorIgual(View view) {
        switch (caso) {
            case 1://mais
                Numero2 = Num;
                result = Float.parseFloat(Numero1) + Float.parseFloat(Numero2);
                visao.setText(result.toString());
                break;
            case 2://menos
                Numero2 = Num;
                result = Float.parseFloat(Numero1) - Float.parseFloat(Numero2);
                visao.setText(result.toString());
                break;
            case 3://divisao
                Numero2 = Num;
                result = Float.parseFloat(Numero1) / Float.parseFloat(Numero2);
                visao.setText(result.toString());
                break;
            case 4://multiplicaçao
                Numero2 = Num;
                result = Float.parseFloat(Numero1) * Float.parseFloat(Numero2);
                visao.setText(result.toString());
                break;
        }
    }
}
