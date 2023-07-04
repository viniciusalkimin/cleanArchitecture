package com.escola.infra.indicacao;

import com.escola.aplicacao.indicacao.EnviarEmailNotificacao;
import com.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoJavaMail implements EnviarEmailNotificacao {
    @Override
    public void enviarPara(Aluno indicado) {
        //Enviando email com JavaMail
    }
}
