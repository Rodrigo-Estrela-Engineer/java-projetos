package com.example.project.strategy.comportamento.impl;

import com.example.project.strategy.comportamento.Comportamento;

public class ComportamentoDefensivo implements Comportamento {
    @Override
    public String mover(){
        return "Movendo-se defensivamente";
    }
}
