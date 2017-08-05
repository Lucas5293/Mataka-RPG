/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculos;

import Controlador.Principal;
import java.awt.image.BufferedImage;

/**
 *
 * @author Rafael
 */
public class Veiculos 
{
    public Controlador.Sprite sImg;
    public BufferedImage img, imgEsq, imgDir;
    public BufferedImage imgC;
    
    public void draw(){
        sImg = new Controlador.Sprite(img, 0, 0);
        Principal.GUI.add(sImg);
    }
}
