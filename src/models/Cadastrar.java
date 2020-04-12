/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.Jogador;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Luiz_
 */
public class Cadastrar extends Jogador {
    
    public void recebeDados(controllers.Jogador jogador) throws SQLException, NoSuchAlgorithmException{
        
        if(!jogador.getSenha().equals(jogador.getConf_Senha())) {
            //verifica se as variaveis senha1 e senha 2 sao iguais
            System.out.println("SENHAS DIFERENTES");
        }else if(jogador.getSenhaConvertida() <= 5){//verifica se a senha é menor ou igual que 7
            System.out.println("Sua senha deve conter mais que 7 digitos");
        }else{
            Conexao con = new Conexao();
            
            Statement st = con.conexao.createStatement();
            MessageDigest senhaCriptografada=MessageDigest.getInstance("MD5");//criptografa a senha
            
            byte[] senhabytes = jogador.getSenha().getBytes();
            senhaCriptografada.update(senhabytes,0,senhabytes.length);
            BigInteger i = new BigInteger(1,senhaCriptografada.digest());
            String jujuba = String.format("%1$032X", i);
            
            st.executeUpdate("insert into jogador "+// insere no banco
                    "(nome_jogador,senha)" +
                    " values ('" + jogador.getNome() + "', '" + jujuba + "')");
            System.out.println("Cadastro realizado com sucesso");
            Logar entrar = new Logar();
            entrar.Autenticar(jogador);
            //st.executeQuery("Select * from jogador");//Select na tabela jogador
            //ResultSet rs = st.getResultSet();
            //while(rs.next()) {
            //System.out.println(rs.getString("nome_jogador"));//mostra os dados da tabela jogador no console
            //}
        }
    }
}