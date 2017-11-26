/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cenario;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author lucas
 */
public class ImagensCarregadas {
    public BufferedImage arvore1;
    public BufferedImage arvore1V;
    public BufferedImage arvore1P;
    public BufferedImage arvore2;
    public BufferedImage arvore2V;
    public BufferedImage arvore3;
    public BufferedImage arvore3V;
    public BufferedImage arvore4;
    public BufferedImage arvore4V;
    public BufferedImage arvore4P;
    public BufferedImage poco;
    public BufferedImage barraca;
    public BufferedImage pausa;
    public BufferedImage discoVoador;
    public BufferedImage portal;
    public BufferedImage unicornio;
    public BufferedImage unicornioDir;
    public BufferedImage unicornioEsq;
    public BufferedImage unicornioCima;
    public BufferedImage moto;
    public BufferedImage motoDir;
    public BufferedImage motoEsq;
    public BufferedImage motoCima;
    public BufferedImage msg1;
    public BufferedImage msgUni;
    public BufferedImage msgMoto;
    
    public boolean carregou= false;
    
    public void CarregarCenario() throws IOException{
        arvore1 = ImageIO.read(getClass().getResourceAsStream("/Cenario/Imagens/arvore1.png"));        
        arvore1V = ImageIO.read(getClass().getResourceAsStream("/Cenario/Imagens/arvore1V.png"));
        arvore1P = ImageIO.read(getClass().getResourceAsStream("/Cenario/Imagens/arvore1P.png"));
        arvore2 = ImageIO.read(getClass().getResourceAsStream("/Cenario/Imagens/arvore2.png"));
        arvore2V = ImageIO.read(getClass().getResourceAsStream("/Cenario/Imagens/arvore2V.png"));
        arvore3 = ImageIO.read(getClass().getResourceAsStream("/Cenario/Imagens/arvore3.png"));
        arvore3V = ImageIO.read(getClass().getResourceAsStream("/Cenario/Imagens/arvore3V.png"));
        arvore4 = ImageIO.read(getClass().getResourceAsStream("/Cenario/Imagens/arvore4.png"));        
        arvore4V = ImageIO.read(getClass().getResourceAsStream("/Cenario/Imagens/arvore4V.png"));
        arvore4P = ImageIO.read(getClass().getResourceAsStream("/Cenario/Imagens/arvore4P.png"));
        poco = ImageIO.read(getClass().getResourceAsStream("/Cenario/Imagens/poco.png"));
        barraca = ImageIO.read(getClass().getResourceAsStream("/Cenario/Imagens/barraca.png"));
        pausa = ImageIO.read(getClass().getResourceAsStream("/Controlador/Imagens/pausa.png"));
                
        discoVoador = ImageIO.read(getClass().getResourceAsStream("/veiculos/Imagens/disco.png"));
        portal = ImageIO.read(getClass().getResourceAsStream("/veiculos/Imagens/portal.png"));
        unicornio = ImageIO.read(getClass().getResourceAsStream("/veiculos/Imagens/unicornio.png"));
        unicornioDir = ImageIO.read(getClass().getResourceAsStream("/veiculos/Imagens/unicornioDir.png"));
        unicornioEsq = ImageIO.read(getClass().getResourceAsStream("/veiculos/Imagens/unicornioEsq.png"));
        unicornioCima = ImageIO.read(getClass().getResourceAsStream("/veiculos/Imagens/unicornioCima.png"));
        moto = ImageIO.read(getClass().getResourceAsStream("/veiculos/Imagens/moto.png"));
        motoDir = ImageIO.read(getClass().getResourceAsStream("/veiculos/Imagens/motoDir.png"));
        motoEsq = ImageIO.read(getClass().getResourceAsStream("/veiculos/Imagens/motoEsq.png"));
        motoCima = ImageIO.read(getClass().getResourceAsStream("/veiculos/Imagens/motoCima.png"));
        
        msg1 = ImageIO.read(getClass().getResourceAsStream("/Controlador/Imagens/msg1.png"));
        msgUni = ImageIO.read(getClass().getResourceAsStream("/Controlador/Imagens/msgUni.png"));
        msgMoto = ImageIO.read(getClass().getResourceAsStream("/Controlador/Imagens/msgMoto.png"));
        carregou = true;
    }
    
}
