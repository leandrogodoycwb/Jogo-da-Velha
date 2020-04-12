/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Scanner;

/**
 *
 * @author Luiz_
 */
public class Jogar {
    
    public void entrarJogo(){
       
        Scanner ler = new  Scanner(System.in);
        Jogo jogar = new Jogo();
        String posicao;
        int valida = 0, jogada = 0;
        
        do{
             System.out.println(" quer jogar contra player ou contra pc?");
                System.out.println("Player (1)");
                System.out.println("PC (2)");
                valida = ler.nextInt();

        }while(valida != 1 && valida != 2);

    if(valida == 1){     
        
         System.out.println("jogo da veiaaaa");
            jogar.Mostrar();
      
            while(true){
            do{
                System.out.println("Jogador 1 insira posição: ");
                posicao = ler.next();
                while(!jogar.Valida(posicao)){
                    System.out.println("Jogada inválida");
                     System.out.println("Jogador 1 insira posição: ");
                   posicao = ler.next();
                   valida = 0;
                }
                jogar.Jogada(posicao, "X");
                valida = 1;
                
            }while(valida == 0); //fim jog 1
            
            jogada++;
            valida = 0;
            jogar.Mostrar();
            
            if(!jogar.Ganhou(jogada).equals("null")){
                break;
            }
               
            do{
                System.out.println("Jogador 2 insira posição: ");
                posicao = ler.next();
                while(!jogar.Valida(posicao)){
                System.out.println("Jogada inválida");
                 System.out.println("Jogador 2 insira posição: ");
                   posicao = ler.next();
                   valida = 0;
                }
                jogar.Jogada(posicao, "O");
                valida = 1;
                
            }while(valida == 0); //fim jog 1
            
            jogada++;
            valida = 0;
            jogar.Mostrar();
                
            if(!jogar.Ganhou(jogada).equals("null")){
                break;
            }
               
        }  
        System.out.println("O " + jogar.Ganhou(jogada) + " Venceu !");
            
        
        
            }else {
            System.out.println("jogo da veiaaaa");
            jogar.Mostrar();
          
            while(true){
                       
            do{
                System.out.println("Jogador 1 insira posição: ");
                posicao = ler.next();
                while(!jogar.Valida(posicao)){
                    System.out.println("Jogada inválida");
                     System.out.println("Jogador 1 insira posição: ");
                   posicao = ler.next();
                   valida = 0;
                }
                jogar.Jogada(posicao, "X");
                valida = 1;
                
            }while(valida == 0); //fim jog 1
            
            jogada++;
            valida = 0;
            jogar.Mostrar();
            
            if(!jogar.Ganhou(jogada).equals("null")){
                break;
            }
               
            do{
                posicao =  Integer.toString((int)(Math.random() * 10));
                while(!jogar.Valida(posicao)){
                  posicao =  Integer.toString((int)(Math.random() * 10));
                   valida = 0;
                }
                jogar.Jogada(posicao, "O");
                valida = 1;
                
            }while(valida == 0); //fim jog 1
                System.out.println("A máquina jogou: \n");
            jogada++;
            valida = 0;
            jogar.Mostrar();
                
            if(!jogar.Ganhou(jogada).equals("null")){
                break;
            }
               
        }  
        System.out.println("O " + jogar.Ganhou(jogada) + " Venceu !");
           
            }

    }
}
