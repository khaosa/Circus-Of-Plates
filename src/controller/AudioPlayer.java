/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
    
    private String path;
    private static AudioPlayer instance; //singleton audioplayer
    
    private AudioPlayer(String path){
        this.path = path;
    }
    
    public static AudioPlayer getInstance(String path){
        if(instance == null){
            instance = new AudioPlayer(path);
        }
        else{
            instance.path = path;
        }
        
        return instance;
    }

    public void play(){

        try {
            
            File audioFile = new File(path).getAbsoluteFile();
            AudioInputStream audioInputStream;
            audioInputStream = AudioSystem.getAudioInputStream(audioFile); 
            Clip clip;
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            //Plays audio once
            clip.start();
            
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}