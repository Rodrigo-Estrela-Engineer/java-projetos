package com.example.project.strategy.comportamento.impl;

import com.example.project.strategy.comportamento.Comportamento;

public class ComportamentoNormal implements Comportamento{
    @Override
    public String mover(){
        return "Movendo-se Normalmente";
    }
}
