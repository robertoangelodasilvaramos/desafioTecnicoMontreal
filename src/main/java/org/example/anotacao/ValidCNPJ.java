package org.example.anotacao;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ValidCNPJ {
    String message() default "CNPJ inválido";
}