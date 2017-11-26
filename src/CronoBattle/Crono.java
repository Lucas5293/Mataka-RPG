/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CronoBattle;

import Controlador.Principal;

/**
 *
 * @author Rafael
 */
public class Crono 
{
    public int segundos = 0;
    public int minutos = 0;
    
    public void rodar()
    {
        new Thread(){
            public void run(){
            while(true)
                {
                    try
                    {
                      Thread.sleep(1000);
                      segundos += 1;
                      if(segundos == 60)
                      {
                          minutos += 1;
                          segundos = 0;
                      }
                      Principal.bt.atualizar();
                      Principal.bt.repaint();
                    }
                    catch(Exception a)
                    {
                        System.out.println("EX");
                    }
                }
            }
        }.start();
    }
}
