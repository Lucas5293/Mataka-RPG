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
import java.util.Random;

public class Drink extends Consumiveis
{    
    public Drink(){
        nome = "Drink";
        sprite="Drink.png";
        descri="+4 CP ou -50 HP";
        loadSprite(vazio);
        drawSprite();
    }
    public void efeito()
    {
        Random rand = new Random();
        int x = rand.nextInt(10);
        if(x < 5)
        {
     //       personagem.cp += 4;
        }
        else
        {
       //     personagem.hp -= 50;
        }
    }
}
