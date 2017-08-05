/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import armas.Arma;
import consumiveis.Consumiveis;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author lucas
 */
public class Hud implements MouseListener{
    public Sprite sImg, spriteArma, spriteVida, spriteXp, itens[], pausa;
    public BufferedImage img, barras;
    public Texto t;
    
    public Hud(){
        img = loadSprite("hud.png");
        barras = loadSprite("barras.png");
        itens = new Sprite[5];
    }
            
     public void drawSprite(){
        sImg = new Sprite(img, 0,0);        
        Principal.GUI.add(sImg);
        if (Principal.person.arma!=null)
            drawArma(Principal.person.arma);
        pausa = new Sprite(Principal.imagens.pausa, 768, 0);
        drawBarras();
        drawLevel();
        drawItens();
        Principal.GUI.add(pausa);
    }
     public void drawArma(Arma a){
         Principal.GUI.remove(spriteArma);
         spriteArma =  new Sprite(a.img, 19,62);    
         Principal.GUI.add(spriteArma);
     }
     public void drawBarras(){
         
         int vida = Principal.person.pegaVidaHud();
         int xp = Principal.person.xp;

         
         int tam=1;
         
         if (vida>1){
            int vidaX = vida*74;
            tam = (int) vidaX/100;
         }
         
         int tam2=1;
         if (xp>1){
            int xpX = xp*68;
            tam2 = (int) xpX/100;
         }
         BufferedImage imgVida = barras.getSubimage(0, 0, tam, 7);
         BufferedImage imgXP = barras.getSubimage(0, 12, tam2, 7);
         
         Principal.GUI.remove(spriteVida);
         Principal.GUI.remove(spriteXp);
         
         spriteVida =  new Sprite(imgVida, 58,20);    
         spriteXp =  new Sprite(imgXP, 57,32);  
         
         Principal.GUI.add(spriteVida);
         Principal.GUI.add(spriteXp);
         
     }
     public void drawItens(){
         for (Sprite s: itens)
             Principal.GUI.remove(s);
         int cc= 0;
         int y =111;
         for (Consumiveis c: Principal.person.itens){
             itens[cc] = new Sprite(c.img,15, y);
             Principal.GUI.add(itens[cc]);
             //y+=10;
             cc++;
         }
     }
     public void drawLevel(){
         Principal.GUI.remove(t);
         if (String.valueOf(Principal.person.level).length()>=2)
            t = new Texto(String.valueOf(Principal.person.level), new Font("Arial", Font.ITALIC , 30), Color.YELLOW,13,38);
        else
             t = new Texto(String.valueOf(Principal.person.level), new Font("Arial", Font.ITALIC , 30), Color.YELLOW,23,38);
         Principal.GUI.add(t);
     }
     public void apagar(){
         Principal.GUI.remove(sImg);
         Principal.GUI.remove(spriteArma);
         Principal.GUI.remove(spriteVida);
         Principal.GUI.remove(spriteXp);
         for(Sprite s: itens){
            Principal.GUI.remove(s);
         }
         Principal.GUI.remove(t);
         Principal.GUI.remove(pausa);
     }
    public BufferedImage loadSprite(String g){
       try {
           return ImageIO.read(getClass().getResourceAsStream("/Controlador/Imagens/"+g));
       } catch (IOException e) {
           System.out.println(e);
           return null;
       }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getX()>=768 && e.getX()<=800 && e.getY()>=0 && e.getY()<=32){
            if (Principal.person.podeMovimentar==true){
                Principal.pausa();
                new Pausa();
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
