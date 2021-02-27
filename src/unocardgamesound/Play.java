/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unocardgamesound;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;


public class Play {
    
     public void play(String musicLocation){
        try
        {
        
            File musicPath = new File(musicLocation);
            if(musicPath.exists())
            {
		AudioInputStream AudioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.start();//daemon thread
                clip.open(AudioInput);
                clip.start();
                clip.open(AudioInput); 
            }
      
	}
	catch(Exception ex)
	{
            ex.printStackTrace();
	}
    }
     
     
}

    

