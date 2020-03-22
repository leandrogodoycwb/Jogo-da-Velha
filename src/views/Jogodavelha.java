package views;

import controllers.Jogador;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

public class Jogodavelha {
    
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
        String nome;
        String senha1;
        String senha2;
        int senhaConvertida;
        
        Jogador jogador = new Jogador();//instancia um objeto jogador
        Scanner escolha = new Scanner(System.in);//instancia um objeto escolha
        Scanner senha = new Scanner(System.in);//instacia um objeto senha
        Scanner conf_senha = new Scanner(System.in);//instancia um objeto senha2 
       
        System.out.println("Digite seu nome: ");
        nome = escolha.nextLine();
        jogador.setNome(nome);//joga o nome pra dentro do metodo SETNOME
        System.out.println("Digite sua senha: ");
        senha1 = senha.nextLine();
        jogador.setSenha1(senha1);//joga a senha pra dentro do metodo SETSENHA1
        System.out.println("Confirme sua senha: ");
        senha2 = conf_senha.nextLine();
        jogador.setSenha2(senha2);//joga a senha pra dentro do metoddo SETSENHA2
        senhaConvertida = senha1.length();//conta quantos caracteres tem na senha para ver se é menor que 7
        jogador.setSenhaConvertida(senhaConvertida);
        jogador.recebeDados();
        
    }
}        