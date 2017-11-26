/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumiveis;

import Controlador.Principal;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Rafael
 */
public class Consumiveis 
{
    public boolean usavel;
    public int x;
    public int y;
    public String nome;
    public String descri;
    
    public String sprite;
    public String vazio="item.png";
    public BufferedImage img;
    public Controlador.Sprite sImg;
    
    public void efeito()
    {
          
    }
    public void drawSprite(){
        sImg = new Controlador.Sprite(img, x ,y);
        Principal.GUI.add(sImg);
    }
    public void loadSprite(String sprite){
       try {
           img = ImageIO.read(getClass().getResourceAsStream("/consumiveis/Imagens/"+sprite));
       } catch (IOException e) {
           System.out.println(e);
       }
    }
}
