package com.example.project.singleton;

/**
 * 
 * SingletonEager
 * 
 * é uma forma apressada de iniciar o Singleton
 */

public class SingletonEager {
    private static SingletonEager instancia = new SingletonEager();

    private SingletonEager(){
        super();
    }

    public static SingletonEager getInstancia(){
        return instancia;
    }


}
