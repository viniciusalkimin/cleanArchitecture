package com.escola;

import com.escola.aplicacao.aluno.matricular.MatricularAluno;
import com.escola.aplicacao.aluno.matricular.MatricularAlunoDTO;
import com.escola.dominio.PublicadorDeEventos;
import com.escola.dominio.aluno.AlunoFactory;
import com.escola.dominio.aluno.LogDeAlunoMatriculado;
import com.escola.infra.aluno.AlunoEmMemoriaRepository;

public class Main {
    public static void main(String[] args) {

        PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();

        AlunoEmMemoriaRepository alunoRepository = new AlunoEmMemoriaRepository();

        AlunoFactory alunoFactory = new AlunoFactory();

        MatricularAluno matricularAluno = new MatricularAluno(alunoRepository, publicadorDeEventos, alunoFactory);

        publicadorDeEventos.adicionar(new LogDeAlunoMatriculado());
        matricularAluno.matricuilar(new MatricularAlunoDTO("Vinicius","123.456.789-00","vinicius@email.com"));
    }
}
