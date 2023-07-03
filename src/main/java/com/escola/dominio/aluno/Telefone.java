package com.escola.dominio.aluno;

public class Telefone {
    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero){
        if(!ddd.matches("^[0-9]d{2}") && !numero.matches("^[0-9]{4,5}-[0-9]{4}$")) {
            throw new IllegalArgumentException("Telefone inválido!");
        }
        this.ddd = ddd;
        this.numero = numero;
    }
}
