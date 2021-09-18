package com.example.calculadora.domain;

import java.io.Serializable;

public class Conta implements Serializable {
    private Integer id;
    private String historicoConta;
    private Float num1;
    private Float num2;
    private String operador;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHistoricoConta() {
        return historicoConta;
    }

    public void setHistoricoConta(String historicoConta) {
        this.historicoConta = historicoConta;
    }

    public Float getNum1() {
        return num1;
    }

    public void setNum1(Float num1) {
        this.num1 = num1;
    }

    public Float getNum2() {
        return num2;
    }

    public void setNum2(Float num2) {
        this.num2 = num2;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    @Override
    public String toString() {
        return num1 + " " + operador + " " + num2 + " = " + historicoConta;
    }

}
