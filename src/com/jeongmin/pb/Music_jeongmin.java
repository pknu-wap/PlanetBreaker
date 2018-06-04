package com.jeongmin.pb;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music_jeongmin {
	String file;
	
	Clip clip;
	
	Music_jeongmin(String file){
		this.file = file;
	}
	
	public void Sound(boolean Loop) {
		   try {
			   AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
			   clip = AudioSystem.getClip();
			   clip.open(ais);
			   clip.start();
			   if(Loop)clip.loop(-1);//Loop 값이 true면 사운드재생을 무한반복, false면 한번만 재생
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   
		   
	   }
	
	public void StopSound() {
		clip.stop();
	}
	
}
