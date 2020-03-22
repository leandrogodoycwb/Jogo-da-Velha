package controllers;

import models.Conexao;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jogador {
    private String nome;
    private String senha1;
    private String senha2;
    private int senhaConvertida;
    
    public void setNome(String nome){
        this.nome = nome;
    }
          
    public String getNome() {
        return this.nome;
    }   
    
    public void setSenha1(String senha1) {
        this.senha1 = senha1;
    }
    
    public String getSenha1() {
        return this.senha1;
    }
    
    public void setSenha2(String senha2){
        this.senha2 = senha2;
    }
    
    public String getSenha2() {
        return this.senha2;
    }
    
    public void setSenhaConvertida(int senhaConvertida){
        this.senhaConvertida = senhaConvertida;
    }
    
    public int getSenhaConvertida() {
        return this.senhaConvertida;
    }
    
    public void recebeDados() throws SQLException, NoSuchAlgorithmException{
        if(!this.getSenha1().equals(this.getSenha2())) {//verifica se as variaveis senha1 e senha 2 sao iguais
            System.out.println("SENHAS DIFERENTES");
        }else if(this.getSenhaConvertida() <= 7){//verifica se a senha é menor ou igual que 7
            System.out.println("Sua senha deve conter mais que 7 digitos");
        }else{
            Conexao con = new Conexao();
            
            Statement st = con.conexao.createStatement();
            MessageDigest senhaCriptografada=MessageDigest.getInstance("MD5");//criptografa a senha
            senhaCriptografada.update(this.getSenha1().getBytes(),0,this.getSenha1().length());//criptografa a senha
            st.executeUpdate("insert into jogador "+// insere no banco
            "(nome_jogador,senha)" +
            " values ('" + this.getNome() + "', '" + senhaCriptografada + "')");
             st.executeQuery("Select * from jogador");//Select na tabela jogador
            ResultSet rs = st.getResultSet();
            while(rs.next()) {
            System.out.println(rs.getString("nome_jogador"));//mostra os dados da tabela jogador no console
            }
        }
    }
}
