/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armas;

import Controlador.Principal;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Rafael
 */
public class Arma 
{
    public String nome; /* Identificar a arma */
    public double dano; /* O valor de cp a ser adicionado ao personagem */
    boolean ativo; /*se o personagem pode pegar ou não*/
    public int x;
    public int y;
    public String descri;
    
    public String sprite;
    public String vazio = "item.png";
    public BufferedImage img;
    public Controlador.Sprite sImg;
    
    public void test() /* testa arma para ativa-la (caso ela precise), conforme descrição do pdf */
    {
        
    }
    
    public void habilidade() /* adiciona o cp ou qualquer outro efeito */
    {
        
    }
    
    public void drawSprite(){
        sImg = new Controlador.Sprite(img, x ,y);
        Principal.GUI.add(sImg);
    }
    public void loadSprite(String sprite){
       try {
           img = ImageIO.read(getClass().getResourceAsStream("/armas/Imagens/"+sprite));
       } catch (IOException e) {
           System.out.println(e);
       }
    }
    
}
