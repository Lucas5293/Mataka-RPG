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
public class Barraca{
    public String sprite;
    public BufferedImage img;
    public Controlador.Sprite sImg;
    
    public Barraca(){
        sImg = new Controlador.Sprite(Principal.imagens.barraca, 25, 50);
        Principal.GUI.add(sImg);
    }

}
