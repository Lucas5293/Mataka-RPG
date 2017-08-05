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
public class Vampiro extends ClassesJogaveis{
    public boolean firstAttack=true;
    
    public Vampiro(){
        hp=150;
        cp=6;    
        sprite = "vampiro";
        loadSprite(sprite+"Dir.png");
    }
}
