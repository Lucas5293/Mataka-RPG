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
public class Humano extends Inimigos{
   public Humano(){
        cp = 5;
        hp =  100;
        sprite = "motumbo";
        loadSprite(sprite);
        drawSprite();
    }
}
