package com.escola.dominio.aluno;

import com.escola.dominio.Evento;
import com.escola.dominio.Ouvinte;

import java.time.format.DateTimeFormatter;

public class LogDeAlunoMatriculado extends Ouvinte {

    @Override
    public void reageAoEvento(Evento evento) {
        String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println(String.format("Aluno com o cpf %s, foi matriculado em %s.", ((AlunoMatriculado)evento).getCpfAluno(), momentoFormatado));
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}
