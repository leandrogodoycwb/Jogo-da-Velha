/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.Jogador;
import controllers.Jogar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Luiz_
 */
public class Logar extends Jogador{
   
    private String nome;
    private String senha;
 
    
    public void Autenticar() throws SQLException {
    
        
       if(super.getNome()!= null && super.getSenha() != null && !super.getNome().isEmpty() && !super.getSenha().isEmpty()){
           
            Conexao con = new Conexao();
            Jogar jogo = new Jogar();
            Statement st = con.conexao.createStatement();
            ResultSet rs = st.executeQuery("Select * from jogador where nome_jogador = '" + super.getNome()+"'"
                                           + "and senha = '"+ super.getSenha()+"'");
            
            while(rs.next()){
                String jogador = rs.getString("nome_jogador");
                String senha2 = rs.getString("senha");
                if((super.getNome() == null ? jogador == null : super.getNome().equals(jogador)) && (super.getSenha() == null ? senha2 == null : super.getSenha().equals(senha2))){
                    System.out.println("\nLogado com sucesso\n bem vindo " + jogador);
                    jogo.entrarJogo();
                }
            }   
       } else {
           System.out.println("Preencha os dados com seu nome e senha de seu cadastro!!");
       }
    }
}