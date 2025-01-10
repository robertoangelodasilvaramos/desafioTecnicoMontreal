package org.example.model;


import lombok.EqualsAndHashCode;
import org.example.anotacao.ValidCPF;

import java.util.Map;


@EqualsAndHashCode(callSuper = true)
public class PessoaFisica extends Pessoa{

    //valida automaticamente o cpf
    @ValidCPF
    private String cpf;

    public PessoaFisica(String nome, double bensImoveis, String cpf) {
        super(nome, bensImoveis);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public double calcularBens(Map<String, Pessoa> visitados) {
        //Se o nome da pessoa ainda não tiver sido atribuida e não for nula retorna o valor
        return visitados
                .putIfAbsent(getNome(), this) == null ? getBensImoveis() : 0.0;
    }
}
