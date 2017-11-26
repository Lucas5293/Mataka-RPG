/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculos;

import Controlador.Principal;

/**
 *
 * @author Rafael
 */
public class Unicornio extends Veiculos
{
    public Unicornio(){
        img = Principal.imagens.unicornio;
        imgDir = Principal.imagens.unicornioDir;
        imgEsq = Principal.imagens.unicornioEsq;
        imgC = Principal.imagens.unicornioCima;
        draw();
    }
}
