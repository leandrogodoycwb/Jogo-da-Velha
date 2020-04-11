/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.Jogar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Luiz_
 */
public class Logar{
   
    private String nome;
    private String senha;
 
    
    public void Autenticar() throws SQLException {
    
        
       if(this.getNome()!= null && this.getSenha() != null && !this.getNome().isEmpty() && !this.getSenha().isEmpty()){
           
            Conexao con = new Conexao();
            Jogar jogo = new Jogar();
            Statement st = con.conexao.createStatement();
            ResultSet rs = st.executeQuery("Select * from jogador where nome_jogador = '" + this.getNome()+"'"
                                           + "and senha = '"+ this.getSenha()+"'");
            
            while(rs.next()){
                String jogador = rs.getString("nome_jogador");
                String senha2 = rs.getString("senha");
                if((getNome() == null ? jogador == null : getNome().equals(jogador)) && (getSenha() == null ? senha2 == null : getSenha().equals(senha2))){
                    System.out.println("\nLogado com sucesso\n bem vindo " + jogador);
                    jogo.entrarJogo();
                } else {
                    System.out.println("Falha no login, nome ou senha incorreto");
                }
            }   
       } else {
           System.out.println("Preencha os dados com seu nome e senha!!");
       }
    }
     public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getSenha() {
        return senha;
    }
    
}