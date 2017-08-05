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
public class Barras extends Consumiveis
{   
    public Barras(){
        nome = "Barras";
        sprite="Barras.png";
        descri="+7 CP";
        loadSprite(vazio);
        drawSprite();
    }
    public void efeito()
    {
       // personagem.cp += 7;
    }
}
