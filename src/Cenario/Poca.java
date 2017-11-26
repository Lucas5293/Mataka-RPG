/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cenario;

import Controlador.Principal;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author lucas
 */
public class Poca {
    public String sprite;
    public BufferedImage img;
    public Controlador.Sprite sImg;
    public int x=0;
    public int y=0;
    
    public Poca(){
        Random aleatorio = new Random();

        switch(aleatorio.nextInt(4)){
            case 0: 
                loadSprite("poca1.png");
                break;
            case 1: 
                loadSprite("poca2.png");
                break;
            case 2: 
                loadSprite("poca3.png");
                break;
            case 3: 
                loadSprite("poca4.png");
                break;
        }
        drawSprite();
    }
    public void drawSprite(){
        sImg = new Controlador.Sprite(img,x, y);
        Principal.GUI.add(sImg);
    }
    public void loadSprite(String sprite){
       try {
           img = ImageIO.read(getClass().getResourceAsStream("/Cenario/Imagens/"+sprite));
       } catch (IOException e) {
           System.out.println(e);
       }
    }
    
}
