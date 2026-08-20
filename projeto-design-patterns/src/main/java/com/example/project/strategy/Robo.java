package com.example.project.strategy;

import com.example.project.strategy.comportamento.Comportamento;
import com.example.project.strategy.comportamento.impl.ComportamentoAgressivo;
import com.example.project.strategy.comportamento.impl.ComportamentoDefensivo;
import com.example.project.strategy.comportamento.impl.ComportamentoNormal;

public class Robo {
    private Comportamento comportamento;

    public void mover(){
        if(comportamento == null){
            show("se movendo normalmente");
            return;
        }
        show(comportamento.mover());
    }

    public void setComportamento(Comportamento comportamentoDoRobo){
        this.comportamento = comportamentoDoRobo;
    }

    public void show(String mensagem){
        System.out.println("=".repeat(30));
        System.out.println("O robo está " + mensagem);
    }

    public static void main(String[] args) {
        Robo robo = new Robo();

        Comportamento agressivo = new ComportamentoAgressivo();
        Comportamento normal = new ComportamentoNormal();
        Comportamento defensivo = new ComportamentoDefensivo();

        robo.setComportamento(defensivo);
        robo.mover();
        robo.setComportamento(agressivo);
        robo.mover();
        robo.setComportamento(normal);
        robo.mover();

    }
}
