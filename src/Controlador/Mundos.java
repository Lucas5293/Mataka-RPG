/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author lucas
 */
public class Mundos {
    public String nome;
    public BufferedImage background;
    
    public Mundos(String n){
        nome= n;
        
        switch(n){
            case "terra":
                loadSprite("terra.jpg");break;
            case "venus":
                loadSprite("venus.png");break;
            case "polux":
                loadSprite("polux.png");break;
        }
    }
    
    public void loadSprite(String sprite){
       try {
           background = ImageIO.read(getClass().getResourceAsStream("/Controlador/Imagens/"+sprite));
       } catch (IOException e) {
           System.out.println(e);
       }
    }
}
