package com.example.calculadora.crud;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.example.calculadora.domain.Conta;

public class Dados {
    private static final List  dados = new LinkedList();
    private static Integer count=1;
    private Dados(){
    }
    public static void salvar(Conta o){
        if(dados.contains(o)) {
            dados.set(dados.indexOf(o), o);
        }else{
            o.setId(count++);
            dados.add(o);
        }
    }

    public static List getLista(){
       return dados;
    }

    public static void remove(int i) {
        dados.remove(i);
    }

}
