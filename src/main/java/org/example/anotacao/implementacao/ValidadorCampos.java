package org.example.anotacao.implementacao;


import org.example.anotacao.ValidCNPJ;
import org.example.anotacao.ValidCPF;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.regex.Pattern;

//classe que implementa as anotations
public class ValidadorCampos {

    private static final String CPF_REGEX = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
    private static final String CNPJ_REGEX = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}";

    public static void validar(Object objeto) {
        Field[] campos = objeto.getClass().getDeclaredFields();

        for (Field campo : campos) {
            campo.setAccessible(true);
            for (Annotation anotacao : campo.getAnnotations()) {
                if (anotacao instanceof ValidCPF) {
                    validarCPF(campo, objeto);
                } else if (anotacao instanceof ValidCNPJ) {
                    validarCNPJ(campo, objeto);
                }
            }
        }
    }

    private static void validarCPF(Field campo, Object objeto) {
        try {
            String valor = (String) campo.get(objeto);
            if (valor == null || !Pattern.matches(CPF_REGEX, valor)) {
                throw new IllegalArgumentException("CPF inválido no campo " + campo.getName());
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Erro ao acessar o campo " + campo.getName(), e);
        }
    }

    private static void validarCNPJ(Field campo, Object objeto) {
        try {
            String valor = (String) campo.get(objeto);
            if (valor == null || !Pattern.matches(CNPJ_REGEX, valor)) {
                throw new IllegalArgumentException("CNPJ inválido no campo " + campo.getName());
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Erro ao acessar o campo " + campo.getName(), e);
        }
    }
}