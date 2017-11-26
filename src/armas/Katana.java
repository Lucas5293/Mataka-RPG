/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armas;
import Personagens.Zumbi;

/**
 *
 * @author Rafael
 */
public class Katana extends Arma
{   
    public Katana(){
        nome = "Katana";
        dano = 30;
        ativo = false; 
        sprite="Katana.png";
        descri = "Afiada como agulha";
        loadSprite(vazio);
        drawSprite();
    }
    
    public void test()
    {
        if(Controlador.Principal.person.tipo != "Zumbi")
        {
            ativo = true; 
        }
    }
    
    public void habilidade()
    {
        if(ativo == true)
        {
           Controlador.Principal.person.cp += dano;
        }
    }
    
    
}
