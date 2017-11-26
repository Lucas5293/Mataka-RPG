/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class TransicaoSala {
    public boolean acabou=false;
    public Sprite tela;
    
    public void vai(String lado){
         Robot robot;
        try {
            Principal.hud.apagar();
            robot = new Robot();
            BufferedImage print = robot.createScreenCapture(new // Captura a tela na àrea definida pelo retângulo
            Rectangle(Principal.f.getX(), Principal.f.getY(), (int) 800 , (int) 600)); // aqui vc configura as posições xy e o tam da área que quer capturar
            tela = new Sprite(print,0,0);
            Principal.GUI.add(tela);
            
            acabou=false;
            new Thread(){
                public void run(){
                    switch(lado){
                        case "E":{
                            while(tela.x+800>0){
                                try {
                                    Thread.sleep(1);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(TransicaoSala.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                tela.x-=5;
                                Principal.GUI.repaint();
                            }
                            break;
                        }
                        case "D":{
                            while(tela.x<800){
                                try {
                                    Thread.sleep(1);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(TransicaoSala.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                tela.x+=5;
                                Principal.GUI.repaint();
                            }
                            break;
                        }
                        case "C":{
                            while(tela.y+800>0){
                                try {
                                    Thread.sleep(1);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(TransicaoSala.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                tela.y-=5;
                                Principal.GUI.repaint();
                            }
                            break;
                        }
                        case "B":{
                            while(tela.y<600){
                                try {
                                    Thread.sleep(1);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(TransicaoSala.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                tela.y+=5;
                                Principal.GUI.repaint();
                            }
                            break;
                        }  
                    }
                    Principal.colisao.transi.acabou=true;
                    
                }
            }.start();
            /*while (acabou==false){
                try {
                     Thread.sleep(10);
                 } catch (InterruptedException ex) {
                    Logger.getLogger(TransicaoSala.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/
        } catch (Exception ex) {
           System.out.print(ex);
        }
        
        
    }
    
}
