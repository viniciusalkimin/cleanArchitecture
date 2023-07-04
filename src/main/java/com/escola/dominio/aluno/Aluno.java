package com.escola.dominio.aluno;

import com.escola.dominio.exception.ViolacaoDeDominioException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Aluno {

    private CPF cpf;
    private String nome;
    private Email email;
    private List<Telefone> telefones;
    private String senha;

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefones = new ArrayList<>();
    }

    public void adicionarTelefone(String ddd, String numero) {
        if (telefones.size() == 2 ) {
            throw new ViolacaoDeDominioException("Aluno já  possui a quantidade máxima de 2 telefones.");
        }
        var telefone = new Telefone(ddd, numero);
        telefones.add(telefone);
    }
}
