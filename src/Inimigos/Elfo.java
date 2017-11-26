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
public class Elfo extends Inimigos {
    public Elfo(){
        cp = 9;
        hp =  450;
        sprite = "elfo";
        loadSprite(sprite);
        drawSprite();
    }

}
