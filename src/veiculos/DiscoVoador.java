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
public class DiscoVoador
{
    public Controlador.Sprite sImg;
    
    public DiscoVoador(){
        sImg = new Controlador.Sprite(Principal.imagens.discoVoador, 0, 0);
        Principal.GUI.add(sImg);
    }
}
