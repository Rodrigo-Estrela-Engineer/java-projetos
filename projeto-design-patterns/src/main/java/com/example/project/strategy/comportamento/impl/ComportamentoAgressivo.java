package com.example.project.strategy.comportamento.impl;

import com.example.project.strategy.comportamento.Comportamento;

public class ComportamentoAgressivo implements Comportamento{
    @Override
    public String mover(){
        return "Movendo-se agressivamente";
    }
}
