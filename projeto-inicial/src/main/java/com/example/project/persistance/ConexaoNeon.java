package com.example.project.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class ConexaoNeon{
    private static final String  HOST;
    private static final String NAME;
    private static final String USER;
    private static final String PASSWORD;

    
    static{
        Dotenv dotenv = Dotenv.load();
        HOST = dotenv.get("DB_HOST");
        NAME = dotenv.get("DB_NAME");
        USER = dotenv.get("DB_USER");
        PASSWORD = dotenv.get("DB_PASSWORD");
    }

    public static Connection conectar(){
        try{
            String URL = "jdbc:postgresql://" + HOST + "/" + NAME + "?sslmode=require";
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch(SQLException e){
            System.err.println("Erro ao conectar ao Neon: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args){
        Connection con = conectar();
        System.out.println("Conexao com o banco: " + con);
    }
}