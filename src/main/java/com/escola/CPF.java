package com.escola;

import lombok.Data;
import lombok.NonNull;

import java.util.regex.Pattern;

@Data
public class CPF {

    @NonNull
    private String cpf;

    public CPF(String cpf) {
        String regexCPF = "(^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$)";
        if(!Pattern.matches(regexCPF, cpf)){
            throw new IllegalArgumentException("Informe um CPF válido!");
        }
        this.cpf = cpf;
    }
}
