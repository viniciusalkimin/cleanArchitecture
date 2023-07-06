package com.escola.aplicacao.aluno.matricular;

import com.escola.dominio.PublicadorDeEventos;
import com.escola.dominio.aluno.*;
import lombok.Data;

@Data
public class MatricularAluno {

    private final AlunoRepository alunoRepository;

    private AlunoFactory alunoFactory;

    private PublicadorDeEventos publicadorDeEventos;

    public MatricularAluno(AlunoRepository repositorio, PublicadorDeEventos publicador, AlunoFactory alunoFactory) {
        this.alunoRepository = repositorio;
        this.publicadorDeEventos = publicador;
        this.alunoFactory = alunoFactory;
    }

    public void matricuilar(MatricularAlunoDTO matricularAlunoDTO) {
        Aluno novoAluno = alunoFactory
                .comNomeCPFEmail(matricularAlunoDTO.getNomeAluno(),matricularAlunoDTO.getCpfAluno(),matricularAlunoDTO.getEmailAluno()).criar();
        alunoRepository.matricular(novoAluno);
        publicadorDeEventos.publicar(new AlunoMatriculado(novoAluno.getCpf()));
    }
}
