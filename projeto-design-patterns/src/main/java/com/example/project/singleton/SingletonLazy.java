package com.example.project.singleton;

/**
 * 
 * Singleton "preguiçoso"
 * 
 * @author Rodrigo-Estrela-Engineer
 * 
 */
public class SingletonLazy {
    private static SingletonLazy instancia;
    private SingletonLazy(){
        super();
    }

    public static SingletonLazy getInstancy(){
        if(instancia ==null){
            return instancia = new SingletonLazy();
        }
        return instancia;
    }

}
