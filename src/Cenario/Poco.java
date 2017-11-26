/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cenario;

import Controlador.Principal;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author lucas
 */
public class Poco {
    public BufferedImage img;
    public Controlador.Sprite sImg;
    public int x=0;
    public int y=0;
    
    public Poco(){
        sImg = new Controlador.Sprite(Principal.imagens.poco,x, y);
        Principal.GUI.add(sImg);
    }
    
}
