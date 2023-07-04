package com.escola.aplicacao.indicacao;

import com.escola.dominio.aluno.Aluno;

public interface EnviarEmailNotificacao {

    void enviarPara(Aluno indicado);
}
