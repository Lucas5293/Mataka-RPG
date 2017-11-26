/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inimigos;

import Controlador.Principal;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Math.sqrt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author lucas
 */
public class Inimigos {
    public double hp;
    public double cp;
    
    public Inimigos eu = this;
    public String sprite;
    public BufferedImage img;
    public Controlador.Sprite sImg;
    public boolean ativo =true;
    public boolean podeMovimentar=true;
    public String lado="d";
    
    public Inimigos(){

    }
    
    public void atacar(){
        new Thread(){
            public void run(){
                while (ativo){
                    try {
                        Thread.sleep(15);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Inimigos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    int x1 = Principal.person.sImg.x;
                    int y1 = Principal.person.sImg.y;
                    int x2 = sImg.x;
                    int y2 = sImg.y;
                    double distancia=sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));

                    if (distancia<=200 && distancia>50  && podeMovimentar){
                        if (x1>x2){
                            sImg.x+=2.5;
                            try {
                                if (lado!="d")
                                    sImg.img = ImageIO.read(getClass().getResourceAsStream("/Inimigos/Imagens/"+sprite+"Dir.png"));
                                lado="d";
                            } catch (IOException ex) {
                                Logger.getLogger(Inimigos.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else if (x1<x2){
                            sImg.x-=2.5;
                            try {
                                if (lado!="e")
                                    sImg.img = ImageIO.read(getClass().getResourceAsStream("/Inimigos/Imagens/"+sprite+"Esq.png"));
                                lado="e";
                            } catch (IOException ex) {
                                Logger.getLogger(Inimigos.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else if (y1>y2)
                            sImg.y+=2.5;
                        else if (y1<y2)
                            sImg.y-=2.5;
                        Principal.GUI.repaint();
                    }
                    else if (distancia<=50 && podeMovimentar){
                        Principal.bt.mostrar(eu);
                        Principal.GUI.remove(sImg);
                        ativo=false;
                    }
                }
            }
        }.start();
    }
    public void drawSprite(){
        sImg = new Controlador.Sprite(img, 50, 50);
        Principal.GUI.add(sImg);
    }
    public void loadSprite(String sprite){
       try {
           img = ImageIO.read(getClass().getResourceAsStream("/Inimigos/Imagens/"+sprite+"Dir.png"));
       } catch (IOException e) {
           System.out.println(e);
       }
    }
    
}
