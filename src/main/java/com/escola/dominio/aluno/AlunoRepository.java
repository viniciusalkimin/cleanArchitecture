package com.escola.dominio.aluno;

import java.util.List;

public interface AlunoRepository {

    void matricular(Aluno aluno);

    Aluno buscarAlunoPorCPF(CPF cpf);

    List<Aluno> buscarTodos();
}

