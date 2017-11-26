package Controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 */
import Cenario.ImagensCarregadas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import CronoBattle.Battle;
import Inimigos.Inimigos;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * This class demonstrates how to load an Image from an external file
 */
public class Principal extends Component{
    public static JFrame f;
    public static ControladorGUI GUI;
    public static Personagens.ClassesJogaveis person;
    public static MapaAleatorio map;
    public static Mundos mundo;
    public static Battle bt;
    public static Colisao colisao;
    public static Pega pega;
    public static Cenario.Enfeites enfeites;
    public static String nome;
    public static int opcaoP;
    public static Apresentacao apresentacao;
    public static Random aleatorio = new Random();
    public static Musica musica;
    public static Hud hud;
    public static ImagensCarregadas imagens;
    
    public void start(){
        f = new JFrame("Mataka");
        bt = new Battle();
        pega = new Pega();
        colisao = new Colisao();
        hud = new Hud();
        
        bt.setVisible(false);
            
        f.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        f.getContentPane().setBackground(Color.BLACK);
        f.setPreferredSize(new Dimension(800,600));
        f.setMaximumSize(new Dimension(800,600));
        f.setMinimumSize(new Dimension(800,600));
        f.setLocationRelativeTo(null);  
        f.setUndecorated(true);
        f.setVisible(true);
        
        GUI = new ControladorGUI();      
        
        f.add(GUI);
        f.pack();
                
        apresentacao = new Apresentacao();
        f.addKeyListener(apresentacao);
        //Apresentacao irá chamar o Iniciar Jogo após o fim da animação
    }
     
    public static void iniciarJogo() {
        f.removeKeyListener(apresentacao);
        GUI.spr.clear();
        GUI.txt.clear();
        
        
        mundo = new Mundos("terra");
        
        switch(opcaoP){
            case 0: {
                person =new Personagens.Humano();
                break;
            }
            case 1: {
                person =new Personagens.Marciano();
                break;
            }                
            case 2: {
                person =new Personagens.Elfo();
                break;
            }
            case 3: {
                person =new Personagens.Venusiano();
                break;
            }
            case 4: {
                person =new Personagens.Vampiro();
                break;
            }
            case 5: {
                person =new Personagens.Zumbi();
                break;
            }
            default: {
                person =new Personagens.Humano();
                break;
            }
        }
        playMusic();
        monitoraMusica();
        
        map = new MapaAleatorio();
        
        enfeites = new Cenario.Enfeites();
        enfeites.pocas();
        
        map.distribuirArmas();
        map.distribuirItens();
        
        new Cenario.Barraca();
        
        person.drawSprite();
        person.monitorarColisao();
        
        enfeites.distribuir();

        f.addKeyListener(person);
        f.addMouseListener(hud);
        
        hud.drawSprite();
        f.pack();

        new Mensagem(imagens.msg1);
    }
    public static void restart(){
            GUI.spr.clear();
            GUI.txt.clear();
            
           
            map.novo();
            
            enfeites.arvores.clear();
            enfeites.poco = null;
            enfeites.pocas();
            
            map.distribuirArmas();
            map.distribuirItens();
            map.distribuirInimigos();
            
            
            
            
            person.drawSprite();
            enfeites.distribuir();
            
            
            
            hud.drawSprite();
            //GUI.repaint();
            
            //f.pack();
            
    }  
    
    public static void pausa(){
        person.podeMovimentar=false;
        for (Inimigos a : map.listIni){
            a.podeMovimentar=false;
        }
    }
    public static void retoma(){
        GUI.txt.clear();
        person.podeMovimentar=true;
        for (Inimigos a : map.listIni){
            a.podeMovimentar=true;
        }
        hud.drawBarras();
        hud.drawLevel();
        hud.drawItens();
    }
    public static void playMusic(){
        
        switch(aleatorio.nextInt(13)){
            case 0:
                musica = new Musica(aleatorio.getClass().getResourceAsStream("/Controlador/Musicas/musica1.mp3"));
                break;
            case 1:
                musica = new Musica(aleatorio.getClass().getResourceAsStream("/Controlador/Musicas/musica2.mp3"));
                break;
            case 2:
                musica = new Musica(aleatorio.getClass().getResourceAsStream("/Controlador/Musicas/musica3.mp3"));
                break;
            case 3:
                musica = new Musica(aleatorio.getClass().getResourceAsStream("/Controlador/Musicas/musica4.mp3"));
                break;
            case 4:
                musica = new Musica(aleatorio.getClass().getResourceAsStream("/Controlador/Musicas/musica5.mp3"));
                break;
            case 5:
                musica = new Musica(aleatorio.getClass().getResourceAsStream("/Controlador/Musicas/musica6.mp3"));
                break;
            case 6:
                musica = new Musica(aleatorio.getClass().getResourceAsStream("/Controlador/Musicas/musica7.mp3"));
                break;
            case 7:
                musica = new Musica(aleatorio.getClass().getResourceAsStream("/Controlador/Musicas/musica8.mp3"));
                break;
            case 8:
                musica = new Musica(aleatorio.getClass().getResourceAsStream("/Controlador/Musicas/musica9.mp3"));
                break;
             case 9:
                musica = new Musica(aleatorio.getClass().getResourceAsStream("/Controlador/Musicas/musica10.mp3"));
                break;
            case 10:
                musica = new Musica(aleatorio.getClass().getResourceAsStream("/Controlador/Musicas/musica11.mp3"));
                break;
            case 11:
                musica = new Musica(aleatorio.getClass().getResourceAsStream("/Controlador/Musicas/musica12.mp3"));
                break;
            case 12:
                musica = new Musica(aleatorio.getClass().getResourceAsStream("/Controlador/Musicas/musica13.mp3"));
                break;
            default:
                musica = new Musica(aleatorio.getClass().getResourceAsStream("/Controlador/Musicas/musica13.mp3"));
                break;
        }
        new Thread(){
            public void run(){
                musica.play();
            }
                    
        }.start();
    }
    public static void monitoraMusica(){
        new Thread(){
            public void run(){
                while (true){
                    if (musica.executando==-1)
                        playMusic();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
        
    }
    public static void pararMusica(){
        musica.executando = 0 ;
        musica.player.close();
    }
}

