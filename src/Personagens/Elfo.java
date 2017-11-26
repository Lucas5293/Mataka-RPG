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
public class Elfo extends ClassesJogaveis{
    
    public Elfo(){
        hp=450;
        cp=9;
        sprite = "elfo";
        loadSprite(sprite+"Dir.png");
    }
}
