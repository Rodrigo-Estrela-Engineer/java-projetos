package com.example.project.singleton;

/**
 * 
 * SingletonLazyHolder é uma outra maneira de iniciar um Singleton que é dita como threadsafe
 * 
 * é uma forma apressada de iniciar o Singleton
 */

public class SingletonLazyHolder {
    
    private static class InstanceHolder{
        private static SingletonLazyHolder instancia = new SingletonLazyHolder();
    }

    private SingletonLazyHolder(){
        super();
    }

    public static SingletonLazyHolder getInstancia(){
        return InstanceHolder.instancia;
    }


}
