package com.escola.dominio.aluno;

import lombok.Data;
import lombok.NonNull;

import java.util.regex.Pattern;

@Data
public class Email {

    @NonNull
    private String email;

    public Email(String email) {
        //String emailRegex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$";
        //String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        String emailRegex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        if(!Pattern.matches(emailRegex, email)) {
            throw new IllegalArgumentException("Informe um e-mail válido!");
        } else {
            this. email = email;
        }
    }
}
