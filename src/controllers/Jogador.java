package controllers;

import models.Conexao;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jogador {
    private String nome;
    private String senha;
    private String conf_senha;
    private int senhaConvertida;
    
    public void setNome(String nome){
        this.nome = nome;
    }
          
    public String getNome() {
        return nome;
    }   
    
    public void setSenha(String senha) {
        this.senha = senha;
        this.senhaConvertida = senha.length();
        setSenhaConvertida(senhaConvertida);
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setConf_Senha(String conf_senha){
        this.conf_senha = conf_senha;
    }
    
    public String getConf_Senha() {
        return conf_senha;
    }
    
    public void setSenhaConvertida(int senhaConvertida){
        this.senhaConvertida = senhaConvertida;
    }
    
    public int getSenhaConvertida() {
        return senhaConvertida;
    }
    
    public void recebeDados() throws SQLException, NoSuchAlgorithmException{
        if(!this.getSenha().equals(this.getConf_Senha())) {//verifica se as variaveis senha1 e senha 2 sao iguais
            System.out.println("SENHAS DIFERENTES");
        }else if(this.getSenhaConvertida() <= 7){//verifica se a senha é menor ou igual que 7
            System.out.println("Sua senha deve conter mais que 7 digitos");
        }else{
            Conexao con = new Conexao();
            
            Statement st = con.conexao.createStatement();
            MessageDigest senhaCriptografada=MessageDigest.getInstance("MD5");//criptografa a senha
            senhaCriptografada.update(this.getSenha().getBytes(),0,this.getSenha().length());//criptografa a senha
            st.executeUpdate("insert into jogador "+// insere no banco
            "(nome_jogador,senha)" +
            " values ('" + this.getNome() + "', '" + senhaCriptografada + "')");
             st.executeQuery("Select * from jogador");//Select na tabela jogador
            ResultSet rs = st.getResultSet();
            //while(rs.next()) {
            //System.out.println(rs.getString("nome_jogador"));//mostra os dados da tabela jogador no console
            //}
        }
    }
}
