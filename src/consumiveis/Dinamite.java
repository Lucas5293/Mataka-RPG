/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumiveis;

/**
 *
 * @author Rafael
 */
public class Dinamite extends Consumiveis
{    
    public Dinamite(){
        nome="Dinamite";
        sprite="Dinamite.png";
        descri="+30 HP e +17 CP";
        loadSprite(vazio);
        drawSprite();
    }
    public void efeito()
    {
       // personagem.hp += 30;
        //personagem.cp += 17;
    }    
}
