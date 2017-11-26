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
public class Vampiro extends Inimigos {
       public Vampiro(){
        cp = 6;
        hp =  150;
        sprite = "vampiro";
        loadSprite(sprite);
        drawSprite();
    }
}
