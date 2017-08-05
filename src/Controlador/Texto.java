/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;

/**
 *
 * @author lucas
 */
public class Texto {
      
    public String txt;
    public Font fonte; //new Font(“Serif”, Font.BOLD + Font.ITALIC, 15) 
    public Color cor;
    public int x;
    public int y;

    public Texto(String txt,  Font fonte, Color cor, int x, int y) {
        this.txt = txt;
        this.x = x;
        this.y = y;
        this.fonte = fonte;
        this.cor = cor;
    }
    
}
