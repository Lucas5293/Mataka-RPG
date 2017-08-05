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
public class Arvore {
    public String sprite;
    public BufferedImage img;
    public Controlador.Sprite sImg;
    public int x=0;
    public int y=0;
    
    public Arvore(){
        Random aleatorio = new Random();
        String m = Principal.mundo.nome;
        switch(aleatorio.nextInt(4)){
            case 0: {
                if (m.equals("venus"))
                    img = Principal.imagens.arvore1V;
                else if (m.equals("polux"))
                    img = Principal.imagens.arvore1P;
                else
                    img = Principal.imagens.arvore1;
                break;
            }
            case 1: {
                if (m.equals("venus"))
                    img = Principal.imagens.arvore2V;
                else
                    img = Principal.imagens.arvore2;
                break;
            }
            case 2: {
                if (m.equals("venus"))
                    img = Principal.imagens.arvore3V;
                else
                    img = Principal.imagens.arvore3;
                break;
            }
            case 3: 
                if (m.equals("venus"))
                    img = Principal.imagens.arvore4V;
                else if (m.equals("polux"))
                    img = Principal.imagens.arvore4P;
                else
                    img = Principal.imagens.arvore4;
                break;
        }
        drawSprite();
    }
    public void drawSprite(){
        sImg = new Controlador.Sprite(img,x, y);
        Principal.GUI.add(sImg);
    }
    
}
