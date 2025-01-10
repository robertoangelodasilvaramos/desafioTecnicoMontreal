package org.example.anotacao;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ValidCPF {
    String message() default "CPF inválido";
}