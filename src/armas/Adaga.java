/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armas;

/**
 *
 * @author lucas
 */
public class Adaga extends Arma{
      public Adaga(){
        nome = "Adaga";
        dano = 10;
        ativo = false;
        sprite="adaga.png";
        descri="Serve para matar zumbis";
        loadSprite(vazio);
        drawSprite();
    }
    
}
