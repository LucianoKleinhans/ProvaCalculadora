package com.example.calculadora.main;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.calculadora.R;
import com.example.calculadora.crud.Dados;
import com.example.calculadora.domain.Conta;

public class Primeira extends AppCompatActivity {

    private ListView lista;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeira);
        lista = findViewById(R.id.historico);
        atualiza();

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Dados.remove(i);

                atualiza();
                return true;
            }
        });
    }

    private void atualiza() {
        if(adapter==null){
            adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, Dados.getLista());
            lista.setAdapter(adapter);
        }else
            adapter.notifyDataSetChanged();
    }

    public void OpenCalculadora(View view) {
        Intent it = new Intent(this, Segunda.class);
        startActivityForResult(it, 100, null);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                atualiza();
                Toast.makeText(this, "Conta Realizada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Conta Finalizada", Toast.LENGTH_SHORT).show();
            }
        }
    }
}