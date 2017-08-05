/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cenario;

import Controlador.Principal;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lucas
 */
public class Enfeites {
    
    public ArrayList<Arvore> arvores = new ArrayList<>();
    
    public Poco poco = null;
    
    public Enfeites(){        
    }
    public void pocas(){
        if (!Principal.mundo.nome.equals("venus")){
            Random aleatorio = new Random();

            int a  = aleatorio.nextInt(6);
            if (a<4)
            {
                for (int e=0; e<a-1; e++){
                    Poca s =new Poca();
                    s.sImg.x=aleatorio.nextInt(750);
                    s.sImg.y=aleatorio.nextInt(520);
                }
            }
        }
    }
    public void distribuir(){
        Random aleatorio = new Random();
        
        int a  = aleatorio.nextInt(5);
        
        for (int e=0; e<a; e++){
            int x=aleatorio.nextInt(750);
            int y=aleatorio.nextInt(520);
            Arvore s =new Arvore();
            s.sImg.x=x;
            s.sImg.y=y;
            arvores.add(s);
        }
        
        a  = aleatorio.nextInt(10);
        
        
        if (a==1){
            poco = new Poco();
            poco.sImg.x = aleatorio.nextInt(700)+50;
            poco.sImg.y = aleatorio.nextInt(400)+50;
        }
    }
    
}
