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
public class Tunica extends Arma
{    
    public Tunica(){
        nome = "Tunica";
        dano = 0;
        ativo = false;
        sprite="Tunica.png";
        descri = "Te deixa invencível por 3 turnos";
        loadSprite(vazio);
        drawSprite();
    }
}
