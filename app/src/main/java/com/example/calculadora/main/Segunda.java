package com.example.calculadora.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculadora.R;
import com.example.calculadora.crud.Dados;
import com.example.calculadora.domain.Conta;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collection;
import java.util.function.Function;

public class Segunda extends AppCompatActivity {
    private TextView visao;
    Conta conta;
    private String op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda);
        visao = findViewById(R.id.textView);
        visao.setText("");
    }

    String Numero1 = "";
    String Numero2 = "";
    String Num = "";
    Float result;
    Integer caso = 0;

    public void numero(View view) {
        if (caso == 0){
            Button b = (Button) view;
            Num = (String) b.getText();
            visao.setText(visao.getText()+Num);
            Num = visao.getText().toString();
        } else {
            Button b = (Button) view;
            Num = (String) b.getText();
            visao.setText(visao.getText()+Num);
            Num = visao.getText().toString();
        }
    }

    public void operadorMais(View view) {
        if (Numero1.equals("")) {
            visao.setText(visao.getText()+" + ");
            Numero1 = Num;
            Num = "";
            caso = 1;
            visao.setText("");
        } else {
            Toast.makeText(this, "Clique Igual para somar", Toast.LENGTH_SHORT).show();
        }
    }

    public void operadorMenos(View view) {
        if (Numero1.equals("")) {
            visao.setText(visao.getText()+" - ");
            Numero1 = Num;
            Num = "";
            caso = 2;
            visao.setText("");
        }else{
            Toast.makeText(this, "Clique Igual para subtrair", Toast.LENGTH_SHORT).show();
        }
    }

    public void operadorDivisao(View view) {
        if (Numero1.equals("")) {
            visao.setText(visao.getText()+" / ");
            Numero1 = Num;
            Num = "";
            caso = 3;
            visao.setText("");
        }else{
            Toast.makeText(this, "Clique Igual para dividir", Toast.LENGTH_SHORT).show();
        }
    }

    public void operadorMulti(View view) {
        if (Numero1.equals("")) {
            visao.setText(visao.getText()+" * ");
            Numero1 = Num;
            Num = "";
            caso = 4;
            visao.setText("");
        }else{
            Toast.makeText(this, "Clique Igual para multiplicar", Toast.LENGTH_SHORT).show();
        }
    }

    public void ac(View view) {
        Numero1 = "";
        Numero2 = "";
        Num = "";
        caso = 0;
        visao.setText("");
        Toast.makeText(this, "Calculadora Limpa!", Toast.LENGTH_SHORT).show();
    }

    public void operadorIgual(View view) {
        conta = new Conta();
        switch (caso) {
            case 1://mais
                op = "+";
                Numero2 = Num;
                result = Float.parseFloat(Numero1) + Float.parseFloat(Numero2);
                visao.setText(Numero1+" + "+Numero2+" = "+result.toString());
                break;
            case 2://menos
                op = "-";
                Numero2 = Num;
                result = Float.parseFloat(Numero1) - Float.parseFloat(Numero2);
                visao.setText(Numero1+" - "+Numero2+" = "+result.toString());
                break;
            case 3://divisao
                op = "/";
                Numero2 = Num;
                result = Float.parseFloat(Numero1) / Float.parseFloat(Numero2);
                visao.setText(Numero1+" / "+Numero2+" = "+result.toString());
                break;
            case 4://multiplicaçao
                op = "*";
                Numero2 = Num;
                result = Float.parseFloat(Numero1) * Float.parseFloat(Numero2);
                visao.setText(Numero1+" * "+Numero2+" = "+result.toString());
                break;
        }
        conta.setNum1(Float.parseFloat(Numero1));
        conta.setOperador(op);
        conta.setNum2(Float.parseFloat(Numero2));
        conta.setHistoricoConta(result.toString());
        Dados.salvar(conta);
    }

    public void FecharCalculadora(View view) {
        if (result == 0){
            onBackPressed();
        }else{
            setResult(RESULT_OK);
            finish();
        }
    }
}
