package com.escola.dominio.aluno;

import com.escola.dominio.Evento;
import lombok.Getter;

import java.time.LocalDateTime;

public class AlunoMatriculado implements Evento {

    @Getter
    private final CPF cpfAluno;
    private final LocalDateTime momento;

    public AlunoMatriculado(CPF cpfAluno) {
        this.cpfAluno = cpfAluno;
        this.momento = LocalDateTime.now();
    }

    @Override
    public LocalDateTime momento() {
        return this.momento;
    }
}
