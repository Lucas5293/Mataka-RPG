/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javazoom.jl.player.Player;


/**
 *
 * @author lucas
 */
public class Musica {
        
	private InputStream  music;
	public Player player;
        public int executando = 0;
        
	public Musica(InputStream music){
		this.music = music;
	}

	public void play(){
		try{
                        
			//FileInputStream stream = new FileInputStream(music);
			BufferedInputStream buffer = new BufferedInputStream(music);
			this.player = new Player (buffer);
                        executando = 1;
			this.player.play();
                        if (executando !=0)
                            executando= -1;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
    
}
