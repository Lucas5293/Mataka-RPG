/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

import Controlador.Principal;

/**
 *
 * @author lucas
 */
public class Venusiano extends ClassesJogaveis {
    
    public Venusiano(){
        if (Principal.mundo.nome.equals("terra"))
            hp=120;    
        else
            hp=200;    
        cp=8;

        sprite = "venusiano";
        loadSprite(sprite+"Dir.png");
    }
}
    
