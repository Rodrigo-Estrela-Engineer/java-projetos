package com.example.project.singleton;

import com.example.*;

/**
 * 
 * TestInstancia
 * Teste para validar se as instancias seriam as mesmas
 */

public class TestInstancia {
    public static void main(String[] args) {
        SingletonLazy lazy = SingletonLazy.getInstancy();
        System.out.println(lazy);
        SingletonLazy lazy2 = SingletonLazy.getInstancy();
        System.out.println(lazy2);

        SingletonEager Eager = SingletonEager.getInstancia();
        System.out.println(Eager);
        SingletonEager Eager2 = SingletonEager.getInstancia();
        System.out.println(Eager2);
        SingletonLazyHolder LazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(LazyHolder);
        SingletonLazyHolder LazyHolder2 = SingletonLazyHolder.getInstancia();
        System.out.println(LazyHolder2);
    }
}
