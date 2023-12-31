package com.escola.dominio.indicacao;

import com.escola.dominio.aluno.Aluno;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Indicacao {

    private Aluno indicado;

    private Aluno indicante;

    private LocalDate dataIndicacao;

    public Indicacao(Aluno indicado, Aluno indicante) {
        this.indicado = indicado;
        this.indicante = indicante;
        this.dataIndicacao = LocalDate.now();
    }
}
