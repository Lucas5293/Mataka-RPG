/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Inimigos.Dragonite;
import Inimigos.Elfo;
import Inimigos.Humano;
import Inimigos.Inimigos;
import Inimigos.Marciano;
import Inimigos.Politikoak;
import Inimigos.Traal;
import Inimigos.Vampiro;
import Inimigos.Venusiano;
import Inimigos.Zumbi;
import armas.Adaga;
import armas.Arma;
import armas.ArmaLaser;
import armas.EspadaFogo;
import armas.Katana;
import armas.Tiara;
import armas.Tunica;
import consumiveis.Bacon;
import consumiveis.BaconLunar;
import consumiveis.Barras;
import consumiveis.Brigadeiro;
import consumiveis.Consumiveis;
import consumiveis.Dinamite;
import consumiveis.Drink;
import java.util.ArrayList;
import java.util.Random;
import veiculos.DiscoVoador;
import veiculos.Moto;
import veiculos.Portal;
import veiculos.Unicornio;


/**
 *
 * @author lucas
 */
public class MapaAleatorio{
    public Random aleatorio = new Random();
    public ArrayList<Consumiveis> listConsu = new ArrayList<>();
    public ArrayList<Arma> listArm = new ArrayList<>();
    public ArrayList<Inimigos> listIni = new ArrayList<>();
    public DiscoVoador disco = null;
    public Portal portal = null; 
    public Unicornio unicornio = null;
    public Moto moto = null;
    public Sprite sImg;
    
    
    public MapaAleatorio() {
        sImg = new Controlador.Sprite(Principal.mundo.background, 0 ,0);
        Principal.GUI.add(sImg);
        //aleatorio = new Random();
    }
    public void distribuirItens(){
       
        int nItens = aleatorio.nextInt(3);
 
        
        for(int a=0; a<nItens; a++){
            int item = aleatorio.nextInt(6);
            int _x = aleatorio.nextInt(700)+50;
            int _y = aleatorio.nextInt(400)+50;
            Consumiveis obj;
            switch(item){
                case 0: {obj = new Bacon();break;}
                case 1: {obj = new BaconLunar();break;}
                case 2: {obj = new Barras();break;}
                case 3: {obj = new Brigadeiro();break;}
                case 4: {obj = new Dinamite();break;}
                case 5: {obj = new Drink();break;}
                default: {obj = new Bacon(); break;}
            }
            obj.sImg.x = _x;
            obj.sImg.y = _y;
            listConsu.add(obj);
            //Principal.GUI.repaint();
        }
                
    }
    
    public void distribuirArmas(){
        int possibilidade = aleatorio.nextInt(5);
        
        if (possibilidade==1){  
            Arma obj;
            int arma = aleatorio.nextInt(6);
            int _x = aleatorio.nextInt(700)+50;
            int _y = aleatorio.nextInt(400)+50;
            switch(arma){
                case 0: { obj = new ArmaLaser(); break;}
                case 1: { obj = new EspadaFogo(); break;}
                case 2: { 
                    if (!Principal.person.sprite.equals("zumbi")){
                        obj = new Katana(); break;
                    }
                }
                case 3: { obj = new Tiara(); break;}
                case 4: { obj = new Tunica(); break;}   
                case 5: { obj = new Adaga(); break;}   
                default: {obj = new Tunica(); System.out.println("COnfere ai"); break;}
            }
            
            obj.sImg.x= _x;
            obj.sImg.y= _y;
            listArm.add(obj);
            //Principal.GUI.repaint();
        }       
    }
    
    public void distribuirInimigos(){
        int numero = aleatorio.nextInt(3);
        for (int cont =0; cont<numero; cont++){
            if (aleatorio.nextInt(2)==1){
                Inimigos obj;
                int arma = aleatorio.nextInt(10);
                int _x = aleatorio.nextInt(780);
                int _y = aleatorio.nextInt(540);
                switch(arma){
                    case 0: { obj = new Dragonite(); break;}
                    case 1: { obj = new Politikoak(); break;}
                    case 2: { obj = new Traal(); break;}//3
                    case 3: { obj = new Dragonite(); break;}
                    case 4: { obj = new Elfo(); break;}
                    case 5: { obj = new Humano(); break;}
                    case 6: { obj = new Marciano(); break;}
                    case 7: { obj = new Vampiro(); break;}
                    case 8: { obj = new Venusiano(); break;}
                    case 9: { obj = new Zumbi(); break;}
                    default: { obj = new Dragonite(); break;}
                }

                obj.sImg.x= _x;
                obj.sImg.y= _y;
                listIni.add(obj);
                obj.atacar();
            }
        }
        int possibilidade = aleatorio.nextInt(20);
        //possibilidade=1;
        if (possibilidade==1){
            disco = new DiscoVoador();
            disco.sImg.x = aleatorio.nextInt(700)+50;
            disco.sImg.y = aleatorio.nextInt(400)+50;
        }
        
        possibilidade = aleatorio.nextInt(20);
        //possibilidade=1;
        if (possibilidade==1){
            portal = new Portal();
            portal.sImg.x = aleatorio.nextInt(700)+50;
            portal.sImg.y = aleatorio.nextInt(400)+50;
        }
        
         possibilidade = aleatorio.nextInt(20);
        
        if (possibilidade==1 && Principal.mundo.nome.equals("terra")){
            unicornio = new Unicornio();
            unicornio.sImg.x = aleatorio.nextInt(700)+50;
            unicornio.sImg.y = aleatorio.nextInt(400)+50;
        }
        possibilidade = aleatorio.nextInt(20);
        
        if (possibilidade==1){
            moto = new Moto();
            moto.sImg.x = aleatorio.nextInt(700)+50;
            moto.sImg.y = aleatorio.nextInt(400)+50;
        }
    }
    public void destroirInimigos(){
        for (Inimigos a: listIni){
            a.ativo = false;
        }
    }
    
    public void novo(){
        destroirInimigos();
        sImg.img = Principal.mundo.background;
        Principal.GUI.add(sImg);
        listConsu.clear();
        listArm.clear();
        listIni.clear();
        disco = null;
        portal = null; 
        moto = null;
        unicornio = null;
    }

}
