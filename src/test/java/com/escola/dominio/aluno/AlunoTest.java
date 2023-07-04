package com.escola.dominio.aluno;

import com.escola.dominio.exception.ViolacaoDeDominioException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    public AlunoFactory alunoFactory = new AlunoFactory();
    @Test
    void deveriaCadastrarTelefoneComSucesso() {
        Aluno aluno = alunoFactory.comNomeCPFEmail("Vinicius", "123.456.789-00", "v@email.com").criar();
        aluno.adicionarTelefone("11", "91111-1111");
        aluno.adicionarTelefone("11", "2222-2222");
        assertEquals(2, aluno.getTelefones().size());
    }

    @Test
    void deveriaLancarViolacaoDeDominioExceptionQuandoAddTresTelefones() {
        Aluno aluno = alunoFactory.comNomeCPFEmail("Vinicius", "123.456.789-00", "v@email.com").criar();
        aluno.adicionarTelefone("11", "91111-1111");
        aluno.adicionarTelefone("11", "2222-2222");
        assertThrows(ViolacaoDeDominioException.class, () -> aluno.adicionarTelefone("11", "3333-3333"));
    }

}