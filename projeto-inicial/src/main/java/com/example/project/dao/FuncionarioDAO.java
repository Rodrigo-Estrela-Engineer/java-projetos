package com.example.project.dao;

import com.example.project.persistance.ConexaoNeon;
import com.example.project.model.Funcionario;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class FuncionarioDAO {

    private static Connection con;
    public FuncionarioDAO(Connection con){
        this.con = con;
    }
    public void criarTabelaSeNaoExistir() {
        String sql = "CREATE TABLE IF NOT EXISTS funcionarios (" +
                    "id SERIAL PRIMARY KEY, " +
                    "nome VARCHAR(100) NOT NULL, " +
                    "idade INT NOT NULL, " +
                    "salario NUMERIC(10, 2) NOT NULL" +
                    ");";

        try (
            Statement stmt = con.createStatement()
        ) {
            stmt.execute(sql);
            System.out.println("Estrutura do banco verificada: Tabela 'funcionarios' pronta.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }


    public void insert(Funcionario funcionario){
        String sql = "INSERT INTO funcionarios (nome, idade, salario) VALUES (?, ?, ?);";
        try(
            PreparedStatement stmt = con.prepareStatement(sql)
        ){
           stmt.setString(1, funcionario.nome()); 
           stmt.setInt(2, funcionario.idade()); 
           stmt.setDouble(3, funcionario.salario()); 
           stmt.executeUpdate();
           System.out.printf("Inserindo funcionario %s no banco \n", funcionario.nome());
        }
        catch(SQLException e){
            System.err.println("Erro ao inserir funcionario -> " + e.getMessage());
        }

    }

    public void update(Funcionario funcionario, int id) {
        String sql = "UPDATE funcionarios SET nome = ?, idade = ?, salario = ? WHERE id = ?;";

        try (
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, funcionario.nome());
            stmt.setInt(2, funcionario.idade());
            stmt.setDouble(3, funcionario.salario());
            stmt.setInt(4, id);
           
            
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Dados do funcionário atualizados com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar funcionário: " + e.getMessage());
        }
    }

    public List<Funcionario> listAll(){
        String sql = "SELECT id, nome, idade, salario FROM funcionarios;";
        List<Funcionario> funcionarios = new ArrayList<>();
        try(
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ){
            while(rs.next()){
                Funcionario f = new Funcionario(
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getDouble("salario")
                );
                funcionarios.add(f);
            }
        }
        catch (SQLException e) {
            System.err.println("Erro ao listar funcionários: " + e.getMessage());
        }
        return funcionarios;
    }

    public Funcionario findByID(Integer id) {
        String sql = "SELECT id, nome, idade, salario FROM funcionarios WHERE id = ?;";
        
        try (
            PreparedStatement stmt = con.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Funcionario(
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getDouble("salario")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar funcionário por ID: " + e.getMessage());
        }
        return null;
    }

    public Boolean delete(Integer id) {
        String sql = "DELETE FROM funcionarios WHERE id = ?;";
        
        try (
            Connection con = ConexaoNeon.conectar();
            PreparedStatement stmt = con.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Erro ao deletar funcionário: " + e.getMessage());
            return false;
        }
    }
}