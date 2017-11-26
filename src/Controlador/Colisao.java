/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Cenario.Arvore;
import Cenario.Poco;
import Personagens.ClassesJogaveis;
import consumiveis.Consumiveis;
import armas.Arma;
import veiculos.DiscoVoador;
import veiculos.Portal;
import veiculos.Veiculos;

/**
 *
 * @author lucas
 */
public class Colisao {
    public ClassesJogaveis p = Principal.person;
    public TransicaoSala transi = new TransicaoSala();
    
    public Arma colidiuArma(){
        p = Principal.person;
        if (Principal.map.listArm.size()>=1){
            for (Arma a: Principal.map.listArm){
                if ((p.sImg.x + p.sImg.img.getWidth() >= a.sImg.x-2) && (p.sImg.x <= a.sImg.x + a.sImg.img.getWidth()) &&
                    (p.sImg.y + p.sImg.img.getHeight() >= a.sImg.y-2) && (p.sImg.y <= a.sImg.y + a.sImg.img.getHeight()))
                    return a;
//return a;
            }
        }
        return null;
    }
    public Consumiveis colidiuItem(){
        p = Principal.person;
        if (Principal.map.listConsu.size()>=1){
            for (Consumiveis a: Principal.map.listConsu){
                if ((p.sImg.x + p.sImg.img.getWidth() >= a.sImg.x-2) && (p.sImg.x <= a.sImg.x + a.sImg.img.getWidth()) &&
                    (p.sImg.y + p.sImg.img.getHeight() >= a.sImg.y-2) && (p.sImg.y <= a.sImg.y + a.sImg.img.getHeight()))
                    return a;
            }
        }
        return null;
    }
    public void colidiuBorda(){
        p = Principal.person;
        
        if (p.sImg.x<=0){
            p.sImg.x=780 - p.sImg.img.getWidth();
            p.x=p.sImg.x;
            p.y=p.sImg.y;
            transi.vai("D");
            Principal.restart();
        }
        else if (p.sImg.x+(p.sImg.img.getWidth())>=800){
            p.sImg.x=20;
            p.x=p.sImg.x;
            p.y=p.sImg.y;
            transi.vai("E");
            Principal.restart();            
        }
        else if (p.sImg.y<=0){
            p.sImg.y=450;
            p.x=p.sImg.x;
            p.y=p.sImg.y;
            transi.vai("B");
            Principal.restart();
        }
        else if (p.sImg.y+(p.sImg.img.getHeight())>=560){
            p.sImg.y=20;
            p.x=p.sImg.x;
            p.y=p.sImg.y;
            transi.vai("C");
            Principal.restart();           
        }
    }
    
    public boolean colidiuPoco(){
        if (Principal.enfeites.poco == null)
            return false;
        else
        {
            Poco a = Principal.enfeites.poco;
            if ((p.sImg.x + p.sImg.img.getWidth() >= a.sImg.x) && (p.sImg.x <= a.sImg.x + a.sImg.img.getWidth()) &&
                   (p.sImg.y + p.sImg.img.getHeight() >= a.sImg.y) && (p.sImg.y <= a.sImg.y + a.sImg.img.getHeight()))
                return true;
            else
                return false;
            
        }
    }
    public boolean colidiuDiscoVoador(){
        if (Principal.map.disco == null)
            return false;
        else
        {
            DiscoVoador a = Principal.map.disco;
            if ((p.sImg.x + p.sImg.img.getWidth() >= a.sImg.x) && (p.sImg.x <= a.sImg.x + a.sImg.img.getWidth()) &&
                   (p.sImg.y + p.sImg.img.getHeight() >= a.sImg.y) && (p.sImg.y <= a.sImg.y + a.sImg.img.getHeight()))
                return true;
            else
                return false;
            
        }
    }
    public boolean colidiuPortal(){
        if (Principal.map.portal == null)
            return false;
        else
        {
            Portal a = Principal.map.portal;
            if ((p.sImg.x + p.sImg.img.getWidth() >= a.sImg.x) && (p.sImg.x <= a.sImg.x + a.sImg.img.getWidth()) &&
                   (p.sImg.y + p.sImg.img.getHeight() >= a.sImg.y) && (p.sImg.y <= a.sImg.y + a.sImg.img.getHeight()))
                return true;
            else
                return false;
            
        }
    }
    
    public boolean colidiuVeiculo(int modo){
        if (modo ==0 && Principal.map.unicornio == null)
            return false;
        if (modo !=0 && Principal.map.moto == null)
            return false;
        else
        {
            Veiculos a;
            if (modo==0)
                a= Principal.map.unicornio;
            else
                a= Principal.map.moto;
            if ((p.sImg.x + p.sImg.img.getWidth() >= a.sImg.x) && (p.sImg.x <= a.sImg.x + a.sImg.img.getWidth()) &&
                   (p.sImg.y + p.sImg.img.getHeight() >= a.sImg.y) && (p.sImg.y <= a.sImg.y + a.sImg.img.getHeight()))
                return true;
            else
                return false;
            
        }
    }
    
    
    public Object colidiuCenario(){
        p = Principal.person;
        if (Principal.enfeites.arvores.size()>=1){
            for (Arvore a: Principal.enfeites.arvores){
                if ((p.sImg.x + p.sImg.img.getWidth() >= a.sImg.x) && (p.sImg.x <= a.sImg.x + a.sImg.img.getWidth()) &&
                    (p.sImg.y + p.sImg.img.getHeight() >= a.sImg.y) && (p.sImg.y <= a.sImg.y + a.sImg.img.getHeight()))
                    return a;
            }
        }
        return null;
    }
    
    
    public boolean colidiEsq(){
        Object a = colidiuCenario();

        if (a==null)
            return false;
        else
        {
            if (a instanceof Arvore){
                Arvore c = (Arvore) a;
                if ((c.sImg.x + (c.sImg.img.getWidth()/2) >= p.sImg.x ) &&
                        (p.sImg.x >= c.sImg.x + (c.sImg.img.getWidth()/2) - 5) &&
                            (p.sImg.y >= c.sImg.y + 10)  &&
                                (p.sImg.y <= c.sImg.y + (c.sImg.img.getHeight()/1.2)))
                    return true;               
            }
            
        }
            return false;
    }
    
    public boolean colidiDir(){
        Object a = colidiuCenario();

        if (a==null)
            return false;
        else
        {
            if (a instanceof Arvore){
                Arvore c = (Arvore) a;
                if ((c.sImg.x - 2 <= p.sImg.x + (p.sImg.img.getWidth()/2)) &&
                        (p.sImg.x + (p.sImg.img.getWidth()/2) <= c.sImg.x + 5)   &&
                            (p.sImg.y >= c.sImg.y + 10)  &&
                                (p.sImg.y <= c.sImg.y + (c.sImg.img.getHeight()/1.2)))
                    
                    return true;
            }
        }
            return false;
    }
    public boolean colidiCima(){
        Object a = colidiuCenario();

        if (a==null)
            return false;
        else
        {
            if (a instanceof Arvore){
                Arvore c = (Arvore) a;
                if ((p.sImg.y <= c.sImg.y + 2 +(c.sImg.img.getHeight()/1.2)) &&
                        (p.sImg.y >= c.sImg.y-5 + (c.sImg.img.getHeight()/1.2)) &&
                            (p.sImg.x + (p.sImg.img.getWidth()/2) >= c.sImg.x - 2 ) &&
                                (p.sImg.x <= c.sImg.x + 2 + (c.sImg.img.getWidth()/2)))
                    return true;
            }
        }
            return false;
    }
    public boolean colidiBaixo(){
        Object a = colidiuCenario();

        if (a==null)
            return false;
        else
        {
            if (a instanceof Arvore){
                Arvore c = (Arvore) a;
                if ((p.sImg.y + (p.sImg.img.getWidth()/1.2) >= c.sImg.y + 2) &&
                        (p.sImg.y + (p.sImg.img.getWidth()/1.2) <= c.sImg.y + 2 +5) &&
                            (p.sImg.x + (p.sImg.img.getWidth()/2) >= c.sImg.x - 2 ) &&
                                (p.sImg.x <= c.sImg.x + 2 + (c.sImg.img.getWidth()/2)))
                    
                    return true;
            }
        }
            return false;
        }
     
    
}
