package org.example.model;

import java.util.Map;

//classe mãe abstrata com atributos e metodos comum aos filhos
abstract class Pessoa {

    private String nome;
    private double bensImoveis;

    public abstract double calcularBens(Map<String, Pessoa> visitados);

    public Pessoa(String nome, double bensImoveis) {
        this.nome = nome;
        this.bensImoveis = bensImoveis;
    }

    public String getNome() {
        return nome;
    }

    public double getBensImoveis() {
        return bensImoveis;
    }
}
