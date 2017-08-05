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
public class Tiara extends Arma
{
    
    public Tiara(){
        nome = "Tiara";
        dano = 0;
        ativo = false;
        sprite="Tiara.png";
        descri = "Arma só pra sujeito homem";
        loadSprite(vazio);
        drawSprite();
    }
}
