package org.example.model;


import lombok.EqualsAndHashCode;
import org.example.anotacao.ValidCNPJ;

import java.util.List;
import java.util.Map;


@EqualsAndHashCode(callSuper = true)
public class PessoaJuridica extends Pessoa {

    @ValidCNPJ
    private String cnpj;
    private List<Pessoa> socios;

    public PessoaJuridica(String nome, double bensImoveis, String cnpj, List<Pessoa> socios) {
        super(nome, bensImoveis);
        this.cnpj = cnpj;
        this.socios = socios;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Pessoa> getSocios() {
        return socios;
    }

    public void setSocios(List<Pessoa> socios) {
        this.socios = socios;
    }

    @Override
    public double calcularBens(Map<String, Pessoa> visitados) {
        if (visitados.putIfAbsent(getNome(), this) != null) {
            return 0.0;
        }
        return getBensImoveis() + socios.stream()
                .mapToDouble(socio -> socio.calcularBens(visitados))
                .sum();
    }
}
