package view;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;



public class Sounds {
	static Clip clip=null;
	static int clipSize;
	public static boolean MusicOn=true;
	public static float vol=0;
	public static synchronized void playSound() {
		  new Thread(new Runnable() {
		  
		    public void run() {
		      try {
		        clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		          Main.class.getResourceAsStream("/b.WAV"));
		          
		          clip.open(inputStream);
		          
		          Sounds.clipSize=(int) (clip.getMicrosecondLength()/1000);
		          clip.start();
		          
		      
		        } 
		      
		       catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start();
		}


	public static synchronized void playLoopSound() {
		  new Thread(new Runnable() {
		  
		    public void run() {
		      try {
		        clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		          Main.class.getResourceAsStream("/b.WAV"));
		          
		          clip.open(inputStream);
		          
		          Sounds.clipSize=(int) (clip.getMicrosecondLength()/1000);
		          //clip.start();
		          clip.loop(Clip.LOOP_CONTINUOUSLY);
		      
		        } 
		      
		       catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start();
		}
}
