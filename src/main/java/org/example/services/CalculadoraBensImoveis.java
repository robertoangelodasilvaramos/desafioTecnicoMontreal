package org.example.services;



import org.example.model.PessoaJuridica;

import java.util.HashMap;
import java.util.Optional;

public class CalculadoraBensImoveis {

    public static double calcularBensTotais(PessoaJuridica empresa) {
        return Optional.ofNullable(empresa)
                .map(e -> e.calcularBens(new HashMap<>()))
                .orElse(0.0);
    }
}
