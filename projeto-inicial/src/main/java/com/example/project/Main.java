package com.example.project;

import com.example.project.dao.FuncionarioDAO;
import com.example.project.model.Funcionario;
import java.util.List;

class Main{
    public static void main(String[] args){
        Funcionario funcionario = new Funcionario("Rodrigo Estrela", 19, 1550.00);
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.criarTabelaSeNaoExistir();
        String esp = "=".repeat(10);
        System.out.println(esp+"Inserindo funcionário"+esp);
        dao.insert(funcionario);


        System.out.println(esp+"Listando Funcionarios"+esp);
        List<Funcionario> lista = dao.listAll();
        for(Funcionario f : lista){
            System.out.println(f);
        }



    }
}