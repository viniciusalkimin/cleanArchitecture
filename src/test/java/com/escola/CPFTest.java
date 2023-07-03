package com.escola;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {

    @Test
    void deveriaLançarExceptionCPFInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new CPF("AV"));
        assertThrows(IllegalArgumentException.class, () -> new CPF("12547854711"));
    }

    @Test
    void deveriaInstanciarUmCPFValido(){
        var cpf = new CPF("429.158.418-80");
        assertNotNull(cpf);
    }

}