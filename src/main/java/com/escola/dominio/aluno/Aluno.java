package com.escola.dominio.aluno;

import lombok.Data;

import java.util.List;

@Data
public class Aluno {

    private CPF cpf;
    private String nome;
    private Email email;
    private List<Telefone> telefones;

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefone(String ddd, String numero) {
        var telefone = new Telefone(ddd, numero);
        telefones.add(telefone);
    }
}
