package com.jeongmin.pb;

import java.awt.*;
import javax.swing.*;

public class Main {
	Field field;
	Ball ball;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	Main(){
		field = new Field(320,240);			//鞘靛 积己
		//ball = new Ball(field);				//傍 积己
		
		JPanel pan = new JPanel(null);
		pan.setBackground(Color.BLACK);
		pan.add(field);
		field.setLocation(20,10);
		
		JFrame f = new JFrame("Planet Breaker");
		f.getContentPane().add(pan);
		f.setSize(385, 300);
		f.setVisible(true);
		f.setResizable(false);
		while(true)
		{
			f.repaint();
			try {Thread.sleep(20);}catch(Exception e) {}
		}
	}

}
