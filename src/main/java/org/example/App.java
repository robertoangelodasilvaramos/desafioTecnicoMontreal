package org.example;


import org.example.model.PessoaFisica;
import org.example.model.PessoaJuridica;
import org.example.services.CalculadoraBensImoveis;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        // Exemplo de criação de estrutura societária
        PessoaJuridica empresaD = new PessoaJuridica("44.444.444/0001-44", 5, "44.444.444/0001-44", new ArrayList<>());
        PessoaJuridica empresaC = new PessoaJuridica("55.555.555/0001-55", 3, "55.555.555/0001-55", List.of(empresaD));

        PessoaFisica pessoa1 = new PessoaFisica("111.111.111-11", 1, "111.111.111-11");
        PessoaFisica pessoa2 = new PessoaFisica("222.222.222-22", 15, "222.222.222-22");
        PessoaFisica pessoa3 = new PessoaFisica("333.333.333-33", 2, "333.333.333-33");

        empresaD.setSocios(List.of(pessoa3));
        PessoaJuridica empresaA = new PessoaJuridica("11.111.111/0001-11", 10, "11.111.111/0001-11", List.of(pessoa1, pessoa2, empresaC));

        System.out.println("Valor total dos bens imóveis da Empresa A: R$ " + CalculadoraBensImoveis.calcularBensTotais(empresaA));

    }
}
