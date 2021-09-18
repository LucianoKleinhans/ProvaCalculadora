package com.example.calculadora.main;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.calculadora.R;

public class Primeira extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeira);
    }
//    private void atualiza() {
//        if(adapter==null){
//            adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, Dados.getLista());
//            lista.setAdapter(adapter);
//        }else
//            adapter.notifyDataSetChanged();
//    }
//    public void OpenCalculadora(View view) {
//        Intent it = new Intent(this, Segunda.class);
//        startActivityForResult(it, 201, null);
//    }
    public void OpenCalculadora(View view) {
        Intent it = new Intent(this, Segunda.class);
        startActivityForResult(it, 201, null);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 201) {
            if (resultCode == RESULT_OK) {
                //atualiza();
                Toast.makeText(this, "FOI", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "ERRO", Toast.LENGTH_SHORT).show();
            }
        }
    }
}