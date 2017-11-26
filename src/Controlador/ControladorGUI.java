/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author lucas
 */
public class ControladorGUI extends Component {
    
    ArrayList<Sprite> spr = new ArrayList<>();
    ArrayList<Texto> txt = new ArrayList<>();
    BufferedImage vazio;
    public boolean transicao = false;
    
     public ControladorGUI(){
       try {
           BufferedImage vazio = ImageIO.read(new File("D:\\Projetos\\RPG\\src\\Controlador\\Imagens\\vazio.png"));
       } catch (IOException e) {
           System.out.println(e);
       }
     }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();  
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias!
        RenderingHints.VALUE_ANTIALIAS_ON);
        
        try{
            for(Sprite s: spr){
                g2d.drawImage(s.img, s.x, s.y, null);  
            }
            for (Texto t: txt){
                g2d.setColor(t.cor);
                g2d.setFont(t.fonte);
                g2d.drawString(t.txt,t.x,t.y);
            }
            if (Principal.colisao.transi.acabou==false)
                 g2d.drawImage(Principal.colisao.transi.tela.img, Principal.colisao.transi.tela.x, Principal.colisao.transi.tela.y, null); 
            
        }
        catch(Exception e){
            //Gambiarra, a gente vê por aqui
        }
        

    }
    
    public void add(Sprite s){
        spr.add(s);
        repaint();
    }
     public void add(Texto t){
        txt.add(t);
        repaint();
    }
    public void remove(Sprite s){
        spr.remove(s);
        repaint();            
    }
    
    public void remove(Texto s){
        txt.remove(s);
        repaint();            
    }
    
    /*@Override
    public Dimension getPreferredSize() {
        return new Dimension(100,100);
    }*/
    
}
