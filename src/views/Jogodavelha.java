package views;

import controllers.Jogador;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;
import static javafx.application.Platform.exit;
import models.Logar;

public class Jogodavelha {
    
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
        
        Jogador jogador = new Jogador();//instancia um objeto jogador
        Scanner nome = new Scanner(System.in);//instancia um objeto escolha
        Scanner escolha = new Scanner(System.in);//instancia um objeto escolha
        Scanner senha = new Scanner(System.in);//instacia um objeto senha
        Scanner conf_senha = new Scanner(System.in);//instancia um objeto conf_senha
        Logar login = new Logar();
        
        
        int x = 0;
        while(x != 3){
            System.out.println("\n");
            System.out.println("JOGO DA VELHA");
            System.out.println("Cadastrar ( 1 )");
            System.out.println("Jogar ( 2 )");
            System.out.println("Sair ( 3 )");
            x = escolha.nextInt();
            
            switch(x) {
                case 1:
                     System.out.println("Digite seu nome: ");
                     jogador.setNome(nome.nextLine());//joga o nome pra dentro do metodo SETNOME
                     System.out.println("Digite sua senha: ");
                     jogador.setSenha(senha.nextLine());//joga a senha pra dentro do metodo SETSENHA1
                     System.out.println("Confirme sua senha: ");
                     jogador.setConf_Senha(conf_senha.nextLine());//joga a senha pra dentro do metoddo SETSENHA2
                     jogador.recebeDados();
                    break;
                    
                case 2:
                     System.out.println("Tela de Login\n");
                     System.out.println("Nome: ");
                     login.setNome(nome.nextLine());
                     System.out.println("Senha: ");
                     login.setSenha(senha.nextLine());
                     login.Autenticar();
                    break;
                    
                case 3:
                        exit();
                    break;
                    
                default: 
                    System.out.println("Comando Inválido!!");
            }
        }
    }
}        