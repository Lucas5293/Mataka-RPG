/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import Cenario.ImagensCarregadas;


/**
 *
 * @author lucas
 */
public class Apresentacao implements KeyListener{
    public BufferedImage img;
    public Controlador.Sprite sImg;
    public boolean terminou = false;
    public Texto t;
    public boolean cortou =false;
    public Musica musica;
    public ImagensCarregadas imagens;
    
    public Apresentacao(){
        System.setProperty("swing.aatext", "true" );
        System.setProperty("awt.useSystemAAFontSettings","on");
        t = new Texto("", new Font("Arial", Font.ITALIC , 30), Color.darkGray,135,510);
        
        musica = new Musica(getClass().getResourceAsStream("/Controlador/Musicas/apresentacao.mp3"));
        
        new Thread(){
            public void run(){
               musica.play();
            }
        }.start();
        
        imagens = new ImagensCarregadas();
        
        new Thread(){
            public void run(){
                try {
                    imagens.CarregarCenario();
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
        
        new Thread(){
            public void run(){
                if (cortou==false){
                    drawSprite(loadSprite("carlos.png"), 0 ,0);
                    drawSprite(loadSprite("team.png"), 45 ,80);
                }
                try {
                    Thread.sleep(7000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (cortou==false)
                    drawSprite(loadSprite("apresenta.png") , 45 ,80);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (cortou==false){
                    drawSprite(loadSprite("carlos.png"), 0 ,0);
                    drawSprite(loadSprite("logo.png") , 125,  136);
                
                    Principal.GUI.add(t);
                    letreiro();
                }
                try {
                    Thread.sleep(12000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (cortou==false){
                    while (imagens.carregou == false){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        
                    if (musica.executando==1){
                        musica.executando=0;
                        musica.player.close();
                    }
                    Principal.imagens = imagens;
                    Principal.iniciarJogo();
                }
            }
        }.start();   
    }
    public void letreiro(){
        String texto = "Entre zumbis, espaçonaves e vampiros";

        new Thread(){
            public void run(){
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
                }
                for(int a = 0; a<texto.length(); a++){
                    t.txt = (t.txt + texto.charAt(a));
                    Principal.GUI.repaint();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }               
            }
        }.start();
    }
    
    public void drawSprite(BufferedImage img, int x, int y){
        sImg = new Controlador.Sprite(img,x, y);
        Principal.GUI.add(sImg);
    }
    public BufferedImage loadSprite(String sprite){
       try {
           return ImageIO.read(getClass().getResourceAsStream("/Controlador/Imagens/"+sprite));
       } catch (IOException e) {
           System.out.println(e);
       }
       return null;
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER && imagens.carregou==true){
            cortou = true;
            if (musica.executando==1){
                musica.executando=0;
                musica.player.close();
            }
            Principal.imagens = imagens;
            Principal.iniciarJogo();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
