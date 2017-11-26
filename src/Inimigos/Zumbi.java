/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inimigos;

/**
 *
 * @author lucas
 */
public class Zumbi extends Inimigos{
       public Zumbi(){
        cp = 4.5;
        hp =  60;
        sprite = "zumbi";
        loadSprite(sprite);
        drawSprite();
    }
    
}
