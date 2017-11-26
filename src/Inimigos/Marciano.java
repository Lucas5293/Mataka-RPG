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
public class Marciano extends Inimigos{
       public Marciano(){
        cp = 6.5;
        hp =  200;
        sprite = "marciano";
        loadSprite(sprite);
        drawSprite();
    }
    
}
