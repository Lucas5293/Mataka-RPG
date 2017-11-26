/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

/**
 *
 * @author lucas
 */
public class Marciano extends ClassesJogaveis{    
    public Marciano(){
        hp= 200;
        cp = 6.5;
        sprite = "marciano";
        loadSprite(sprite+"Dir.png");
    }
}
