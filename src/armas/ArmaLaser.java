/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armas;

/**
 *
 * @author Rafael
 */
public class ArmaLaser extends Arma
{
   
    
    public ArmaLaser(){
        nome = "Arma Laser";
        dano = 5;
        ativo = false;
        sprite="ArmaLaser.png";
        descri="Raio penetrante/cortante";
        loadSprite(vazio);
        drawSprite();
    }
}
