/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author lucas
 */
public class AnimacaoSpace {
    public Sprite sImg;
    public BufferedImage img;
    public String mundo;
    public int modo;
    public Texto descri1;
    public Texto descri2;
    public Texto descri3;
    public String texto1, texto2, texto3;
    
    public AnimacaoSpace(String mundo, int modo){
        try {
            if (modo==0)
                img = ImageIO.read(getClass().getResourceAsStream("/Controlador/Imagens/space.png"));
            else
                img = ImageIO.read(getClass().getResourceAsStream("/Controlador/Imagens/psi.png"));
        } catch (IOException ex) {
            Logger.getLogger(AnimacaoSpace.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.mundo = mundo;
        this.modo = modo;
        sImg = new Sprite(img, 0,0);
        Principal.GUI.remove(Principal.hud.t);
        Principal.GUI.add(sImg);
        animaDisco();
    }
    public void animaDisco(){
        Sprite ufo;
        if (modo==0)
            ufo = new Sprite(Principal.imagens.discoVoador, 730, 250);
        else
            ufo = new Sprite(Principal.imagens.portal, 730, 250);
        
        Principal.GUI.add(ufo);
        
        new Thread(){
            public void run(){
                for(int a=0; a<20; a++){
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AnimacaoSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ufo.x-=5;
                    Principal.GUI.repaint();
                }
                double c=Principal.aleatorio.nextInt(2)+1, d= Principal.aleatorio.nextInt(10);
                
                for (int ha=0; ha<3; ha++){
                    
                    int dirD = Principal.aleatorio.nextInt(2);

  
                    for(int a=0; a<15; a++){
                       try {
                           Thread.sleep(20);
                       } catch (InterruptedException ex) {
                           Logger.getLogger(AnimacaoSpace.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       ufo.x-=(int) d;

                       if (dirD==1)
                           ufo.y-=(int) c;
                       else
                           ufo.y+=(int) c;

                       Principal.GUI.repaint();
                       //c=Principal.aleatorio.nextInt(10);
                       //d= Principal.aleatorio.nextInt(5);
                        
                       
                       if (ufo.y<=10 && dirD==1)
                           dirD=0;                           
                       if (ufo.y>=530 && dirD!=1)
                           dirD=1;    
                       
                   }
             
                }
//                System
                while (true){
                    if (ufo.x>340)
                        ufo.x--;
                    else if (ufo.x<340)
                        ufo.x++;
                    if (ufo.y>240)
                        ufo.y--;
                    else if (ufo.y<240)
                        ufo.y++;
                     try {
                           Thread.sleep(1);
                       } catch (InterruptedException ex) {
                           Logger.getLogger(AnimacaoSpace.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    Principal.GUI.repaint();
                    if (ufo.x==340 && ufo.y == 240)
                        break;
                }
                while (true){
                    if (ufo.x>-160)
                        ufo.x-=6;
                    else if (ufo.x<-160)
                        ufo.x+=6;
                     try {
                           Thread.sleep(1);
                       } catch (InterruptedException ex) {
                           Logger.getLogger(AnimacaoSpace.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    Principal.GUI.repaint();
                    if (ufo.x<=-160)
                        break;
                }
                try {
                           Thread.sleep(1500);
                       } catch (InterruptedException ex) {
                           Logger.getLogger(AnimacaoSpace.class.getName()).log(Level.SEVERE, null, ex);
                }
                switch(mundo){
                    case "Vênus":{ 
                        Principal.mundo = new Mundos("venus");
                        Principal.person.visitouVenus = true;
                        break;
                    }
                    case "Polux":{
                        Principal.mundo = new Mundos("polux");
                        Principal.person.visitouPolux = true;
                        break;
                    }
                    case "Terra": Principal.mundo = new Mundos("terra"); break;
                }
                Texto titulo;
                if (modo==0)
                    titulo = new Texto(mundo, new Font("Arial", Font.ITALIC , 60), Color.WHITE,295,100);
                else
                    titulo = new Texto(mundo, new Font("Arial", Font.ITALIC , 60), Color.BLACK,295,100);
                
                if (modo==0){
                    descri1 = new Texto("", new Font("Arial", Font.ITALIC , 30), Color.WHITE,120,250);
                    descri2 = new Texto("", new Font("Arial", Font.ITALIC , 30), Color.WHITE,120,300);
                    descri3 = new Texto("", new Font("Arial", Font.ITALIC , 30), Color.WHITE,120,350);
                }
                else{
                    descri1 = new Texto("", new Font("Arial", Font.ITALIC , 30), Color.BLACK,120,250);
                    descri2 = new Texto("", new Font("Arial", Font.ITALIC , 30), Color.BLACK,120,300);
                    descri3 = new Texto("", new Font("Arial", Font.ITALIC , 30), Color.BLACK,120,350);
                }
                Principal.GUI.add(titulo);
                Principal.GUI.add(descri1);
                Principal.GUI.add(descri2);
                Principal.GUI.add(descri3);
                letreiro();
                
            }            
        }.start();
    }
    public void letreiro(){
       texto1="";
       texto2="";
       texto3="";
        switch(mundo){
            case "Vênus":{ 
               texto1 = "Mundo de ideais marxistas que";
               texto2 = "tem como lider o chefe supremo 9 dedos";
               texto3 = "Seu maior inimigo é o anarcocapitalista Polux";
               break;
            }
            case "Polux":{
                texto1 = "Mundo anarcocapitalista";
                texto2 = "tem como lider o chefe supremo BolsoSarro";
                texto3 = "Seu maior inimigo é o comunista Vênus";
               break;
            }
            case "Terra": {
                texto1 = "Mundo centrista";
                texto2 = "não tem um líder e ideais definidos,";
                texto3 = "Seu ponto fraco é não poder roubar seu povo";
               break;
            } 
        }

        new Thread(){
            public void run(){
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
                }
                for(int a = 0; a<texto1.length(); a++){
                    descri1.txt = (descri1.txt + texto1.charAt(a));
                    Principal.GUI.repaint();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                for(int a = 0; a<texto2.length(); a++){
                    descri2.txt = (descri2.txt + texto2.charAt(a));
                    Principal.GUI.repaint();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                for(int a = 0; a<texto3.length(); a++){
                    descri3.txt = (descri3.txt + texto3.charAt(a));
                    Principal.GUI.repaint();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                 try {
                        Thread.sleep(5500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                Principal.retoma();
                Principal.restart();
            }
        }.start();
    }
    
}
