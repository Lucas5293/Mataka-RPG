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
public class Zumbi extends ClassesJogaveis{
    
    public Zumbi(){
        hp=60;    
        cp=4.5;
        sprite = "zumbi";
        loadSprite(sprite+"Dir.png");
    }
}
