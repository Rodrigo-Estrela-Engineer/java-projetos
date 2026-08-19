package com.example.project;

import com.example.project.dao.FuncionarioDAO;
import com.example.project.model.Funcionario;
import com.example.project.persistance.ConexaoNeon;
import java.util.List;

class Main{
    public static void main(String[] args){
        Funcionario funcionario = new Funcionario("Miguel Lucas", 19, 3000.00);
        FuncionarioDAO dao = new FuncionarioDAO(ConexaoNeon.conectar());
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