package com.escola.aplicacao.aluno.matricular;

import com.escola.dominio.aluno.Aluno;
import com.escola.dominio.aluno.AlunoRepository;
import com.escola.dominio.aluno.CPF;
import com.escola.dominio.aluno.Email;
import lombok.Data;

@Data
public class MatricularAluno {

    private final AlunoRepository alunoRepository;

    public void matricuilar(MatricularAlunoDTO matricularAlunoDTO) {
        Aluno novoAluno = new Aluno(new CPF(matricularAlunoDTO.getCpfAluno()),
                matricularAlunoDTO.getNomeAluno(), new Email(matricularAlunoDTO.getEmailAluno()));
        alunoRepository.matricular(novoAluno);
    }
}
