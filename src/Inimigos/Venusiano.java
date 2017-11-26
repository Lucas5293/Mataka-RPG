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
public class Venusiano extends Inimigos{
    public Venusiano(){
        cp =8;
        hp =  120;
        sprite = "venusiano";
        loadSprite(sprite);
        drawSprite();
    }
}
