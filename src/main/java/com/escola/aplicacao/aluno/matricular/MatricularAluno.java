package com.escola.aplicacao.aluno.matricular;

import com.escola.dominio.aluno.*;
import lombok.Data;

@Data
public class MatricularAluno {

    private final AlunoRepository alunoRepository;

    private AlunoFactory alunoFactory;

    public void matricuilar(MatricularAlunoDTO matricularAlunoDTO) {
        Aluno novoAluno = alunoFactory
                .comNomeCPFEmail(matricularAlunoDTO.getNomeAluno(),matricularAlunoDTO.getCpfAluno(),matricularAlunoDTO.getEmailAluno()).criar();
        alunoRepository.matricular(novoAluno);
    }
}
