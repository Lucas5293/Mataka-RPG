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
public class Bacon extends Consumiveis      
{    
    public Bacon(){
        nome = "Bacon";
        sprite="Bacon.png";
        descri="+10 HP";
        loadSprite(vazio);
        drawSprite();
    }
    public void efeito()
    {
       Controlador.Principal.person.hp += 10;
       
    }
}
