package com.escola;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    @Test
    void deveriaLancarExceptionTelefoneInvalido(){
        assertThrows(IllegalArgumentException.class, () -> new Telefone("1","123"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("AA","AV125-78547"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("11","123456-12345"));
    }

    @Test
    void deveriaInstanciarUmTelefoneValido() {
        assertNotNull(new Telefone("11", "12345-8769"));
        assertNotNull(new Telefone("11", "1234-8769"));
    }

}