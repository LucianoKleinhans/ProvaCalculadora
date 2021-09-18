package com.example.calculadora.domain;

import java.io.Serializable;

public class Conta implements Serializable {
    private Integer id;
    private String historicoConta;

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

    @Override
    public String toString() {
        return id + "=" + historicoConta ;
    }
}
