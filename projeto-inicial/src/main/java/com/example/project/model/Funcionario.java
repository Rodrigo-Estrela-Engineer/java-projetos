package com.example.project.model;

public final class Funcionario {
    private final String nome;
    private final Integer idade;
    private final Double salario;

        public Funcionario(String nome, Integer idade, Double salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

   

    public String nome() {
        return this.nome;
    }

    public Integer idade() {
        return this.idade;
    }

    public Double salario() {
        return this.salario;
    }

}
