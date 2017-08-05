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
public class Brigadeiro extends Consumiveis
{   
    public Brigadeiro(){
        nome="Brigadeiro";
        sprite="Brigadeiro.png";
        descri="+30 HP";
        loadSprite(vazio);
        drawSprite();
    }
    public void efeito()
    {
       // personagem.hp += 30;
    }
    
}
