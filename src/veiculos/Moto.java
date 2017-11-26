/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculos;

import Controlador.Principal;

/**
 *
 * @author lucas
 */
public class Moto extends Veiculos {
     public Moto(){
        img = Principal.imagens.moto;
        imgDir = Principal.imagens.motoDir;
        imgEsq = Principal.imagens.motoEsq;
        imgC = Principal.imagens.motoCima;
        draw();
    }
}
