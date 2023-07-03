package com.escola.aluno;

import com.escola.dominio.aluno.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void deveriaLancarExceccaoEmailInvalido(){
        assertThrows(IllegalArgumentException.class, () -> new Email("invalido.com"));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
    }

    @Test
    void deveriaInstanciarUmEmailValido(){
        var email = new Email("email@hotmail.org.br");
        assertNotNull(email);
    }

}