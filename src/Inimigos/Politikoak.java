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
public class Politikoak extends Inimigos {
    
    public Politikoak(){
         hp=100;//100
         cp=5;//5
         sprite = "politico";
         loadSprite(sprite);
        drawSprite();
        
    }
             
}
