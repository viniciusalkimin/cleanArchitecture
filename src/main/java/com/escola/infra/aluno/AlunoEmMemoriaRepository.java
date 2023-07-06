package com.escola.infra.aluno;

import com.escola.dominio.aluno.Aluno;
import com.escola.dominio.aluno.AlunoRepository;
import com.escola.dominio.aluno.CPF;

import java.util.List;

public class AlunoEmMemoriaRepository implements AlunoRepository {
    @Override
    public void matricular(Aluno aluno) {
        System.out.println("Aluno matriculado e persistido em memória: "+ aluno.getNome());
    }

    @Override
    public Aluno buscarAlunoPorCPF(CPF cpf) {
        return null;
    }

    @Override
    public List<Aluno> buscarTodos() {
        return null;
    }
}
