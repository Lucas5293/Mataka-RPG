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
public class EspadaFogo extends Arma
{
    
    public EspadaFogo(){
        nome = "Espada de Fogo";
        dano = 8;
        ativo = false;
        sprite="EspadaFogo.png";
        descri="Arma cortante pakas";
        loadSprite(vazio);
        drawSprite();
    }
    public void test()
    {
        ativo = true;
    }
    
    public void habilidade()
    {
        if(ativo == true)
        {
           Controlador.Principal.person.cp += 8;
        }
    }
    
}
