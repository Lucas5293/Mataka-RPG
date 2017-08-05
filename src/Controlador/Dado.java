/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author lucas
 */
public class Dado {
    public BufferedImage img1, img2, img3, img4, img5, imgViveu, imgMorreu;
    public Controlador.Sprite sImg;
    public int x=250;
    public int y=150;
    
    public Dado(){
        
        img1 = loadSprite("dado1.png");
        img2 = loadSprite("dado2.png");
        img3 = loadSprite("dado3.png");
        img4 = loadSprite("dado4.png");
        img5 = loadSprite("dado5.png");
        imgMorreu = loadSprite("dadoMorreu.png");
        imgViveu = loadSprite("dadoViveu.png");

        drawSprite();
        
    }
    public void drawSprite(){
        sImg = new Controlador.Sprite(img1,x, y);
        Principal.GUI.add(sImg);
    }
    public BufferedImage loadSprite(String sprite){
       try {
           return ImageIO.read(getClass().getResourceAsStream("/Controlador/Imagens/"+sprite));
       } catch (IOException e) {
           System.out.println(e);
           return null;
       }
    }
    public void animacao() throws InterruptedException{
        Musica musica = new Musica(getClass().getResourceAsStream("/Controlador/Musicas/dado.mp3"));
        
        new Thread(){
            public void run(){
               musica.play();
            }
        }.start();
        
        for (int a=0 ; a<14; a++){
            sImg.img = img2;
            Principal.GUI.repaint();

            Thread.sleep(17);
            sImg.img = img3;
            Principal.GUI.repaint();

            Thread.sleep(17);
            sImg.img = img4;
            Principal.GUI.repaint();

            Thread.sleep(17);
            sImg.img = img5;
            Principal.GUI.repaint();

             Thread.sleep(17);
            sImg.img = img1;
            Principal.GUI.repaint();
            Thread.sleep(17);
        }
        
        Texto numero;
        Random aleatorio = new Random();
        if (aleatorio.nextInt(7)==1)
        {
            sImg.img = imgMorreu;
            Principal.GUI.repaint();
            Thread.sleep(4000);
            /*String comando = "java -jar " + new File("").getAbsolutePath() + "\\jarPrincipalDaAplicacao.jar";
            try {
                Process Processo = Runtime.getRuntime().exec(comando);
            } catch ( IOException MensagemdeErro ) {
                System.out.print(MensagemdeErro);
            }*/
            System.exit(0);   
        }
        else
        {           
            sImg.img = imgViveu;
            Principal.person.hp=1;
            
        }
        
        Principal.GUI.repaint();        
        Thread.sleep(4000);
        Principal.GUI.remove(sImg);
        musica.player.close();
        
        
    }
}
