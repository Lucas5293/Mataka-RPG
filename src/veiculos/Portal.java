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
public class Portal {
    public Controlador.Sprite sImg;
    
    public Portal(){
        sImg = new Controlador.Sprite(Principal.imagens.portal, 0, 0);
        Principal.GUI.add(sImg);
    }
    
}
