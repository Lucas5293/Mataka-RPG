/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author lucas
 */
public class Ph {
    public BufferedImage imgRotate[], imgDes[], imgApr[], img1, img2, img3, hp;
    public Controlador.Sprite sImg;
    public int x=250;
    public int y=150;
    
    public Ph(){
        img1 = loadSprite("ph1.png");
        hp = loadSprite("hp.png");
        
        imgRotate = new BufferedImage[30];
        //imgDes = new BufferedImage[11];
        //imgApr = new BufferedImage[18];
        int x=0;
        for(int a=0; a<30; a++){
            imgRotate[a]= img1.getSubimage(x, 0, 252, 252);
            x+=252;
        }
        x=0;
        /*for(int a=0; a<11; a++){
            imgDes[a]= img2.getSubimage(x, 0, 252, 252);
            x+=252;
        }
        x=0;
        for(int a=0; a<18; a++){
            imgApr[a]= img3.getSubimage(x, 0, 252, 252);
            x+=252;
        }*/
        
    }
    public void drawSprite(BufferedImage img){
        Principal.GUI.remove(sImg);
        sImg = new Sprite(img, 274,174);        
        Principal.GUI.add(sImg);
    }
    public BufferedImage loadSprite(String sprite){
       try {
           return ImageIO.read(getClass().getResourceAsStream("/Controlador/Imagens/"+sprite));
       } catch (IOException e) {
           System.out.println(e);
           return null;
       }
    }
    public void animacao(){
        Principal.pausa();
        drawSprite(imgRotate[0]);
        try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ph.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int c = 0 ;
        while (c<3){
            for(int a=1; a<30; a++){
                drawSprite(imgRotate[a]);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ph.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            c++;
        }
        /*for(int a=0; a<11; a++){
            drawSprite(imgDes[a]);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ph.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          for(int a=0; a<18; a++){
            drawSprite(imgApr[a]);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ph.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        drawSprite(hp);
        try {
                Thread.sleep(2500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ph.class.getName()).log(Level.SEVERE, null, ex);
        }
        Principal.GUI.remove(sImg);
        Principal.retoma();
    }
   
}