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
public class BaconLunar extends Consumiveis
{    
    public BaconLunar(){
        nome = "Bacon Lunar";
        usavel = true;
        sprite="BaconLunar.png";
        descri="+4 HP";
        loadSprite(vazio);
        drawSprite();
    }
    
    public void efeito()
    {
        if(usavel == true)
        {
            Controlador.Principal.person.hp += 4;
        }
        usavel = false;
    }
    
}
