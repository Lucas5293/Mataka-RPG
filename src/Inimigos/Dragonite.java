/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inimigos;

import Controlador.Principal;

/**
 *
 * @author carlo
 */
public class Dragonite extends Inimigos{
    
    public Dragonite(){
        cp = 10;
        hp =  150;//150
        sprite = "dragonite";
        loadSprite(sprite);
        drawSprite();
        
    }
    
}
