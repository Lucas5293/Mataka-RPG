/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

import Controlador.AnimacaoSpace;
import Controlador.EscolheMundo;
import Controlador.Mundos;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import Controlador.Principal;
import Controlador.TransicaoSala;
import armas.Arma;
import consumiveis.Consumiveis;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import veiculos.Veiculos;

/**
 *
 * @author lucas
 */
public class ClassesJogaveis implements KeyListener{
    public String name;
    public int hp;
    public double cp; 
    public int xp=0;
    public int level=1;
    public int invencivel=0;
    public String tipo;
    public ArrayList<Consumiveis> itens = new ArrayList<>();
    public armas.Arma arma = null;
    public Veiculos veiculo = null;
    
    public float velocidade = 8;
    public char direcao = 'D';
    public boolean podeMovimentar = true;
    
    public String sprite;
    public BufferedImage img;
    public Controlador.Sprite sImg;
    public int x=50, y=100;
    
    public boolean visitouTerra = true;
    public boolean visitouVenus = false;
    public boolean visitouPolux = false;
    
    /*public void atacar(Inimigo inimigo){
        inimigo.hp -= cp;        
    }*/
    public void drawSprite(){
        sImg = new Controlador.Sprite(img, x ,y);
        Principal.GUI.add(sImg);
    }
    public void loadSprite(String sprite){
       try {
           img = ImageIO.read(getClass().getResourceAsStream("/Personagens/Imagens/"+sprite));
       } catch (IOException e) {
           System.out.println(e);
       }
    }
    
    public void monitorarColisao(){
         new Thread(){
            public void run(){
                while (true){
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ClassesJogaveis.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                   Principal.colisao.colidiuBorda();
                   
                   Arma a =  Principal.colisao.colidiuArma();
                   if (a!=null){
                       Principal.GUI.remove(a.sImg);
                       a.loadSprite(a.sprite);   
                       Principal.map.listArm.remove(a);
                       Principal.pega.mostrar(a);
                   }
                   
                   Consumiveis b =  Principal.colisao.colidiuItem();
                   if (b!=null && itens.size()<5){
                       Principal.GUI.remove(b.sImg);
                       b.loadSprite(b.sprite);
                       Principal.map.listConsu.remove(b);
                       Principal.pega.mostrar(b);   
                   }
                   
                   if (Principal.colisao.colidiuPoco()){
                       hp = getVidaMaxima();
                       Principal.GUI.remove(Principal.enfeites.poco.sImg);
                       Principal.enfeites.poco = null;
                       //javax.swing.JOptionPane.showMessageDialog(null,"HP restaurado para 100");
                       Controlador.Ph ph = new Controlador.Ph();
                       ph.animacao();
                   }
                   if (Principal.colisao.colidiuDiscoVoador()){
                       Principal.map.disco = null;
                       Principal.pausa();
                       EscolheMundo em = new EscolheMundo();
                       em.mostrar();
                   }
                   if (Principal.colisao.colidiuPortal()){
                       Principal.map.portal = null;
                       Principal.pausa();
                       EscolheMundo em = new EscolheMundo();
                       em.mostrarP();
                   }
                   if (Principal.colisao.colidiuVeiculo(0)){
                       Principal.GUI.remove(Principal.map.unicornio.sImg);
                       veiculo = Principal.map.unicornio;
                       Principal.map.unicornio = null;
                        if (direcao == 'E')
                            img = veiculo.imgEsq;
                        else if (direcao == 'D')
                            img = veiculo.imgDir;  
                        else if (direcao == 'C')
                            img = veiculo.imgC;  
                       else
                            img = veiculo.imgDir;
                       
                       sImg.img = img;
                       Principal.GUI.repaint();
                       velocidade = 11;
                       new Controlador.Mensagem(Principal.imagens.msgUni);
                   }
                   if (Principal.colisao.colidiuVeiculo(1)){
                       Principal.GUI.remove(Principal.map.moto.sImg);
                       veiculo = Principal.map.moto;
                       Principal.map.moto = null;
                        
                        if (direcao == 'E')
                            img = veiculo.imgEsq;
                        else if (direcao == 'D')
                            img = veiculo.imgDir;  
                        else if (direcao == 'C')
                            img = veiculo.imgC;  
                       else
                            img = veiculo.imgDir;
                       
                       sImg.img = img;
                       Principal.GUI.repaint();
                       velocidade = 14;
                       new Controlador.Mensagem(Principal.imagens.msgMoto);
                   }
                   
                }
                
            }
        }.start();
     }
        
    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
        TransicaoSala transi = new TransicaoSala();
        char key = e.getKeyChar();
        key = Character.toLowerCase(key);
        switch (key) {
            case 'a':{
               if (Principal.colisao.colidiEsq()==false && podeMovimentar){
                    sImg.x-= (velocidade);
                    if (direcao!='E'){
                        if (veiculo==null)
                            loadSprite(sprite+"Esq.png");
                        else
                            img = veiculo.imgEsq;
                        sImg.img = img;
                        direcao = 'E';
                    }
                    
               }
                break;
            }
            case 'd':{
                if (Principal.colisao.colidiDir()==false && podeMovimentar){
                    sImg.x+= (velocidade);
                    if (direcao!='D'){
                        if (veiculo==null)
                            loadSprite(sprite+"Dir.png");
                        else
                            img = veiculo.imgDir;
                        sImg.img = img;
                        direcao = 'D';
                    }
               }
                break;
            }
            case 'w':
                if (Principal.colisao.colidiCima()==false && podeMovimentar){
                    sImg.y-= (velocidade);
                    if (direcao!='C'){
                        if (veiculo==null)
                            loadSprite(sprite+"Cima.png");
                         else
                            img = veiculo.imgC;
                        sImg.img = img;
                        direcao='C';
                    }
                }
                break;
            case 's':
                if (Principal.colisao.colidiBaixo()==false && podeMovimentar){
                    sImg.y+= (velocidade);
                    if (direcao == 'C'){
                        if (veiculo==null)
                            loadSprite(sprite+"Dir.png");                        
                        sImg.img = img;
                        direcao='B';
                    }
                        
                }
                break;
            case 'f':{
                veiculo=null;
                if (direcao == 'E')
                        loadSprite(sprite+"Esq.png"); 
                if (direcao == 'D')
                        loadSprite(sprite+"Dir.png");                        
                if (direcao == 'C')
                        loadSprite(sprite+"Cima.png"); 
                if (direcao == 'B')
                        loadSprite(sprite+"Baixo.png");                
                sImg.img = img;
                break;
            }               
            case 'n':{
                Principal.musica.executando=0;
                Principal.musica.player.close();
                Principal.playMusic();
            }
                
            default:
                break;
        }
        
        if (velocidade>6 && veiculo==null)
            velocidade -= 0.05;
        Principal.GUI.repaint();               
            
    }
    public int pegaVidaHud(){
        if (this.hp >0){
            int vidaX = this.hp * 100 ;
            int tam = (int) vidaX/getVidaMaxima();
        
            return tam;
        }
        else
            return 1;
    }
    
    public int getVidaMaxima(){
       switch(this.sprite){
           case "elfo":
               return 450;
           case "motumbo":
               return 100;
           case "marciano":
               return 200;
           case "vampiro":
               return 150;
           case "venusiano":
               return 200;
           case "zumbi":
               return 60;
           default:
               return 100;
       }
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        velocidade =8;
    }
    
}
