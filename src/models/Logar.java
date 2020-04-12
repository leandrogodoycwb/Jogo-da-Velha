/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.Jogador;
import controllers.Jogar;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Luiz_
 */
public class Logar extends Jogador{
    
    public void Autenticar(controllers.Jogador jogador) throws SQLException, NoSuchAlgorithmException {
    
        
        
       if(jogador.getNome()!= null && jogador.getSenha() != null && !jogador.getNome().isEmpty() && !jogador.getSenha().isEmpty()){
           
            Conexao con = new Conexao();
            Jogar jogo = new Jogar();   
            
            MessageDigest senhaCriptografada=MessageDigest.getInstance("MD5");//criptografa a senha
            
            byte[] senhabytes = jogador.getSenha().getBytes();
            senhaCriptografada.update(senhabytes,0,senhabytes.length);
            BigInteger i = new BigInteger(1,senhaCriptografada.digest());
            String jujuba = String.format("%1$032X", i);
            Statement st = con.conexao.createStatement();
            
            ResultSet rs = st.executeQuery("Select * from jogador where nome_jogador = '" + jogador.getNome()+"'"
                                           + "and senha = '"+ jujuba +"'");
            
            while(rs.next()){
                String usuario = rs.getString("nome_jogador");
                String senha2 = rs.getString("senha");
                
                if((jogador.getNome() == null ? usuario == null : jogador.getNome().equals(usuario)) && (jogador.getSenha() == null ? senha2 == null : jujuba.equals(senha2))){
                    System.out.println("\nLogado com sucesso\n bem vindo " + usuario);
                    jogo.entrarJogo();
                } else {
                    System.out.println("Nome ou Senha incorretos!!");
                }
            }   
       } else {
           System.out.println("Preencha os dados com seu nome e senha de seu cadastro!!");
       }
    }
}