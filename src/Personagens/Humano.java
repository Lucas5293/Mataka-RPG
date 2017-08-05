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
public class Humano extends ClassesJogaveis{
    
    public Humano(){
        hp=100;//100
        cp=5;
        sprite="motumbo";
        loadSprite(sprite+"Dir.png");
    }
             
}
